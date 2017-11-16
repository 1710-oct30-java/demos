package com.controller.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.controller.LoginController;

public class DispatchServlet extends DefaultServlet
{
	Logger log = Logger.getRootLogger();
	private LoginController lc = new LoginController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		if (actualURL.startsWith("/static"))
		{
			super.doGet(request, response);
			return;
		}

		if ("/".equals(actualURL))
		{
			lc.delegateGet(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		log.debug("post request made with url" + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		if ("/login".equals(actualURL))
			lc.delegatePost(request, response);

	}
}
