package com.zhang.springboot.activemq.service;


import com.zhang.springboot.model.BaseSendMessageDTO;

/**
 * Description: activeMQ消息消费者接口
 *
 *         <p>
 *         create on 2016
 *         <p>
 *         Copyright (c) 2015 北京柯莱特科技有限公司 交付部
 */
public interface ConsumerListenerService {
    /**
     * 异步接受文本消息
     */
    void handleMessage(String message);

    /**
     * 异步接收通知对象消息
     */
    void handleMessage(BaseSendMessageDTO message);


}
