package com.zhang.springboot.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhang.springboot.activemq.service.MessagePublisherService;
import com.zhang.springboot.base.Pager;
import com.zhang.springboot.model.User;
import com.zhang.springboot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Discription:[用户控制类]</p>
 * Created on 2016-10-07 18:28
 *
 * @param
 * @return
 * @author:[张山明]
 */

@RestController
@RequestMapping("/restfull")
public class RestDemoController {

    private Logger logger = Logger.getLogger(RestDemoController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public User getUserJson(Model model) {
        User user = new User();
        Pager pager = new Pager();
        List<User> userlist = userService.queryUserList(user, pager);
        if (userlist != null && userlist.size() > 0) {
            user = userlist.get(0);
            logger.info("userlist:" + JSONObject.toJSON(userlist));
        }
        model.addAttribute("user", user);
        return user;
    }
}
