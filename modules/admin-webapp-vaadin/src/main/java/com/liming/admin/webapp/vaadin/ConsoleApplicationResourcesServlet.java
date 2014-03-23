package com.liming.admin.webapp.vaadin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;


@SuppressWarnings("serial")
public class ConsoleApplicationResourcesServlet extends HttpServlet {

//	private static final Logger logger = LoggerFactory.getLogger(ConsoleApplicationResourcesServlet.class);

	public static final String CONTEXT_PATH_PROPERTY = "contextPath";

	private static final String VAADIN_SERVER_BUNDLE = "com.vaadin.server";

	private static final String VAADIN_THEMES_BUNDLE = "com.vaadin.themes";

	private static final String VAADIN_CLIENT_COMPILED_BUNDLE = "com.vaadin.client-compiled";

	private static final int BUFFER_SIZE = 1024;

	private HttpService httpService;

	private String contextPath;

	private Bundle vaadinServerBundle;

	private Bundle vaadinClientCompiledBundle;

	private Bundle vaadinThemesBundle;

	public void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}

	/**
	 * Gets called when this component is activated.
	 * 
	 * @param bundleContext bundle context
	 * @param properties configuration properties
	 * @throws Exception in case of any errors
	 */
	public void onActivate(BundleContext bundleContext, Map<String, Object> properties) throws Exception {
		for (Bundle bundle : bundleContext.getBundles()) {
			if (VAADIN_SERVER_BUNDLE.equals(bundle.getSymbolicName())) {
				this.vaadinServerBundle = bundle;
			}
			if (VAADIN_THEMES_BUNDLE.equals(bundle.getSymbolicName())) {
				this.vaadinThemesBundle = bundle;
			}
			if (VAADIN_CLIENT_COMPILED_BUNDLE.equals(bundle.getSymbolicName())) {
				this.vaadinClientCompiledBundle = bundle;
			}
		}
		this.contextPath = (String) properties.get(CONTEXT_PATH_PROPERTY);
//		logger.debug("Registering VaadinResourceServlet under the path [{}]...", contextPath);
		this.httpService.registerServlet(this.contextPath, this, null, null);
	}

	/**
	 * Gets called when this component is deactivated.
	 */
	public void onDeactivate(Map<String, Object> componentProperties) {
		String contextPath = (String) componentProperties.get(CONTEXT_PATH_PROPERTY);
//		logger.debug("Unregistering VaadinResourceServlet under the path [{}]...", contextPath);
		this.httpService.unregister(contextPath);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		String resourcePath = this.contextPath + path;

		URL u = this.vaadinServerBundle.getResource(resourcePath);

		if (u == null) {
			u = this.vaadinThemesBundle.getResource(resourcePath);
			if (u == null) {
				u = this.vaadinClientCompiledBundle.getResource(resourcePath);
				if (u == null) {
					resp.sendError(HttpServletResponse.SC_NOT_FOUND,
							String.format("Cannot find a Vaadin resource under the path [%s].", resourcePath));
					return;
				}
			}
		}

		copy(u.openStream(), resp.getOutputStream());
	}

	void copy(InputStream from, OutputStream to) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = from.read(buffer)) != -1) {
			to.write(buffer, 0, read);
		}
	}

}