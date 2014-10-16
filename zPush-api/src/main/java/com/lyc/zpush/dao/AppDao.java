/**
 * AppDao.java    2014年10月16日上午9:24:30
 */
package com.lyc.zpush.dao;

import com.lyc.zpush.bean.App;

/**
 * @author yuancen.li
 * @since 2014年10月16日  上午9:24:30
 */
public interface AppDao {

	void saveApp(App app);
	
	App queryById(String appId);
}
