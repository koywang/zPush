/**
 * MapResultDto.java    2014年10月21日下午3:40:50
 */
package com.lyc.zpush.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午3:40:50
 */
public class MapResultDto extends ResultDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5994391742621040876L;
	
	@SuppressWarnings("rawtypes")
	private Map result = new HashMap(3);

	/**
	 * @return the result
	 */
	@SuppressWarnings("rawtypes")
	public Map getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	@SuppressWarnings("rawtypes")
	public void setResult(Map result) {
		this.result = result;
	}
	
	@SuppressWarnings("unchecked")
	public void addResult(String key, Object value){
		result.put(key, value);
	}

}
