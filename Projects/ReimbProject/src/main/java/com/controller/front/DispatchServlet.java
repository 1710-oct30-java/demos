package com.controller.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.controller.LoginController;
import com.controller.ReimbController;

public class DispatchServlet extends DefaultServlet
{
	Logger log = Logger.getRootLogger();
	private LoginController lc = new LoginController();
	private ReimbController rc = new ReimbController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// System.out.println(request.getContextPath());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		log.debug("get request in DispatchService: " + request.getRequestURI());
		if (actualURL.startsWith("/static"))
		{
			super.doGet(request, response);
			return;
		}
		else
		{
			switch (actualURL)
			{
			case "/":
				request.getRequestDispatcher("/static/index.html").forward(request, response);
				break;
			case "/login":
				lc.delegateGet(request, response);
				break;
			case "/reimb":
				rc.delegateGet(request, response);
				break;
			default:
				request.getRequestDispatcher("/static/index.html").forward(request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		log.debug("post request in DispatchService: " + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		if ("/login".equals(actualURL))
		{
			lc.delegatePost(request, response);
		}

	}
}
