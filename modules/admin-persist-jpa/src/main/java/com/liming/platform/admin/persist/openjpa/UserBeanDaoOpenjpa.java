package com.liming.platform.admin.persist.openjpa;

import com.liming.platform.admin.api.dao.UserBeanDao;
import com.liming.platform.admin.api.persistence.UserBean;
import com.liming.platform.admin.entities.UserBeanImpl;

import java.util.List;

/**
 * Created by dell on 14-1-16.
 */
public class UserBeanDaoOpenjpa extends GenericDao<UserBean, Long> implements UserBeanDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public UserBeanDaoOpenjpa() {
        super(UserBean.class);
    }
    @Override
    public List<UserBean> getUserList() {
        return this.getAll();
    }

    @Override
    public UserBean saveUser(UserBean user) {
        return this.save(user);
    }
}
