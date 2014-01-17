package com.liming.platform.admin.entities;

import com.liming.platform.admin.api.persistence.UserBean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dell on 14-1-16.
 */
@Entity
@Table(name = "app_user")
public class UserBeanImpl implements UserBean,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
