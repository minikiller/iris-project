package com.liming.admin.entities;

import com.liming.admin.api.persistence.IUserBean;
import com.liming.core.impl.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


/**
 * Created by dell on 14-1-16.
 */
@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)

public class UserBeanImpl extends PersistentEntity implements IUserBean {

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
