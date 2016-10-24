package com.zhang.springboot.service.impl;

import com.zhang.springboot.base.Pager;
import com.zhang.springboot.dao.UserDAO;
import com.zhang.springboot.model.User;
import com.zhang.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description: [用户服务实现]
 * Created on 2016-10-07
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */
@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;
    @Override
    public List<User> queryUserList(User u,Pager pager) {
        List<User> user=userDao.queryList(u,pager,null);
        return user;
    }
    @Override
    public Integer updateUserById(User u) {
        Integer isUpdate = userDao.update(u);
        return isUpdate;
    }
}
