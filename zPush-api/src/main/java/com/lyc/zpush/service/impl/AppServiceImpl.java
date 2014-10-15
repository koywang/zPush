/**
 * AppServiceImpl.java    2014年10月15日下午1:19:17
 */
package com.lyc.zpush.service.impl;

import org.springframework.stereotype.Service;

import com.lyc.zpush.bean.App;
import com.lyc.zpush.common.BeanResultDto;
import com.lyc.zpush.service.AppService;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午1:19:17
 */
@Service
public class AppServiceImpl implements AppService{

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.AppService#registerAndroidApp(java.lang.String)
	 */
	@Override
	public BeanResultDto<App> registerAndroidApp(String appName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.AppService#registerIosApp(java.lang.String)
	 */
	@Override
	public BeanResultDto<App> registerIosApp(String appName) {
		// TODO Auto-generated method stub
		return null;
	}

}
