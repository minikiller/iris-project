package com.liming.core.impl.system;

import com.liming.core.api.IService;
import com.liming.core.api.biz.IBizService;
import com.liming.core.api.system.IJndiService;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * JNDI 系统服务，用于获得业务服务
 */
public class JndiService implements IJndiService<IBizService> {
    @Override
    public IBizService getOsgiService(IBizService iService) {
        InitialContext ctx = null;
        IBizService offers = null;
        try {
            ctx = new InitialContext();
            String jndiName = "osgi:service/" + IService.class.getName();
            offers = (IBizService) ctx.lookup(jndiName);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return offers;
    }
}
