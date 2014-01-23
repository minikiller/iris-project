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
        user=addUser(user);
        List<UserBean> list=this.getAllUser();
        System.out.print("system is called "+list.size());
    }
    @Override

    public UserBean addUser(UserBean user) {
        return userBeanDao.saveUser(user);
    }

    public List<UserBean> getAllUser(){
        return userBeanDao.getAll(UserBeanImpl.class.getName());
    }
}
