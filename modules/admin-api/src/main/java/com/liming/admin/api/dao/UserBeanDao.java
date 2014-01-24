package com.liming.admin.api.dao;

import com.liming.admin.api.persistence.UserBean;
import com.liming.core.api.persistence.GenericDao;

import java.util.List;

/**
 * Created by dell on 14-1-16.
 */
//public interface UserBeanDao {
public interface UserBeanDao extends GenericDao<UserBean, Long> {
    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */
    List<UserBean> getUserList();

    /**
     * Saves a user's information.
     *
     * @param user the object to be saved
     * @return the persisted User object
     */
    UserBean saveUser(UserBean user);
}
