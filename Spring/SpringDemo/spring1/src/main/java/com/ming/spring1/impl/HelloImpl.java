package com.ming.spring1.impl;

import com.ming.spring1.HelloApi;

/**
 * Description: [描述该类概要功能介绍]
 * Created on 2016-12-28
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */
public class HelloImpl implements HelloApi {

    public void sayHello(String sources) {
        System.out.println("hello,"+ sources +" .........................");
    }
}
