package com.liming.platform.core.api.persistence;

import java.util.Date;

/**
 * Created by dell on 14-1-22.
 */
public interface PersistentEntityBean {
    long getId();

    void setId(long id);

    long getVersion();

    void setVersion(long vers);

    Date getCreationDate();

    void setCreationDate(Date creationDate);
}
