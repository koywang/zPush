/**
 * SinglePayload.java    2014年10月15日下午2:36:05
 */
package com.lyc.zpush.bean;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午2:36:05
 */
public class SinglePayload extends Payload{

	private String clientId;

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
	
	
}
