package com.zhang.springboot.activemq.impl;

import javax.annotation.Resource;

import com.zhang.springboot.activemq.service.ConsumerListenerService;
import com.zhang.springboot.activemq.service.MessagePublisherService;
import com.zhang.springboot.base.ExecuteResult;
import com.zhang.springboot.model.BaseSendMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Description: activeMQ消息消费者实现
 * 
 *
 * Copyright (c) 2016 北京柯莱特科技有限公司 交付部
 *
 */
@Service("smsNoticQueueConsumer")
public class SmsNoticQueueConsumerListenerImpl implements ConsumerListenerService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private MessagePublisherService smsNoticQueuePublisher;
	/**
	 * 异步接受文本消息
	 */
	@Override
	public void handleMessage(String message) {

	}
	/**
	 * 异步接收对象消息
	 */
	@Override
	public void handleMessage(BaseSendMessageDTO baseSendMessage) {
		logger.info("开始给"+baseSendMessage.getAddress()+"发送消息!!");
		//如果使用数据库作为备份，发送时需要将正在发送的消息存放在redis中备份
		/*if(Constants.DB_YES.equals(isUsedDB)){
		//	redisDB.set(key, value);
		}*/
		//发送短信或邮件
		ExecuteResult<String> result = new ExecuteResult<String>();
		try{
//			result = new ExecuteResult<String>();
//			result = messageService.sendSms(baseSendMessage.getAddress(), baseSendMessage.getContent());
			logger.info("消费者开始发送消息.........................");
		}catch(Exception e){
			logger.error("activeMQ调用dubbo发送邮件过程中出现异常："+e);
			this.rePushToQuene(baseSendMessage);
			return ;
		}
		//发送成功，修改数据库状态
		//发送失败，重新放入消息队列(queue)中
		
		if(result.isSuccess()){
			//修改数据库状态
			logger.info("activeMQ向用户"+baseSendMessage.getAddress()+"发送消息成功");
			logger.info("给"+baseSendMessage.getAddress()+"发送消息的线程结束！！！");
			
		}else{
			this.rePushToQuene(baseSendMessage);
		}
		
	}
	
	/**
	 * 消息发送失败，重新将信息放到消息队列中
	 * @return
	 */
	private boolean rePushToQuene(BaseSendMessageDTO baseSendMessage){
		
		
		int sendNum = (baseSendMessage.getSendNum()==null?1:baseSendMessage.getSendNum())+1;
		//发送5次未成功则不再发送
		if(sendNum>=6){
			logger.info("activeMQ向用户5次发送消息失败，不再发送");
			return false;
		}
		//重新放入消息队列中
		logger.info("activeMQ向用户发送消息失败，重新放入消息队列，重新发送");
		baseSendMessage.setSendNum(sendNum);
		boolean isSuccess =  smsNoticQueuePublisher.sendMessage(baseSendMessage);
		logger.info("activeMQ已重新第"+sendNum+"次向用户发送消息");
		//如果配置中配置了数据库，那么需要更新数据库消息状态
		/**
		 * 需要处理的问题------当更新数据库的时候发生异常，后该怎么处理 ？？？？？？
		 */
//		if(Constants.DB_YES.equals(isUsedDB)){
			/*Integer num = baseSendMessage.getSendNum()==null?1:baseSendMessage.getSendNum()+1;
			baseSendMessage.setSendNum(num);
			boolean editSuccess = false;
			int editNum = 1 ; 
			do{
				logger.info("第"+editNum+"次修改消息发送的次数");
				ExecuteResult<BaseSendMessageDTO> editResult =  baseSendMessageService.editBaseSendMessage(baseSendMessage);
				editSuccess = editResult.isSuccess();
				editNum++;
			}while(!editSuccess&&editNum<=5);
			*/
//		}
		return isSuccess;
	}

}
