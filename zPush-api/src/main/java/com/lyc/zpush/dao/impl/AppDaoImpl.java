/**
 * AppDaoImpl.java    2014年10月16日上午9:31:48
 */
package com.lyc.zpush.dao.impl;

import org.springframework.stereotype.Repository;

import com.lyc.zpush.bean.App;
import com.lyc.zpush.dao.AppDao;
import com.lyc.zpush.dao.RedisDaoSupport;

/**
 * @author yuancen.li
 * @since 2014年10月16日  上午9:31:48
 */
@Repository
public class AppDaoImpl extends RedisDaoSupport<App> implements AppDao{

	/* (non-Javadoc)
	 * @see com.lyc.zpush.dao.AppDao#saveApp(com.lyc.zpush.bean.App)
	 */
	@Override
	public void save(App app) {
		// TODO Auto-generated method stub
		hset(KEY_APP, app.getAppId(), serialize(app));
	}

	/* (non-Javadoc)
	 * @see com.lyc.zpush.dao.AppDao#queryById(java.lang.String)
	 */
	@Override
	public App queryById(String appId) {
		// TODO Auto-generated method stub
		App app = deserialize(hget(KEY_APP, appId),App.class);
		if(app == null){
			return new App();
		}
		return app;
	}

}
