package com.liming.core.web.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Created by dell on 14-3-23.
 */
public class IrisApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();
        // Sets Wicket Markup settings for this application
        getMarkupSettings().setStripWicketTags(true);
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");

        // Sets Wicket Request Cycle settings for this application
        getRequestCycleSettings().setBufferResponse(true);
        getRequestCycleSettings().setGatherExtendedBrowserInfo(true);
        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
    }
}
