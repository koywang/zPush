/**
 * PushType.java    2014年10月17日下午1:32:06
 */
package com.lyc.zpush.bean;

/**
 * @author yuancen.li
 * @since 2014年10月17日  下午1:32:06
 */
public enum PushType {
	Single("single"),
	Tag("tag"),
	App("app");
	
	private String type;
	
	private PushType(String type){
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
}
