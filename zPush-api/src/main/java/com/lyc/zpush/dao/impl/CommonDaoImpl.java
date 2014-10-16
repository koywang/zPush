/**
 * CommonDaoImpl.java    2014年10月16日上午10:26:37
 */
package com.lyc.zpush.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lyc.zpush.dao.CommonDao;
import com.lyc.zpush.dao.RedisDaoSupport;

/**
 * @author yuancen.li
 * @since 2014年10月16日  上午10:26:37
 */
@SuppressWarnings("rawtypes")
@Repository
public class CommonDaoImpl extends RedisDaoSupport implements CommonDao{
	
	private static final Logger logger = LoggerFactory.getLogger(CommonDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.lyc.zpush.dao.CommonDao#nextCounter(java.lang.String)
	 */
	@Override
	public long nextCounter(String idName) {
		// TODO Auto-generated method stub
		return nextCounter(idName, 1);
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.dao.CommonDao#nextCounter(java.lang.String, int)
	 */
	@Override
	public long nextCounter(String idName, int increment) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(idName)){
			logger.error("idName null");
			return 0l;
		}
		long counter = hincrBy(KEY_COUNTER,idName,increment);
		return counter;
	}

}
