package com.liming.platform.admin.api.persistence;

/**
 * Created by dell on 14-1-16.
 */
import com.liming.platform.core.api.persistence.PersistentEntityBean;

public interface UserBean extends PersistentEntityBean {

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);
}
