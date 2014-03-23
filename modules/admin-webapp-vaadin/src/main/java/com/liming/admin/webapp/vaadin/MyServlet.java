package com.liming.admin.webapp.vaadin;

import com.vaadin.server.*;
import com.vaadin.ui.UI;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import javax.servlet.ServletException;

/**
 * Created by dell on 14-1-17.
 */
public class MyServlet extends VaadinServlet {
    private HttpService httpService;
    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    @Override
    public void init(javax.servlet.ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        getService().addSessionInitListener(new SessionInitListener() {
            @Override
            public void sessionInit(SessionInitEvent event) throws ServiceException {
                try {
                    onVaadinSessionStarted(event.getRequest(), event.getSession());
                } catch (ServletException e) {
                    throw new ServiceException(e);
                }
            }
        });
    }

    private void onVaadinSessionStarted(VaadinRequest request, VaadinSession session) throws ServletException {
//        logger.debug("Registering custom UIProvider");
        session.addUIProvider(new CustomUIProvider());
    }
    public void activate() {
        try {
            httpService.registerServlet("/myconsole", this, null, null);
        } catch (NamespaceException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void deactivate() {

    }
    private final class CustomUIProvider extends UIProvider {

        private static final long serialVersionUID = 5034642943189390165L;

        @Override
        public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
            return MyVaadinUI.class;
        }

        @Override
        public UI createInstance(com.vaadin.server.UICreateEvent event) {
            return new MyVaadinUI();
        }
    };
}
