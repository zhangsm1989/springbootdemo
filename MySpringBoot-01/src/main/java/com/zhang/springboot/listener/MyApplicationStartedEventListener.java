package com.zhang.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring boot启动监听类
 * Created by sm on 2016/10/6.
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{
private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        SpringApplication app = event.getSpringApplication();
        app.setShowBanner(false);//不显示banner信息
        logger.info("1.-----------------------------------------MyApplicationStartedEventListener");
    }
}
