/**
 * ClientFacadeTest.java    2014年10月20日上午11:14:54
 */
package com.lyc.zpush.facade;

import javax.ws.rs.core.MultivaluedMap;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lyc.zpush.testing.BaseTest;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * @author yuancen.li
 * @since 2014年10月20日  上午11:14:54
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientFacadeTest extends BaseTest{
	
	private static Logger logger = LoggerFactory.getLogger(ClientFacadeTest.class);

	@Test
	public void bindClientTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appId", "app000015");
		params.add("devId", "dev_test_0001");
		JSONObject result = request(params, "/api/client/bindClient", "POST", JSONObject.class);
		Assert.assertEquals(true, result.getBoolean("success"));
		logger.info("clientId : " + result.getString("result"));	
	}
	
	@Test
	public void setTagTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appId", "app000015");
		params.add("devId", "dev_test_0001");
		JSONObject result1 = request(params, "/api/client/getClientId", "POST", JSONObject.class);
		String clientId = result1.getString("result");
		logger.info("clientId : " + result1.getString("result"));
		params.add("tag", "tag_test");
		params.add("clientId", clientId);
		JSONObject result2 = request(params, "/api/client/setTag", "POST", JSONObject.class);
		Assert.assertEquals(true, result2.getBoolean("success"));	
	}
	
	@Test
	public void querySdkParamsTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("version", "androidV0.1");
		params.add("params", "{\"socketIdelTime\":180,\"socketHost\":\"127.0.0.1\",\"socketPort\":8888}");
		JSONObject result1 = request(params, "/mgnt/sdk/addSdk", "POST", JSONObject.class);
		String sdkId = result1.getString("result");
		Assert.assertEquals(true, result1.getBoolean("success"));	
		logger.info("sdkId : " + sdkId);
		params.add("sdkId", sdkId);
		JSONObject result2 = request(params, "/api/client/querySdkParams", "POST", JSONObject.class);
		Assert.assertEquals(true, result2.getBoolean("success"));	
		logger.info("sdkParams : " + result2.getString("result"));
		
	}
	
}
