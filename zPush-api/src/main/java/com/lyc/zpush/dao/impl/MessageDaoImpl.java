/**
 * MessageDaoImpl.java    2014年10月17日下午1:45:24
 */
package com.lyc.zpush.dao.impl;

import org.springframework.stereotype.Repository;

import com.lyc.zpush.bean.Message;
import com.lyc.zpush.dao.MessageDao;
import com.lyc.zpush.dao.RedisDaoSupport;

/**
 * @author yuancen.li
 * @since 2014年10月17日  下午1:45:24
 */
@Repository
public class MessageDaoImpl extends RedisDaoSupport<Message> implements MessageDao{

	/* (non-Javadoc)
	 * @see com.lyc.zpush.dao.MessageDao#save(com.lyc.zpush.bean.Message)
	 */
	@Override
	public boolean save(Message message) {
		// TODO Auto-generated method stub
		long result = hset(KEY_MESSAGE, message.getUuid(), serialize(message));
		if(result == 1l){
			return true;
		}else{
			return false;
		}
	}

}
