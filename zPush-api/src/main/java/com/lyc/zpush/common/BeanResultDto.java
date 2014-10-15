/**
 * BeanResultDto.java    2014年10月15日下午1:00:41
 */
package com.lyc.zpush.common;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午1:00:41
 */
public class BeanResultDto<T> extends ResultDto{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1365107807898155544L;
	private T result;

	/**
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}
    
}
