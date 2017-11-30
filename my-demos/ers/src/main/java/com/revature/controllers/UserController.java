package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.beans.UserLogin;
import com.revature.services.UserService;

public class UserController {
	private UserService us = new UserService();
	
	protected void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
	}
	protected void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if(actualURL.equals("/users/login")) {
			login(request, response);
			return;
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String json;
    	try {
    		json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
        	//log.debug("request to login received");
        	//log.trace("json received: " + json);
        	ObjectMapper om = new ObjectMapper();
        	UserLogin u = om.readValue(json, UserLogin.class);
        	//log.trace("username received " + u.getUsername());
        	//log.trace("password received " + u.getPassword());
        	
        	User actualUser = us.login(u);
        	if(actualUser == null) {
        		response.setStatus(401);
        	} else {
        		request.getSession().setAttribute("user", actualUser);
        		response.setStatus(200);
        	}
        	
    	}
    	catch(IOException e) {
    		//log.warn("something is wrong");
    		e.printStackTrace();
    	}
		
	}
}
