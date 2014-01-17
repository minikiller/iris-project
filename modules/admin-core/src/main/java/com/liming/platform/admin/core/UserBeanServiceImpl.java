package com.liming.platform.admin.core;

import com.liming.platform.admin.api.biz.UserBeanService;
import com.liming.platform.admin.api.dao.UserBeanDao;
import com.liming.platform.admin.api.persistence.UserBean;
import com.liming.platform.admin.entities.UserBeanImpl;

import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public class UserBeanServiceImpl implements UserBeanService{
    private UserBeanDao userBeanDao;

    public void setUserBeanDao(UserBeanDao userBeanDao) {
        this.userBeanDao = userBeanDao;
    }

    public void init(){

        UserBean user =new UserBeanImpl();
        user.setName("test");
        user.setPassword("hello");
        addUser(user);
//        List<UserBean> list=userBeanDao.getUserList();
        System.out.print("system is called ");
    }
    @Override
    public void addUser(UserBean user) {
        userBeanDao.save(user);
    }

    public List<UserBean> getAllUser(){
        return userBeanDao.getAll();
    }
}
