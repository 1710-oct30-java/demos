package com.revature.controllers;

/*
 * Class: UserController
 * Author: Kyle Settles
 * Description: This class is used to handle all of the GET and POST requests sent from the 
 * 		dispatcher servlet that handles all functionality with the user.
 */

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserController {
	
	private UserService us = new UserService();
	
	// handles all GET requests from the servlet
	public void processGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(actualURL) {
		case "/users/logout":
			logout(request,response);
			break;
		}
	}

	// handles all post requests that will need to reach the database for verification
	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(actualURL) {
		case "/users/login":
			login(request,response);
			break;
		case "/users/register":
			register(request,response);
			break;
		}
	}

	// used to handle the logic for registering a user with the database
	private void register(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();			
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(json, User.class);		
			int newUser = us.register(u);
			u.setId(newUser);
			
			// if user is not added to the database, send 401 status code to client
			if(newUser == 0) {
				response.setStatus(401);
			}
			
			// set the JSessionID to the UserId to track the session
			else {
				request.getSession().setAttribute("user", newUser);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// used to handle the logic for logging into the system, checks database to make sure user exists
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc +curr).get();
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(json, User.class);
			User actualUser = us.login(u);
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String jsonUser = ow.writeValueAsString(actualUser);
			
			// if user is not in the database, send a 401 code
			if(actualUser == null) {
				response.setStatus(401);
			}
			
			// sets JsessionID for tracking
			// sets a response header with the user to make check which role they are
			else {
				request.getSession().setAttribute("user", actualUser.getId());
				response.setHeader("user", jsonUser);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// used to logout the user out of the current session, just sets attribute to null
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", null);
	}
}
