/**
 * PushFacadeTest.java    2014年10月18日下午6:43:11
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
 * @since 2014年10月18日  下午6:43:11
 */
public class PushFacadeTest extends BaseTest{

	
	@Test
	public void pushToSingleTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appId", "app000015");
		params.add("appKey", "5be5d41151d22dc3546ff3012e180616");
		params.add("clientId", "client1");
		params.add("content", "singlePushTest");
		params.add("params", "{\"param1\":\"value1\",\"param2\":\"value\"}");
		JSONObject result = request(params, "/api/server/push/pushToSingle", "POST", JSONObject.class);
		Assert.assertEquals(true, result.getBoolean("success"));
	}
	
	@Test
	public void pushToAppTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appId", "app000015");
		params.add("appKey", "5be5d41151d22dc3546ff3012e180616");
		params.add("content", "appPushTest");
		params.add("params", "{\"param1\":\"value1\",\"param2\":\"value\"}");
		JSONObject result = request(params, "/api/server/push/pushToApp", "POST", JSONObject.class);
		Assert.assertEquals(true, result.getBoolean("success"));	
	}
	
	@Test
	public void pushToTagTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appId", "app000015");
		params.add("appKey", "5be5d41151d22dc3546ff3012e180616");
		params.add("tag", "testTag");
		params.add("content", "tagPushTest");
		params.add("params", "{\"param1\":\"value1\",\"param2\":\"value\"}");
		JSONObject result = request(params, "/api/server/push/pushToTag", "POST", JSONObject.class);
		Assert.assertEquals(true, result.getBoolean("success"));
	}
}
