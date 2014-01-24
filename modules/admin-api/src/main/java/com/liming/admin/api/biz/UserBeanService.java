package com.liming.admin.api.biz;

import com.liming.admin.api.persistence.UserBean;
import com.liming.core.api.biz.IBizService;

import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public interface UserBeanService extends IBizService {
    public UserBean addUser(UserBean user);

    public List<UserBean> getAllUser();
}
