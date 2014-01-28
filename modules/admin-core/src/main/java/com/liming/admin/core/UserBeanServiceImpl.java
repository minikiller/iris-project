package com.liming.admin.core;

import com.liming.admin.api.biz.IUserBeanService;
import com.liming.admin.api.dao.IUserBeanDao;
import com.liming.admin.api.persistence.IUserBean;
import com.liming.admin.entities.UserBeanImpl;

import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public class UserBeanServiceImpl implements IUserBeanService {
    private IUserBeanDao userBeanDao;

    public void setUserBeanDao(IUserBeanDao userBeanDao) {
        this.userBeanDao = userBeanDao;
    }

    public void init() {
        IUserBean user = new UserBeanImpl();
        user.setName("test");
        user.setPassword("hello");
        user = addUser(user);
        List<IUserBean> list = this.getAllUser();
        System.out.print("system is called " + list.size());
    }

    @Override

    public IUserBean addUser(IUserBean user) {
        return userBeanDao.saveUser(user);
    }

    public List<IUserBean> getAllUser() {
        return userBeanDao.getAll(UserBeanImpl.class.getName());
    }
}
