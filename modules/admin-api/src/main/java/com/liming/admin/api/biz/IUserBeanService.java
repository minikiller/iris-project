package com.liming.admin.api.biz;

import com.liming.admin.api.persistence.IUserBean;
import com.liming.core.api.biz.IBizService;

import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public interface IUserBeanService extends IBizService {
    public IUserBean addUser(IUserBean user);

    public List<IUserBean> getAllUser();
}
