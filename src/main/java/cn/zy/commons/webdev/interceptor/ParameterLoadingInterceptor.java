/* @(#) ParameterLoadingInterceptor.java
 * Project:	web-commons
 * Package: cn.videoworks.webdev.commons.interceptor
 * Author:	LuoChuan
 * Date:	Jun 17, 2013
 * Copyright © 2010-2013 by Beijing VideoWorks Technology Co., Ltd. All rights reserved.
 */
package cn.zy.commons.webdev.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.zy.commons.webdev.vo.Project;
import cn.zy.commons.webdev.vo.SEO;


import java.util.Properties;

/**
 * Load parameters to current request.
 *
 * @author zy
 * @version 1.0.0
 * @since 1.0.0
 */
public class ParameterLoadingInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private Properties appConfig;

	/*
	 * (non-Javadoc)
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response, Object handler) throws Exception {

		// Set project name and project title.
		request.setAttribute("project", new Project(
				appConfig.getProperty("project.name"), appConfig.getProperty("project.title"),
				appConfig.getProperty("project.static_domain")));

		// Set SEO parameters.
		request.setAttribute("seo", new SEO(appConfig.getProperty("seo.keywords"),
				appConfig.getProperty("seo.description")));

		return true;
	}
}
