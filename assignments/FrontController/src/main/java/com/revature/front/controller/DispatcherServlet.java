package com.revature.front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class DispatcherServlet extends DefaultServlet {
	
	// private UserController uc = new UserController();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);
		
		if(actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		}
		
		if ("/home".equals(actualURL)) {
			request.getRequestDispatcher("/static/index.html").forward(request, response);
			
			// response.sendRedirect(request.getContextPath() + "/static/index.html");
		}
		
		if(actualURL.startsWith("/user")) {
			// uc.delegateGet(request, response);
		}
	}
}
