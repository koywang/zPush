/**
 * CommonDao.java    2014年10月16日上午10:23:34
 */
package com.lyc.zpush.dao;

/**
 * @author yuancen.li
 * @since 2014年10月16日  上午10:23:34
 */
public interface CommonDao {

	long nextCounter(String idSpace);
	
	long nextCounter(String idSpace, int increment);
}
