/**
 * Error.java    2014年10月15日下午12:51:53
 */
package com.lyc.zpush.error;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午12:51:53
 */
public enum Error {

	APP_NAME_INVALIED("0x0001","应用名称非法");
	
	private String code;
	private String desc;
	
	private Error(String code, String desc){
		this.code = code;
		this.desc = desc;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
