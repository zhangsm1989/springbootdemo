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

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    MessagePublisherService smsNoticQueuePublisher;

    @RequestMapping("list")
    public String queryUserList(Model model, User user) {
        Pager pager = new Pager();
        user.setPassword("name");
        user.setName("7");
        List<User> userlist = userService.queryUserList(user, pager);
        if (userlist != null && userlist.size() > 0) {
            logger.info("userlist:" + JSONObject.toJSON(userlist));
        }
        logger.info(JSONObject.toJSON(userlist));
        model.addAttribute("userlist", JSONObject.toJSON(userlist));
        model.addAttribute("hello", JSONObject.toJSON(userlist));
        return "/hello";
    }

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(Model model) {
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

    @RequestMapping("update")
    @ResponseBody
    public String update(Model model) {
        User user = new User();
        user.setId(1l);
        user.setAge(100l);
        Integer flag = userService.updateUserById(user);
        if (flag == 0) {
            logger.info("fail");
        } else {
            logger.info("Success");
        }
        model.addAttribute("flag", flag);
        return "hello";
    }

}
