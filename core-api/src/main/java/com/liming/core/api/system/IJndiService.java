package com.liming.core.api.system;

import com.liming.core.api.IService;

/**
 * Created by dell on 14-1-26.
 */
public interface IJndiService<T extends IService> extends IService {
    T getOsgiService(T t);
}
