/**
 * Message.java    2014年10月17日下午1:36:13
 */
package com.lyc.zpush.bean;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author yuancen.li
 * @since 2014年10月17日  下午1:36:13
 */
public class Message {

	private String uuid;
	private String content;
	private Map<String,String> params = Maps.newHashMapWithExpectedSize(3);
	
	
	/**
	 * 
	 */
	public Message() {
		super();
	}
	
	
	/**
	 * @param uuid
	 * @param content
	 */
	public Message(String uuid, String content) {
		super();
		this.uuid = uuid;
		this.content = content;
	}


	/**
	 * @param uuid
	 * @param content
	 * @param params
	 */
	public Message(String uuid, String content, Map<String, String> params) {
		super();
		this.uuid = uuid;
		this.content = content;
		this.params = params;
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
	 * @return the params
	 */
	public Map<String, String> getParams() {
		return params;
	}
	/**
	 * @param params the params to set
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	public void addParams(String key, String value){
		this.params.put(key, value);
	}
}
