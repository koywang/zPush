/**
 * MQServiceImpl.java    2014年10月19日下午5:31:24
 */
package com.lyc.zpush.service.impl;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lyc.zpush.bean.MessageHeader;
import com.lyc.zpush.service.MQService;

/**
 * @author yuancen.li
 * @since 2014年10月19日  下午5:31:24
 */
@Service
public class MQServiceImpl implements MQService{

	@Autowired
	private Producer<String, String> producer;
	
	@Value("#{config['TOPIC_MESSAGEHEADER']}")
	private String messageHeaderTopic;
	
	/* (non-Javadoc)
	 * @see com.lyc.zpush.service.MQService#sendMessageHeader(com.lyc.zpush.bean.MessageHeader)
	 */
	@Override
	public void sendMessageHeader(MessageHeader header) {
		// TODO Auto-generated method stub
		KeyedMessage<String, String> message = new KeyedMessage<String, String>(messageHeaderTopic, JSON.toJSONString(header));
		producer.send(message);
	}

}
