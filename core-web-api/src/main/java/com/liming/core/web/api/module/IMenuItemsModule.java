package com.liming.core.web.api.module;

/**
 * Created with IntelliJ IDEA.
 * User: sunlf
 * Date: 2014-3-24
 * Time: 下午2:32
 * 菜单项模块（此菜单项模块下面包含page页面）
 */


public interface IMenuItemsModule extends IPageModule {
    /**
     * 菜单编号
     *
     * @return
     */
    public String getNo();
}