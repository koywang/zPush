/**
 * MessageDao.java    2014年10月17日下午1:42:09
 */
package com.lyc.zpush.dao;

import com.lyc.zpush.bean.Message;

/**
 * @author yuancen.li
 * @since 2014年10月17日  下午1:42:09
 */
public interface MessageDao {

	boolean save(Message message);
}
