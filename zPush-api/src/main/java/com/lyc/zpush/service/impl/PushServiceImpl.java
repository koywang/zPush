/**
 * PushServiceImpl.java    2014年10月15日下午1:19:42
 */
package com.lyc.zpush.service.impl;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public ResultDto pushToSingle(String appId, String appKey,
			String clientId, String content, Map<String,String> params, long timeout) {
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
		if(params == null || params.isEmpty()){
			message = new Message(uuid, content);
		}else{
			message = new Message(uuid, content, params);
		}
		messageDao.save(message);
		
		//通知消息队列
		return null;
	}


	
}
