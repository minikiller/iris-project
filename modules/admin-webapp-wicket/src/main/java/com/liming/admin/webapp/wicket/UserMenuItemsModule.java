package com.liming.admin.webapp.wicket;

import com.liming.admin.webapp.wicket.page.UserPage;
import com.liming.core.web.api.module.IMenuItemsModule;
import org.apache.wicket.Page;

/**
 * Created with IntelliJ IDEA.
 * User: sunlf
 * Date: 14-3-13
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
public class UserMenuItemsModule implements IMenuItemsModule {


    @Override
    public String getNo() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Class<? extends Page> getPageClass() {
        return UserPage.class;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return "模块管理";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getIcon() {
        return "icon-user";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getTag() {
        return "8plat.module.bundles";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
