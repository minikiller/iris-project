package com.liming.admin.webapp.wicket;

import com.liming.core.web.api.module.IMenuModule;

/**
 * Created with IntelliJ IDEA.
 * User: sunlf
 * Date: 14-3-10
 * Time: 下午4:58
 * To change this template use File | Settings | File Templates.
 */
public class AdminMenuModule implements IMenuModule {
    @Override
    public String getTargetTag() {
        return new String("8plat.module.bundles");
    }

    @Override
    public String getName() {
        return "系统模块管理";
    }

    @Override
    public String getIcon() {
        return "icon-user";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getTag() {
        return "8plat";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
