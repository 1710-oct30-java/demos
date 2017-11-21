package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.UserConfig;

public class DispatcherServlet extends DefaultServlet {
	UserController uc = new UserController();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		} else if(actualURL.startsWith("/users/")) {
			uc.processGet(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);
		
		if (actualURL.startsWith("/users/")) {
			uc.processPost(request, response);
		}
	}
}
