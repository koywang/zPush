/**
 * Payload.java    2014年10月15日下午1:11:55
 */
package com.lyc.zpush.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午1:11:55
 */
public abstract class Payload {

	private String appId;
	private String content;
	private String uuid;
	private long timeout;
	private Map<String, Object> params = new HashMap<String, Object>(1);
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		if(this.params != null){
			return this.params;
		}
		return Collections.emptyMap();
	}
	/**
	 * @param params the params to set
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	public void addParam(String key, Object value){
		if(this.params != null){
			this.params.put(key, value);
		}
	}
}
