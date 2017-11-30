package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.exceptions.InvalidCredentialException;
import com.revature.exceptions.UrlNotRecognizedException;
import com.revature.services.UserService;

public class DispatcherServlet extends DefaultServlet {
	private UserController uc = new UserController();
	private ReimbController rc = new ReimbController();
	private UserService us = new UserService();
	private Logger log = Logger.getRootLogger();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		// System.out.println(actualURL);
		log.debug("actualURL: " + actualURL);

		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		} else if (actualURL.equals("/home")) {
			// forward, the clients url will not change
			request.getRequestDispatcher("/static/index.html").forward(request, response);
			// redirect, the clients url will change
			// response.sendRedirect(request.getContextPath() + "/static/index.html");
		} else if (actualURL.startsWith("/user")) {
			uc.delegateGet(request, response);
		} else if (actualURL.startsWith("/reimb")) {
			rc.delegateGet(request, response);
		} else {
			throw new UrlNotRecognizedException();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request made with url" + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		if (actualURL.startsWith("/reimb")) {
			rc.delegatePost(request, response);
		} else if ("/login".equals(actualURL)) {
			System.out.println("login");
			try {
				uc.delegatePost(request, response);
			} catch (InvalidCredentialException e) {
				e.printStackTrace();
			}
		} else {
			throw new UrlNotRecognizedException();
		}
	}
}