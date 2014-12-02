package cn.zy.commons.webdev.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.zy.commons.webdev.props.ApplicationConfiguration;

/**
 * 
 * @author zy
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConfigureLoaderListener implements ServletContextListener {

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {

		// Get application configuration location.
		String appConfigLocation = event.getServletContext().getInitParameter(
				"appConfigLocation");

		// Check application configuration file.
		if (appConfigLocation == null) {
			appConfigLocation = "classpath:config.properties";
		}

		// Load configuration file.
		if (appConfigLocation.startsWith("classpath:")) {

			// Load from classpath.
			ApplicationConfiguration.load(this.getClass().getResourceAsStream(
					"/" + appConfigLocation.substring(10).trim()));
		} else {

			// Load from Web root.
			ApplicationConfiguration.load(event.getServletContext()
					.getResourceAsStream(appConfigLocation.trim()));
		}
	}

}