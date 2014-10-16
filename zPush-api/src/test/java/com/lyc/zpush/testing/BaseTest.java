/**
 * AbstractBaseTest.java    2014-10-16
 */
package com.lyc.zpush.testing;

import javax.ws.rs.core.MultivaluedMap;

import org.junit.ClassRule;

import com.sun.jersey.api.client.WebResource;

/**
 * 
 * @author yuancen.li
 * @since 2014年10月16日  下午1:47:15
 */
public abstract class BaseTest {
	 
	@ClassRule
	public static JerseyTestRule jerseyTestRule = new JerseyTestRule();

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T request(MultivaluedMap params, String url, String method,
			Class<T> responseType) {
		WebResource webResource = jerseyTestRule.getWebResource();
		T t = null;
		if (method.equals("POST")) {
			t = webResource.path(url).post(responseType, params);
			return t;
		}
		t = webResource.path(url).queryParams(params)
				.method(method, responseType);
		return t;
	}	
}
