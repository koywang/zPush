/**
 * PushServiceImpl.java    2014年10月15日下午1:19:42
 */
package com.lyc.zpush.service.impl;

import java.util.Map;
import java.util.UUID;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lyc.zpush.bean.App;
import com.lyc.zpush.bean.Message;
import com.lyc.zpush.common.ResultDto;
import com.lyc.zpush.dao.AppDao;
import com.lyc.zpush.dao.MessageDao;
import com.lyc.zpush.error.Error;
import com.lyc.zpush.service.PushService;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午1:19:42
 */
@Service
public class PushServiceImpl implements PushService{
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private AppDao appDao;

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.PushService#pushToSingle(java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.codehaus.jettison.json.JSONObject, long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultDto pushToSingle(String appId, String appKey,
			String clientId, String content,JSONObject params, long timeout) {
		// TODO Auto-generated method stub
		App app = appDao.queryById(appId);
		if(app == null){
			return new ResultDto(false, Error.APP_ID_NOT_EXIST);
		}
		if(!appKey.equals(app.getAppKey())){
			return new ResultDto(false, Error.APP_KEY_INVALIED);
		}
		Message message = null;
		String uuid = UUID.randomUUID().toString();
		
		if(params == null){
			message = new Message(uuid, content);
		}else{
			message = new Message(uuid, content, JSON.parseObject(params.toString(), Map.class));
		}
		messageDao.save(message);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.PushService#pushToApp(java.lang.String, java.lang.String, java.lang.String, org.codehaus.jettison.json.JSONObject, long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultDto pushToApp(String appId, String appKey, String content,
			JSONObject params, long timeout) {
		// TODO Auto-generated method stub
		App app = appDao.queryById(appId);
		if(app == null){
			return new ResultDto(false, Error.APP_ID_NOT_EXIST);
		}
		if(!appKey.equals(app.getAppKey())){
			return new ResultDto(false, Error.APP_KEY_INVALIED);
		}
		Message message = null;
		String uuid = UUID.randomUUID().toString();
		
		if(params == null){
			message = new Message(uuid, content);
		}else{
			message = new Message(uuid, content, JSON.parseObject(params.toString(), Map.class));
		}
		messageDao.save(message);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.PushService#pushToTag(java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.codehaus.jettison.json.JSONObject, long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultDto pushToTag(String appId, String appKey, String tag,
			String content, JSONObject params, long timeout) {
		// TODO Auto-generated method stub
		App app = appDao.queryById(appId);
		if(app == null){
			return new ResultDto(false, Error.APP_ID_NOT_EXIST);
		}
		if(!appKey.equals(app.getAppKey())){
			return new ResultDto(false, Error.APP_KEY_INVALIED);
		}
		Message message = null;
		String uuid = UUID.randomUUID().toString();
		
		if(params == null){
			message = new Message(uuid, content);
		}else{
			message = new Message(uuid, content, JSON.parseObject(params.toString(), Map.class));
		}
		messageDao.save(message);
		return null;
	}


	
}
