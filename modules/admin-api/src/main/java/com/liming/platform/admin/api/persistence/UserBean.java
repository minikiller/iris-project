package com.liming.platform.admin.api.persistence;

/**
 * Created by dell on 14-1-16.
 */
public interface UserBean {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);
}
