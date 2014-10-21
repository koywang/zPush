/**
 * CommonServiceImpl.java    2014年10月16日上午10:29:26
 */
package com.lyc.zpush.service.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.zpush.dao.CommonDao;
import com.lyc.zpush.service.CommonService;

/**
 * @author yuancen.li
 * @since 2014年10月16日  上午10:29:26
 */
@Service
public class CommonServiceImpl implements CommonService{
	
	private static final String APPID = "appId";
	private static final String SDKID = "sdkId";
	
	@Autowired
	private CommonDao commonDao;

	private static final NumberFormat[] nfs = {
		new DecimalFormat("0"),new DecimalFormat("00"),
		new DecimalFormat("000"),new DecimalFormat("0000"),
		new DecimalFormat("00000"),new DecimalFormat("000000"),
		new DecimalFormat("0000000"),new DecimalFormat("00000000"),
		new DecimalFormat("000000000"),new DecimalFormat("0000000000"),
		new DecimalFormat("00000000000"),new DecimalFormat("000000000000"),
		new DecimalFormat("0000000000000"),new DecimalFormat("00000000000000"),
		new DecimalFormat("000000000000000"),new DecimalFormat("0000000000000000")};
	
	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.CommonService#getNextAppId()
	 */
	@Override
	public String getNextAppId() {
		// TODO Auto-generated method stub
		return getNextId(APPID, "app", 6);
	}
	
	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.CommonService#getNextSdkId()
	 */
	@Override
	public String getNextSdkId() {
		// TODO Auto-generated method stub
		return getNextId(SDKID, "sdk", 6);
	}

	
	private String getNextId(String idName, String prefix, int len) {
		long id = commonDao.nextCounter(idName);
		if(len < 1) {
			len = 1;
		}
		if(len > nfs.length) {
			len = nfs.length;
		}
		return prefix + nfs[len - 1].format(id);
	}

	
}
