package com.zhang.springboot.activemq.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import com.zhang.springboot.activemq.service.MessagePublisherService;
import com.zhang.springboot.model.BaseSendMessageDTO;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;


/**
 * Description: activeMQ消息生产者
 *  
 *
 * Copyright (c) 2016 北京柯莱特科技有限公司 交付部
 *
 */


@Service("smsNoticQueuePublisher")
public class SmsNoticQueuePublisherImpl implements MessagePublisherService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private JmsTemplate jmsTemplate;
	/**
	* noticQueueDestination:spring-activemq中配置的队列目的地
	*/
	@Resource
	private ActiveMQQueue noticQueueDestination;
	
	/**
	 * 发送对象消息
	 */
	@Override
	public boolean sendMessage(Object obj) {
		final BaseSendMessageDTO messageDTO = (BaseSendMessageDTO) obj;
		try{
			logger.info("开始向activeMQ推送消息.....................");
			this.jmsTemplate.send(noticQueueDestination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					// TODO Auto-generated method stub
					return session.createObjectMessage(messageDTO);
				}
			});
		}catch(JmsException e){
			logger.error("向activeMQ中间件服务器发送对象消息失败:"+e.getMessage());
			//向消息中间件发送消息失败，
			return false;
		}
		logger.info("向activeMQ中间件服务器发送对象消息成功！");
		return true;
	}
	
}
