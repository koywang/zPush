/**
 * AppType.java    2014年10月15日上午11:37:52
 */
package com.lyc.zpush.bean;

/**
 * @author yuancen.li
 * @since 2014年10月15日  上午11:37:52
 */
public enum AppType {
	Android("android"),
	IOS("ios");
	
	private String type;
	
	private AppType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
}
