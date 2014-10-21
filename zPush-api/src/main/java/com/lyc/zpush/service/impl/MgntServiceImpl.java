/**
 * MgntServiceImpl.java    2014年10月21日下午4:56:56
 */
package com.lyc.zpush.service.impl;

import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lyc.zpush.bean.SDK;
import com.lyc.zpush.common.BeanResultDto;
import com.lyc.zpush.common.ResultDto;
import com.lyc.zpush.dao.SDKDao;
import com.lyc.zpush.error.Error;
import com.lyc.zpush.service.CommonService;
import com.lyc.zpush.service.MgntService;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午4:56:56
 */
@Service
public class MgntServiceImpl implements MgntService{
	
	@Autowired
	private SDKDao sdkDao;
	
	@Autowired
	private CommonService commonService;
	

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.MgntService#addSdk(java.lang.String, org.codehaus.jettison.json.JSONObject)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultDto addSdk(String version, JSONObject params) {
		// TODO Auto-generated method stub
		SDK sdk = new SDK();
		sdk.setId(commonService.getNextSdkId());
		sdk.setVersion(version);
		if(params != null){
			sdk.setParams(JSON.parseObject(params.toString(), Map.class));
		}
		sdkDao.save(sdk);
		BeanResultDto<String> resultDto = new BeanResultDto<String>();
		resultDto.setSuccess(true);
		resultDto.setResult(sdk.getId());
		return resultDto;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.MgntService#updateParams(java.lang.String, org.codehaus.jettison.json.JSONObject)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultDto updateParams(String sdkId, JSONObject params) {
		// TODO Auto-generated method stub
		SDK sdk = sdkDao.queryById(sdkId);
		if(sdk == null){
			return new ResultDto(false, Error.SDK_ID_NOT_EXIST);
		}
		sdk.setParams(JSON.parseObject(params.toString(), Map.class));
		sdkDao.save(sdk);
		return new ResultDto(true);
	}

}
