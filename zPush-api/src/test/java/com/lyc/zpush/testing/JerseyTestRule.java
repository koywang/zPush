/**
 * JerseyTestRule.java    2014-10-16
 */
package com.lyc.zpush.testing;

import javax.ws.rs.core.UriBuilder;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;

/**
 * 
 * @author yuancen.li
 * @since 2014年10月16日  下午1:47:37
 */
public class JerseyTestRule implements TestRule{

	private TestContainerFactory tcf;
	
	private TestContainer tc;
	
	private Client c;
	
	private WebAppDescriptor wad;
	

	@Override
	public Statement apply(final Statement base, final Description des) {
		// TODO Auto-generated method stub
		tcf = new SpringAwareGrizzlyTestContainerFactory();
		wad = new WebAppDescriptor.Builder("com.lyc.zpush")
		.contextParam("contextConfigLocation",
				"classpath:/applicationContext-test.xml")
		.servletClass(SpringServlet.class)
		.servletPath("/service/*")
		.initParam(
				"com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig")
		.initParam("com.sun.jersey.config.property.packages",
				"com.lyc.zpush.facade")
		.initParam("com.sun.jersey.api.json.POJOMappingFeature", "true")
		.contextListenerClass(ContextLoaderListener.class)
		.requestListenerClass(RequestContextListener.class).build();
		tc = tcf.create(UriBuilder.fromUri("http://localhost/")
                .port(9998).build(), wad);
		
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				// TODO Auto-generated method stub
				tc.start();
				try {
					base.evaluate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					tc.stop();
				}
			}
		};
	}
	
	public WebResource getWebResource(){
		c = this.getTc().getClient();
		return c.resource(tc.getBaseUri());
	}

	public TestContainer getTc() {
		return tc;
	}	
}
