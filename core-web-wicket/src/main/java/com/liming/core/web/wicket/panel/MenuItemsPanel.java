package com.liming.core.web.wicket.panel;

import com.liming.core.web.api.module.IMenuItemsModule;
import com.liming.core.web.api.module.IMenuModule;
import com.liming.core.web.api.module.IModule;
import com.liming.core.web.wicket.MenuModuleManager;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

/**
 * Created by dell on 14-3-23.
 */
public class MenuItemsPanel extends Panel {

    private WebMarkupContainer subMenusContainer = new WebMarkupContainer("submenusContainer");

    private WebMarkupContainer menusContainer = new WebMarkupContainer("menusContainer");

    public MenuItemsPanel(String id, final IMenuModule menus, final int index) {
        super(id);
        Link menusLink = new StatelessLink("menus") {
            @Override
            public void onClick() {
            }

            protected java.lang.CharSequence getURL() {

                return "javascript:void(0);";
            }
        };

        //获取目录下面的子菜单
        List<IModule> submenus = MenuModuleManager.getInstall().findMenusByTag(menus.getTargetTag());
        Label iconLabel = new Label("name", " <i class=\"" + menus.getIcon() + "\"></i>" + menus.getName());
        iconLabel.setEscapeModelStrings(false);
        iconLabel.setRenderBodyOnly(true);
        menusLink.add(iconLabel);
        menusContainer.add(menusLink);

        //菜单消息数量
        Label msgNumLabel = new Label("msgNum", "");
        msgNumLabel.setOutputMarkupId(true);
        msgNumLabel.setVisible(false);//暂时隐藏
        menusLink.add(msgNumLabel);

        //打开箭头
        Label jiantouLabel = new Label("jiantou", "");
        jiantouLabel.setOutputMarkupId(true);
        jiantouLabel.setRenderBodyOnly(true);
        jiantouLabel.setVisible(submenus == null || submenus.size() <= 0 ? false : true);//暂时隐藏
        menusLink.add(jiantouLabel);

        ListView<IModule> links = new ListView<IModule>("menusItems", submenus) {

            int i = 0;

            @Override
            protected void populateItem(final ListItem<IModule> item) {
                //  BookmarkablePageLink submenusLink = new BookmarkablePageLink("menus", ((IMenusModule)item.getModelObject()).getPageClass());
                StatelessLink submenusLink = new StatelessLink("menus") {
                    @Override
                    public void onClick() {
                        getSession().setAttribute("menus", index + "," + i);
                        setResponsePage(((IMenuItemsModule) item.getModelObject()).getPageClass());
                    }


                };
                i++;
                submenusLink.setOutputMarkupId(true);
                submenusLink.add(new Label("name", " <i class=\"" + item.getModelObject().getIcon() + "\"></i>" + item.getModelObject().getName()).setRenderBodyOnly(true).setEscapeModelStrings(false));
                item.add(submenusLink);


               /* String role = RolesManager.getInstall().getRoleByClassName( ((IMenusModule)item.getModelObject()).getPageClass().getName());
                if(role!=null){
                    MetaDataRoleAuthorizationStrategy.authorize(((IMenusModule) item.getModelObject()).getPageClass(), role);
                }
*/


            }
        };

        subMenusContainer.setVisible(submenus.size() > 0 ? true : false);
        subMenusContainer.add(links);

        menusContainer.add(subMenusContainer);

        add(menusContainer);

    }
}
