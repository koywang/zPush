/**
 * AppFacadeTest.java    2014年10月16日下午1:38:37
 */
package com.lyc.zpush.facade;

import javax.ws.rs.core.MultivaluedMap;

import org.junit.Assert;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;





import com.lyc.zpush.testing.BaseTest;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * @author yuancen.li
 * @since 2014年10月16日  下午1:38:37
 */
public class AppFacadeTest extends BaseTest{

	@Test
	public void registerAndroidAppTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appName", "testAndroidApp1");
		JSONObject result = request(params, "/portal/app/regAndroidApp", "POST", JSONObject.class);
		Assert.assertEquals(true, result.getBoolean("success"));
	}
	
	@Test
	public void registerIosAppTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appName", "testIosApp2");
		JSONObject result = request(params, "/portal/app/regIosApp", "POST", JSONObject.class);
		Assert.assertEquals(true, result.getBoolean("success"));
	}
}
