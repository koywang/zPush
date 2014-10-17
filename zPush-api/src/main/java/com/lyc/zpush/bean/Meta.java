/**
 * Payload.java    2014年10月15日下午1:11:55
 */
package com.lyc.zpush.bean;


/**
 * @author yuancen.li
 * @since 2014年10月15日  下午1:11:55
 */
public class Meta {

	private String appId;
	private String clientId;
	private String tag;
	private long timeout;
	private PushType pushType;
	private AppType appType;
	private String uuid;
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
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the timeout
	 */
	public long getTimeout() {
		return timeout;
	}
	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	/**
	 * @return the pushType
	 */
	public PushType getPushType() {
		return pushType;
	}
	/**
	 * @param pushType the pushType to set
	 */
	public void setPushType(PushType pushType) {
		this.pushType = pushType;
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
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
