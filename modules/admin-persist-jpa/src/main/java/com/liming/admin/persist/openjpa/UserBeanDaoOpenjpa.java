package com.liming.admin.persist.openjpa;

import com.liming.admin.api.dao.IUserBeanDao;
import com.liming.admin.api.persistence.IUserBean;
import com.liming.core.impl.persistence.GenericOpenJpaDao;

import java.util.List;

/**
 * Created by dell on 14-1-16.
 */
public class UserBeanDaoOpenjpa extends GenericOpenJpaDao<IUserBean, Long> implements IUserBeanDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public UserBeanDaoOpenjpa() {
//         super(UserBeanImpl.class);
    }

    @Override
    public List<IUserBean> getUserList() {
        return null;
    }

    @Override
    public IUserBean saveUser(IUserBean user) {
        return super.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        super.remove(userId);
    }
}
