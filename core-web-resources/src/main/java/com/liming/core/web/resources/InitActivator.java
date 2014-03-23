package com.liming.core.web.resources;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator implements BundleActivator {

    private ServiceReference reference;
    private static BundleContext context;
    private static Logger logger = Logger.getLogger(InitActivator.class);

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        logger.info("Strat-up core web!!");
        context = bundleContext;
        reference = bundleContext.getServiceReference(HttpService.class);
        HttpService httpService = (HttpService) bundleContext.getService(reference);
        httpService.registerResources("/res", "/iris", null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        logger.info("Stop core web bundle!!");
        bundleContext.ungetService(reference);
        context = null;

    }
}
