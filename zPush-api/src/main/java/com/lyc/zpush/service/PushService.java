/**
 * PushService.java    2014年10月15日下午12:49:10
 */
package com.lyc.zpush.service;

import org.codehaus.jettison.json.JSONObject;

import com.lyc.zpush.common.ResultDto;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午12:49:10
 */
public interface PushService {

	ResultDto pushToSingle(String appId, String appKey, String clientId, String content, JSONObject params, long timeout);
	
	ResultDto pushToApp(String appId, String appKey, String content, JSONObject params, long timeout);
	
	ResultDto pushToTag(String appId, String appKey, String tag, String content, JSONObject params, long timeout);
}
