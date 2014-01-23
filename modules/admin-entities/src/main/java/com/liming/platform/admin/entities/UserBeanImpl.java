package com.liming.platform.admin.entities;

import com.liming.platform.admin.api.persistence.UserBean;
import com.liming.platform.core.impl.persistence.PersistentEntity;

import javax.persistence.*;


/**
 * Created by dell on 14-1-16.
 */
@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)

public class UserBeanImpl extends PersistentEntity implements UserBean {

    private String name;
    private String password;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
