/**
 * SpringAwareGrizzlyWebTestContainer.java    2014-10-16
 */
package com.lyc.zpush.testing;

import java.io.IOException;
import java.net.URI;
import java.util.EventListener;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.UriBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.ApacheHttpClientConfig;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.WebAppDescriptor.FilterDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

/**
 * 
 * @author yuancen.li
 * @since 2014年10月16日  下午1:47:07
 */
public class SpringAwareGrizzlyWebTestContainer implements TestContainer {
	private static final Logger logger = LoggerFactory.getLogger(SpringAwareGrizzlyWebTestContainer.class);
	private URI baseUri;
	private GrizzlyWebServer webServer;
	private Object springTarget;
	private Servlet servletInstance;

	public SpringAwareGrizzlyWebTestContainer(URI baseUri, WebAppDescriptor ad, Object springTarget) {
		this.springTarget = springTarget;
		this.baseUri = UriBuilder.fromUri(baseUri)
				.path(ad.getContextPath()).path(ad.getServletPath())
				.build();
		
		logger.info("Grizzly容器BaseUri" + this.baseUri);
		instantiateGrizzlyWebServer(ad, springTarget);
	}

	public Client getClient() {
		DefaultApacheHttpClientConfig config = new DefaultApacheHttpClientConfig();
		config.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, true);
		ApacheHttpClient client = ApacheHttpClient.create(config);
		return client;
	}

	public URI getBaseUri() {
		return baseUri;
	}

	public void start() {
		logger.info("Grizzly容器,启动中...");
		try {
			webServer.start();
			//autoWireSpringTarget();
			logger.info("Grizzly容器,启动完成...");
		} catch (IOException ex) {
			throw new TestContainerException(ex);
		}

	}

	public void stop() {
		webServer.stop();
		webServer.getSelectorThread().stopEndpoint();
		logger.info("Grizzly容器,关闭完成...");
	}

	private void instantiateGrizzlyWebServer(WebAppDescriptor ad, Object springTarget) {
		webServer = new GrizzlyWebServer(baseUri.getPort());
		ServletAdapter sa = new ServletAdapter();
		sa.setProperty("load-on-startup", 1);
		servletInstance = createrServletInstance(ad.getServletClass());
		sa.setServletInstance(servletInstance);

		populateEventListeners(sa, ad.getListeners());
		populateFilterDescriptors(sa, ad.getFilters());
		populateContextParams(sa, ad.getContextParams());
		populateInitParams(sa, ad.getInitParams());
		setContextPath(sa, ad.getContextPath());
		setServletPath(sa, ad.getServletPath());

		String[] mapping = null;
		webServer.addGrizzlyAdapter(sa, mapping);

	}

	private void setServletPath(ServletAdapter sa, String servletPath) {
		if ( notEmpty(servletPath)) {
			sa.setServletPath(servletPath);
		}
	}

	private void setContextPath(ServletAdapter sa, String contextPath) {
		if (notEmpty(contextPath)) {
			sa.setContextPath(ensureLeadingSlash(contextPath));
		}
	}

	private boolean notEmpty(String string) {
		return string != null && string.length() > 0;
	}

	private void populateInitParams(ServletAdapter sa, Map<String, String> initParams) {
		for (String initParamName : initParams.keySet()) {
			sa.addInitParameter(initParamName, initParams.get(initParamName));
		}
		
	}

	private void populateContextParams(ServletAdapter sa, Map<String, String> contextParams) {
		for (String contextParamName : contextParams.keySet()) {
			sa.addContextParameter(contextParamName, contextParams.get(contextParamName));
		}
	}

	private void populateFilterDescriptors(ServletAdapter sa, List<FilterDescriptor> filters) {
		if (filters != null) {
			for (WebAppDescriptor.FilterDescriptor d : filters) {
				sa.addFilter(instantiate(d.getFilterClass()), d.getFilterName(), d.getInitParams());
			}
		}

	}

	private void populateEventListeners(ServletAdapter sa, List<Class<? extends EventListener>> listeners) {
		for (Class<? extends EventListener> eventListener : listeners) {
			sa.addServletListener(eventListener.getName());
		}
	}

	private String ensureLeadingSlash(String string) {
		return (string.startsWith("/") ? string : "/".concat(string));
	}

	private Servlet createrServletInstance(Class<? extends HttpServlet> servletClass) {
		return ( servletClass == null ? new SpringServlet() : instantiate(servletClass));
	}
	
	//TODO: this can be done using ReflectUtils
	private <I> I instantiate(Class<? extends I> clazz) {
		I instance = null;
		try {
			instance = clazz.newInstance();
		} catch (InstantiationException e) {
			throw new TestContainerException(e);
		} catch (IllegalAccessException e) {
			throw new TestContainerException(e);
		}
		return instance;
	}

	@Deprecated
	private void autoWireSpringTarget() {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletInstance.getServletConfig()
						.getServletContext());
		AutowireCapableBeanFactory beanFactory = ctx
				.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(springTarget);
	}
	
	public ApplicationContext getTcContext(){
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletInstance.getServletConfig()
						.getServletContext());
		return ctx;
	}
}
