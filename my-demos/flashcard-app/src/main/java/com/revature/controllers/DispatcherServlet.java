package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class DispatcherServlet extends DefaultServlet {
	UserController uc = new UserController();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println("get:"+ actualURL);

        if (actualURL.startsWith("/static")) {
            super.doGet(request, response);
            return;
        } else if (actualURL.startsWith("/users/")) {
        	uc.processGet(request, response);
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println("post:"+ actualURL);

        if (actualURL.startsWith("/users/")) {
        	uc.processPost(request, response);
        }
	}

}
