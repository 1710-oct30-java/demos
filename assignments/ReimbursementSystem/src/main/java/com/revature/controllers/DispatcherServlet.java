package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

/*
 * Front controller is in charge of delegating the tasks to the other controllers
 */
public class DispatcherServlet extends DefaultServlet {
	UserController uc = new UserController();//user controller
	ReimbursementController rc = new ReimbursementController();//reimbursement controller
	
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException,ServletException{
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("From doGet" + actualURL);
		
	
		//static to access static content in the static folder
		if(actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		}else if(actualURL.startsWith("/users/")) {
			uc.delegatedGet(request, response);
		}else if(actualURL.startsWith("/reimbursements/")) {
			rc.delegateGet(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("actual url " + actualURL);
		if(actualURL.startsWith("/users/")) {
			uc.delegatePost(request, response);
		}else if(actualURL.startsWith("/reimbursements")) {
			rc.delegatePost(request, response);
		}
	}
	
	
	
	
}
