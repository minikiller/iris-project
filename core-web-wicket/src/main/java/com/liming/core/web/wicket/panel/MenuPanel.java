package com.liming.core.web.wicket.panel;

import com.liming.core.web.api.module.IMenuModule;
import com.liming.core.web.wicket.MenuModuleManager;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

import java.util.List;

/**
 * Created by dell on 14-3-23.
 */
public class MenuPanel extends Panel {
    public MenuPanel(String id) {
        super(id);
        List<IMenuModule> menuList = MenuModuleManager.getInstall().getMenuModuleList();
        RepeatingView listItems = new RepeatingView("menuItems");
        if (menuList != null) {

            int i = 0;
            for (IMenuModule menu : menuList) {

                listItems.add(new MenuItemsPanel(listItems.newChildId(), menu, i));
                i++;
            }
        }
        add(listItems);
    }
}