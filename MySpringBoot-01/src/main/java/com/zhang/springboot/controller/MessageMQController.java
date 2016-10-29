package com.zhang.springboot.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhang.springboot.activemq.service.MessagePublisherService;
import com.zhang.springboot.base.Pager;
import com.zhang.springboot.model.BaseSendMessageDTO;
import com.zhang.springboot.model.User;
import com.zhang.springboot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>Discription:[消息]</p>
 * Created on 2016-10-07 18:28
 *
 * @param
 * @return
 * @author:[张山明]
 */

@Controller
@RequestMapping("/user")
public class MessageMQController {
    private Logger logger = Logger.getLogger(MessageMQController.class);
    @Autowired
    MessagePublisherService smsNoticQueuePublisher;

    @RequestMapping("send")
    @ResponseBody
    public String send() {
        for (int i = 0; i < 100; i++) {
            BaseSendMessageDTO baseSendMessage = new BaseSendMessageDTO();
            baseSendMessage.setContent("activeMq............................");
            baseSendMessage.setAddress("北京市 邮电局."+i);
            smsNoticQueuePublisher.sendMessage(baseSendMessage);
            try {
                logger.info("send activeMq......................................"+i);
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                logger.info("send activeMq...."+ i +"..................................异常!");
                continue;
            }
        }
        return "hello";
    }


}
