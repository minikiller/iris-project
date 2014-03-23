package com.liming.core.api.persistence;

import com.liming.core.api.IEntity;

import java.util.Date;

/**
 * 持久化实体接口
 */

public interface IPersistentEntity extends IEntity {
    long getId();

    void setId(long id);

    long getVersion();

    void setVersion(long vers);

    Date getCreationDate();

    void setCreationDate(Date creationDate);
}
