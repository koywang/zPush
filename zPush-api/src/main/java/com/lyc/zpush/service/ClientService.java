/**
 * ClientService.java    2014年10月20日上午9:48:49
 */
package com.lyc.zpush.service;

import com.lyc.zpush.common.ResultDto;

/**
 * @author yuancen.li
 * @since 2014年10月20日  上午9:48:49
 */
public interface ClientService {

	ResultDto bindClient(String appId, String devId);
	
	ResultDto setTag(String appId, String devId, String tag , String clientId);
	
	ResultDto getClientId(String appId, String devId);
}
