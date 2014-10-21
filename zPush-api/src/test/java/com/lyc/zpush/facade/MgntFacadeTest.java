/**
 * MgntFacadeTest.java    2014年10月21日下午4:39:26
 */
package com.lyc.zpush.facade;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lyc.zpush.testing.BaseTest;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午4:39:26
 */
public class MgntFacadeTest extends BaseTest{
	
	private static Logger logger = LoggerFactory.getLogger(MgntFacadeTest.class);

	@Test
	public void addSdkTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("version", "androidV0.1");
		params.add("params", "{\"socketIdelTime\":180,\"socketHost\":\"127.0.0.1\",\"socketPort\":8888}");
		JSONObject result1 = request(params, "/mgnt/sdk/addSdk", "POST", JSONObject.class);
		String sdkId = result1.getString("result");
		Assert.assertEquals(true, result1.getBoolean("success"));	
		logger.info("sdkId : " + sdkId);
	}
	
	@Test
	public void updateParamsTest() throws JSONException{
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("version", "androidV0.1");
		params.add("params", "{\"socketIdelTime\":180,\"socketHost\":\"127.0.0.1\",\"socketPort\":8888}");
		JSONObject result1 = request(params, "/mgnt/sdk/addSdk", "POST", JSONObject.class);
		String sdkId = result1.getString("result");
		Assert.assertEquals(true, result1.getBoolean("success"));	
		logger.info("sdkId : " + sdkId);
		
		params.add("sdkId", sdkId);
		params.putSingle("params", "{\"socketIdelTime\":180,\"socketHost\":\"localhost\",\"socketPort\":8888}");
		JSONObject result2 = request(params, "/mgnt/sdk/updateParams", "POST", JSONObject.class);
		Assert.assertEquals(true, result2.getBoolean("success"));	
		
		JSONObject result3 = request(params, "/api/client/querySdkParams", "POST", JSONObject.class);
		logger.info("params : " + result3.getString("result"));
	}
}
