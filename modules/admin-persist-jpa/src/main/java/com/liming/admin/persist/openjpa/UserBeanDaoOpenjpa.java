package com.liming.admin.persist.openjpa;

import com.liming.admin.api.dao.UserBeanDao;
import com.liming.admin.api.persistence.UserBean;
import com.liming.core.impl.persistence.GenericOpenJpaDao;

import java.util.List;

/**
 * Created by dell on 14-1-16.
 */
//public class UserBeanDaoOpenjpa  implements UserBeanDao {
public class UserBeanDaoOpenjpa extends GenericOpenJpaDao<UserBean, Long> implements UserBeanDao {
//    private PersistEntityService persistEntityService;
    /*private EntityManager entityManager;

    public void setEntityManager (EntityManager em) {
        entityManager = em;
    }*/
    /*public void setPersistEntityService(PersistEntityService persistEntityService) {
        this.persistEntityService = persistEntityService;
    }*/

    /**
     * Constructor that sets the entity to User.class.
     */
    public UserBeanDaoOpenjpa() {
//         super(UserBeanImpl.class);
    }

    @Override
    public List<UserBean> getUserList() {
        return null;
    }

    @Override
    public UserBean saveUser(UserBean user) {
        return super.save(user);
    }
}
