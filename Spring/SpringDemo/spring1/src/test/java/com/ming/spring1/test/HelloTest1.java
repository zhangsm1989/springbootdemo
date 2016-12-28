package com.ming.spring1.test;

import com.ming.spring1.HelloApi;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: [描述该类概要功能介绍]
 * Created on 2016-12-28
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */
public class HelloTest1 {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
        HelloApi helloApi = beanFactory.getBean(HelloApi.class);
        helloApi.sayHello("");
    }
}
