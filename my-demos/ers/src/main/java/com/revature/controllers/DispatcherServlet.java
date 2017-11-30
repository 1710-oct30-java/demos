package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class DispatcherServlet extends DefaultServlet {
	UserController uc = new UserController();
	ReimbursementController rc = new ReimbursementController();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if (actualURL.startsWith("/static")) {
            super.doGet(request, response);
            return;
        } 
		else if (actualURL.startsWith("/users/")) {
        	uc.processGet(request, response);
        }
		else if (actualURL.startsWith("/reimbursements/")) {
        	rc.processGet(request, response);
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if (actualURL.startsWith("/static")) {
            super.doPost(request, response);
            return;
        } 
		else if (actualURL.startsWith("/users/")) {
        	uc.processPost(request, response);
        }
		else if (actualURL.startsWith("/reimbursements/")) {
        	rc.processPost(request, response);
        }
	}
	
}
