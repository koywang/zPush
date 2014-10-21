/**
 * MgntService.java    2014年10月21日下午4:53:31
 */
package com.lyc.zpush.service;

import org.codehaus.jettison.json.JSONObject;

import com.lyc.zpush.common.ResultDto;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午4:53:31
 */
public interface MgntService {

	ResultDto addSdk(String version, JSONObject params);
	
	ResultDto updateParams(String sdkId, JSONObject params);
}
