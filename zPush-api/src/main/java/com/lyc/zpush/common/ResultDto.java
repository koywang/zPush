/**
 * ResultDto.java    2014年10月15日下午12:50:41
 */
package com.lyc.zpush.common;

import java.io.Serializable;

import com.lyc.zpush.error.Error;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午12:50:41
 */
public class ResultDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1313929483484501346L;
	private boolean success;
	private Error error;
	
	public ResultDto(){
		
	}
	/**
	 * @param success
	 */
	public ResultDto(boolean success) {
		super();
		this.success = success;
	}
	/**
	 * @param success
	 * @param error
	 */
	public ResultDto(boolean success, Error error) {
		super();
		this.success = success;
		this.error = error;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}
	
	public String getErrorCode(){
		if(this.error == null){
			return "";
		}
		return error.getCode();
	}
	
	public String getErrorDesc(){
		if(this.error == null){
			return "";
		}
		return error.getDesc();
	}
}
