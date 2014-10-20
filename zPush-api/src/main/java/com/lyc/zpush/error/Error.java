/**
 * Error.java    2014年10月15日下午12:51:53
 */
package com.lyc.zpush.error;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午12:51:53
 */
public enum Error {

	APP_NAME_INVALIED("0x0001","应用名称非法"),
	APP_ID_INVALIED("0x0002","应用Id非法"),
	APP_KEY_INVALIED("0x0003","应用Key非法"),
	CLIENT_ID_INVALIED("0x0004","客户Id非法"),
	CONTENT_NULL("0x0005","推送内容为空"),
	APP_ID_NOT_EXIST("0x0006","应用Id不存在"),
	TAG_NAME_INVALID("0x0007","标签名非法"),
	DEV_ID_INVALID("0x0008","设备Id非法"),
	MESSAGE_SAVE_FAILURE("0x0009","消息保存失败"),
	BIND_RELATIONSHIP_NOT_EXIST("0x0010","客户端绑定关系不存在");
	
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
