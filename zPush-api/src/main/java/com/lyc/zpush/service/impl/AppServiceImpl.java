/**
 * AppServiceImpl.java    2014年10月15日下午1:19:17
 */
package com.lyc.zpush.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.zpush.bean.App;
import com.lyc.zpush.bean.AppType;
import com.lyc.zpush.common.BeanResultDto;
import com.lyc.zpush.dao.AppDao;
import com.lyc.zpush.service.AppService;
import com.lyc.zpush.service.CommonService;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午1:19:17
 */
@Service
public class AppServiceImpl implements AppService{
	
	@Autowired
	private AppDao appDao;
	
	@Autowired
	private CommonService commonService;

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.AppService#registerAndroidApp(java.lang.String)
	 */
	@Override
	public BeanResultDto<App> registerAndroidApp(String appName) {
		// TODO Auto-generated method stub
		App app = new App();
		app.setAppId(commonService.getNextAppId());
		app.setAppName(appName);
		byte[] b = new byte[128];
		ThreadLocalRandom.current().nextBytes(b);
		app.setAppKey(DigestUtils.md5Hex(b));
		app.setAppType(AppType.Android);
		appDao.saveApp(app);
		
		BeanResultDto<App> resultDto = new BeanResultDto<App>();
		resultDto.setSuccess(true);
		resultDto.setResult(app);
		return resultDto;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.AppService#registerIosApp(java.lang.String)
	 */
	@Override
	public BeanResultDto<App> registerIosApp(String appName) {
		// TODO Auto-generated method stub
		App app = new App();
		app.setAppId(commonService.getNextAppId());
		app.setAppName(appName);
		byte[] b = new byte[128];
		ThreadLocalRandom.current().nextBytes(b);
		app.setAppKey(DigestUtils.md5Hex(b));
		app.setAppType(AppType.IOS);
		appDao.saveApp(app);
		
		BeanResultDto<App> resultDto = new BeanResultDto<App>();
		resultDto.setSuccess(true);
		resultDto.setResult(app);
		return resultDto;
	}

}
