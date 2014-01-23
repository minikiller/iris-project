package com.liming.platform.admin.api.biz;

import com.liming.platform.admin.api.persistence.UserBean;

import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public interface UserBeanService {
    public UserBean addUser(UserBean user);
    public List<UserBean> getAllUser();
}
