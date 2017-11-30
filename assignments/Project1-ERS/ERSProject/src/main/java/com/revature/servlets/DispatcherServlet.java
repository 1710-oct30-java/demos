package com.revature.servlets;

/*
 * Class: DispatcherServlet
 * Author: Kyle Settles
 * Description: Servlet used to take in all HTTP requests and passes them on
 * 		to their respective controllers for further handling
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.controllers.ReimbursementController;
//import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;

public class DispatcherServlet extends DefaultServlet{

	private static final long serialVersionUID = -4309074987629377240L;

	private ReimbursementController rc = new ReimbursementController();
	private UserController uc = new UserController();
	
	// delegates get requests to their controllers
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(actualURL.startsWith("/Static")) {
			super.doGet(request, response);
			return;
		}
		else if(actualURL.startsWith("/reimbursements")) {
			rc.processGet(request, response);
		}
		else if(actualURL.startsWith("/users/")){
			uc.processGet(request, response);
		}
	}
	
	// delegates post requests to their controllers
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		if(actualURL.startsWith("/users/")) {
			uc.processPost(request, response);
		}
		else if(actualURL.startsWith("/reimbursements")) {
			rc.processPost(request,response);
		}
	}
}
