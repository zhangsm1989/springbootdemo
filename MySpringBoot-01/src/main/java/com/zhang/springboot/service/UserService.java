package com.zhang.springboot.service;

import com.zhang.springboot.base.Pager;
import com.zhang.springboot.model.User;

import java.util.List;

/**
 * Description: [用户服务接口]
 * Created on 2016-10-07
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */
public interface UserService {
    //用户列表
    List<User> queryUserList(User user,Pager pager);
    //用户信息
    Integer updateUserById(User user);
}
