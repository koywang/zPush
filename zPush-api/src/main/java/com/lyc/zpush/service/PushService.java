/**
 * PushService.java    2014年10月15日下午12:49:10
 */
package com.lyc.zpush.service;

import com.lyc.zpush.bean.App;
import com.lyc.zpush.bean.Payload;
import com.lyc.zpush.common.ResultDto;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午12:49:10
 */
public interface PushService {

	ResultDto pushToSingle(App app, Payload payload);
	
	ResultDto pushToApp(App app, Payload payload);
	
	ResultDto pushToTag(App app, Payload payload);
}
