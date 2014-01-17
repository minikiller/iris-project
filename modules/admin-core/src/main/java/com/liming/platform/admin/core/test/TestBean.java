package com.liming.platform.admin.core.test;

import com.liming.platform.admin.api.biz.UserBeanService;
import com.liming.platform.admin.api.persistence.UserBean;
import com.liming.platform.admin.entities.UserBeanImpl;

/**
 * Created by dell on 14-1-17.
 */
public class TestBean {
    private  UserBeanService userBeanService;

    public void setUserBeanService(UserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void init(){
        System.out.print("system is called");
        UserBean user =new UserBeanImpl();
        userBeanService.addUser(user);

    }

}
