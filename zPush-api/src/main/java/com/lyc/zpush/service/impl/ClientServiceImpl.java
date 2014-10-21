/**
 * ClientServiceImpl.java    2014年10月20日上午9:49:55
 */
package com.lyc.zpush.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.zpush.bean.App;
import com.lyc.zpush.bean.SDK;
import com.lyc.zpush.common.BeanResultDto;
import com.lyc.zpush.common.MapResultDto;
import com.lyc.zpush.common.RandomUtil;
import com.lyc.zpush.common.ResultDto;
import com.lyc.zpush.dao.AppDao;
import com.lyc.zpush.dao.RedisDaoSupport;
import com.lyc.zpush.dao.SDKDao;
import com.lyc.zpush.error.Error;
import com.lyc.zpush.service.ClientService;

/**
 * @author yuancen.li
 * @since 2014年10月20日  上午9:49:55
 */
@SuppressWarnings("rawtypes")
@Service
public class ClientServiceImpl extends RedisDaoSupport implements ClientService{
	
	@Autowired
	private AppDao appDao;

	@Autowired
	private SDKDao sdkDao;
	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.BindService#bindClient(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultDto bindClient(String appId, String devId) {
		// TODO Auto-generated method stub
		App app = appDao.queryById(appId);
		if(app == null){
			return new ResultDto(false, Error.APP_ID_NOT_EXIST);
		}
		String clientId = RandomUtil.getRandom();
		hset(KEY_BIND_PREFIX.concat(appId), clientId, devId);
		hset(KEY_BIND_REVERSE_PREFIX.concat(appId), devId, clientId);
		BeanResultDto<String> resultDto = new BeanResultDto<String>();
		resultDto.setSuccess(true);
		resultDto.setResult(clientId);
		return resultDto;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.ClientService#setTag(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ResultDto setTag(String appId, String devId, String tag,
			String clientId) {
		// TODO Auto-generated method stub
		App app = appDao.queryById(appId);
		if(app == null){
			return new ResultDto(false, Error.APP_ID_NOT_EXIST);
		}
		if(!hget(KEY_BIND_PREFIX.concat(appId), clientId).equals(devId)){
			return new ResultDto(false, Error.BIND_RELATIONSHIP_NOT_EXIST);
		}
		sadd(KEY_TAG_PREFIX.concat(appId).concat(":").concat(tag), clientId);
		return new ResultDto(true);
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.ClientService#getClientId(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultDto getClientId(String appId, String devId) {
		// TODO Auto-generated method stub
		App app = appDao.queryById(appId);
		if(app == null){
			return new ResultDto(false, Error.APP_ID_NOT_EXIST);
		}
		String clientId = hget(KEY_BIND_REVERSE_PREFIX.concat(appId), devId);
		if(StringUtils.isBlank(clientId)){
			return new ResultDto(false, Error.BIND_RELATIONSHIP_NOT_EXIST);
		}
		BeanResultDto<String> resultDto = new BeanResultDto<String>();
		resultDto.setSuccess(true);
		resultDto.setResult(clientId);
		return resultDto;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.ClientService#sdkParams(java.lang.String)
	 */
	@Override
	public ResultDto querySdkParams(String sdkId) {
		// TODO Auto-generated method stub
		SDK sdk = sdkDao.queryById(sdkId);
		if(sdk == null){
			return new ResultDto(false, Error.SDK_ID_NOT_EXIST);
		}
		MapResultDto resultDto = new MapResultDto();
		resultDto.setSuccess(true);
		resultDto.setResult(sdk.getParams());
		return resultDto;
	}

}
