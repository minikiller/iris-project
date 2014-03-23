package com.liming.core.web.wicket.border;

import com.liming.core.web.wicket.panel.HeaderPanel;
import com.liming.core.web.wicket.panel.MenuPanel;
import org.apache.wicket.markup.html.border.Border;

/**
 * Created by dell on 14-3-23.
 */
public class NavomaticBorder extends Border {
    public NavomaticBorder(String id) {
        super(id);
        add(new HeaderPanel("header")).setRenderBodyOnly(true);
        add(new MenuPanel("menu").setRenderBodyOnly(true));
    }
}
