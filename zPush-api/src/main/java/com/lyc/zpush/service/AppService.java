/**
 * AppService.java    2014年10月15日上午11:28:53
 */
package com.lyc.zpush.service;

import com.lyc.zpush.bean.App;
import com.lyc.zpush.common.BeanResultDto;

/**
 * @author yuancen.li
 * @since 2014年10月15日  上午11:28:53
 */
public interface AppService {

	BeanResultDto<App> registerAndroidApp(String appName);
	
	BeanResultDto<App> registerIosApp(String appName);
}
