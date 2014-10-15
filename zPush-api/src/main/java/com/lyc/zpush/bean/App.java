/**
 * App.java    2014年10月15日上午11:30:23
 */
package com.lyc.zpush.bean;

/**
 * @author yuancen.li
 * @since 2014年10月15日  上午11:30:23
 */
public class App {

	private String appId;
	private String appKey;
	private String appName;
	private AppType appType;
	
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return the appKey
	 */
	public String getAppKey() {
		return appKey;
	}
	/**
	 * @param appKey the appKey to set
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * @return the appType
	 */
	public AppType getAppType() {
		return appType;
	}
	/**
	 * @param appType the appType to set
	 */
	public void setAppType(AppType appType) {
		this.appType = appType;
	}
	
}
