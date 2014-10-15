/**
 * PushServiceImpl.java    2014年10月15日下午1:19:42
 */
package com.lyc.zpush.service.impl;

import org.springframework.stereotype.Service;

import com.lyc.zpush.bean.App;
import com.lyc.zpush.bean.Payload;
import com.lyc.zpush.common.ResultDto;
import com.lyc.zpush.service.PushService;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午1:19:42
 */
@Service
public class PushServiceImpl implements PushService{

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.PushService#pushToSingle(com.lyc.zpush.bean.App, com.lyc.zpush.bean.Payload)
	 */
	@Override
	public ResultDto pushToSingle(App app, Payload payload) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.PushService#pushToApp(com.lyc.zpush.bean.App, com.lyc.zpush.bean.Payload)
	 */
	@Override
	public ResultDto pushToApp(App app, Payload payload) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.PushService#pushToTag(com.lyc.zpush.bean.App, com.lyc.zpush.bean.Payload)
	 */
	@Override
	public ResultDto pushToTag(App app, Payload payload) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
