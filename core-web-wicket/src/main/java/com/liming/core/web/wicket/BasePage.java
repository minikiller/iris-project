package com.liming.core.web.wicket;

import com.liming.core.web.wicket.border.NavomaticBorder;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by dell on 14-3-23.
 */
public class BasePage extends WebPage {
    private NavomaticBorder navomaticBorder;

    public BasePage(PageParameters parameters) {
        super(parameters);
        navomaticBorder =new NavomaticBorder("iris");
        add(navomaticBorder);
    }
}
