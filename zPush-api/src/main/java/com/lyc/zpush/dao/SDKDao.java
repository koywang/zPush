/**
 * SDKDao.java    2014年10月21日下午3:56:22
 */
package com.lyc.zpush.dao;

import com.lyc.zpush.bean.SDK;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午3:56:22
 */
public interface SDKDao{

	SDK queryById(String id);
	
	void save(SDK sdk);

}
