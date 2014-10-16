/**
 * SpringAwareGrizzlyTestContainerFactory.java    2014-10-16
 */
package com.lyc.zpush.testing;

import java.net.URI;

import org.springframework.context.ApplicationContext;

import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;

/**
 * 
 * @author yuancen.li
 * @since 2014年10月16日  下午1:46:54
 */
public class SpringAwareGrizzlyTestContainerFactory implements
		TestContainerFactory {

	private Object springTarget;

	private SpringAwareGrizzlyWebTestContainer tc;

	public SpringAwareGrizzlyTestContainerFactory(Object springTarget) {
		this.springTarget = springTarget;
	}

	public SpringAwareGrizzlyTestContainerFactory() {
		super();
	}

	public TestContainer create(URI baseUri, AppDescriptor ad) {
		assertWebAppDescriptor(ad);
		tc = new SpringAwareGrizzlyWebTestContainer(baseUri,
				(WebAppDescriptor) ad, springTarget);
		return tc;
	}

	public Class<WebAppDescriptor> supports() {
		return WebAppDescriptor.class;
	}

	private void assertWebAppDescriptor(AppDescriptor ad) {
		if (!(ad instanceof WebAppDescriptor)) {
			throw new IllegalArgumentException(
					"The application descriptor must be an instance of WebAppDescriptor");
		}
	}

	public ApplicationContext getApplicationContext() {
		return tc.getTcContext();
	}
}
