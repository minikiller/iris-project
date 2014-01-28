package com.liming.admin.api.persistence;

/**
 * Created by dell on 14-1-16.
 */

import com.liming.core.api.persistence.IPersistentEntity;

public interface IUserBean extends IPersistentEntity {

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);
}
