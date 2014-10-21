/**
 * SDK.java    2014年10月21日下午3:48:18
 */
package com.lyc.zpush.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午3:48:18
 */
public class SDK {

	private String id;
	private String version;
	private Map<String, String> params = new HashMap<String, String>(1);
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the initParams
	 */
	public Map<String, String> getParams() {
		return params;
	}
	/**
	 * @param initParams the initParams to set
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
}
