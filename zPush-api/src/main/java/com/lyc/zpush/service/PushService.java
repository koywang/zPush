/**
 * PushService.java    2014年10月15日下午12:49:10
 */
package com.lyc.zpush.service;

import java.util.Map;

import com.lyc.zpush.common.ResultDto;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午12:49:10
 */
public interface PushService {

	ResultDto pushToSingle(String appId, String appKey, String clientId, String content, Map<String, String> params, long timeout);
	
}
