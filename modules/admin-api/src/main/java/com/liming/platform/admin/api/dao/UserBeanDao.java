package com.liming.platform.admin.api.dao;

import com.liming.platform.admin.api.persistence.UserBean;

import java.util.List;

/**
 * Created by dell on 14-1-16.
 */
public interface UserBeanDao extends GenericDao<UserBean, Long>{
    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */
    List<UserBean> getUserList();

    /**
     * Saves a user's information.
     * @param user the object to be saved
     * @return the persisted User object
     */
    UserBean saveUser(UserBean user);
}
