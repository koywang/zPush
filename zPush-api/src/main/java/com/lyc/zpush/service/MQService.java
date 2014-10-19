/**
 * MQService.java    2014年10月19日下午5:18:17
 */
package com.lyc.zpush.service;

import com.lyc.zpush.bean.MessageHeader;

/**
 * @author yuancen.li
 * @since 2014年10月19日  下午5:18:17
 */
public interface MQService {

	void sendMessageHeader(MessageHeader header);
}
