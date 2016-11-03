package com.zhang.springboot.controller;

import com.zhang.springboot.model.User;
import com.zhang.springboot.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Description: [描述该类概要功能介绍]
 * Created on 2016/11/3
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */
@Controller
@RequestMapping
public class HomeController {
    @Autowired
    SpringUtil springUtil;
    @RequestMapping("/")
    public String index(Model model){
        UserController userController = (UserController) SpringUtil.getBean("userController");
        User u = userController.getUser(model);
        return "/index";
    }
}
