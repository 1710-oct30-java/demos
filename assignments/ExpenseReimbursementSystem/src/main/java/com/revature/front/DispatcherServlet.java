package com.revature.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controllers.RequestController;
import com.revature.controllers.UserController;

public class DispatcherServlet extends DefaultServlet {
	private UserController uc = new UserController();
	private RequestController rc = new RequestController();
	Logger log = Logger.getRootLogger();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		}

		if (actualURL.startsWith("/user/")) {
			uc.delegateGet(request, response);
		}

		if (actualURL.startsWith("/request/")) {
			rc.delegateGet(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request made with url" + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		if (actualURL.startsWith("/request/")) {
			rc.delegatePost(request, response);
		}

		if (actualURL.startsWith("/user/")) {
			uc.delegatePost(request, response);
		}

	}

}
