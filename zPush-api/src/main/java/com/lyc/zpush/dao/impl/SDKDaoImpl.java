/**
 * SDKDao.java    2014年10月21日下午4:00:42
 */
package com.lyc.zpush.dao.impl;

import org.springframework.stereotype.Repository;

import com.lyc.zpush.bean.SDK;
import com.lyc.zpush.dao.RedisDaoSupport;
import com.lyc.zpush.dao.SDKDao;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午4:00:42
 */
@Repository
public class SDKDaoImpl extends RedisDaoSupport<SDK> implements SDKDao{

	/* (non-Javadoc)
	 * @see com.lyc.zpush.dao.SDKDao#queryById()
	 */
	@Override
	public SDK queryById(String id) {
		// TODO Auto-generated method stub
		SDK sdk = deserialize(hget(KEY_SDK, id),SDK.class);
		return sdk;
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.dao.SDKDao#save(com.lyc.zpush.bean.SDK)
	 */
	@Override
	public void save(SDK sdk) {
		// TODO Auto-generated method stub
		hset(KEY_SDK, sdk.getId(), serialize(sdk));
	}

}
