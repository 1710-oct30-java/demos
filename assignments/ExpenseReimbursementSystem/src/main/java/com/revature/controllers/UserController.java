package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserController {

	private Logger log = Logger.getRootLogger();
	private UserService us = new UserService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user".length());
		
		

		/*
		 * Retrieves all users
		 * NOTE: We do not use the functionality in the web app
		 * but it supports it
		 */
		
		if ("/".equals(actualURL) || "".equals(actualURL)) {
			try {
				// get all of the users from the service
				List<User> allUsers = us.getAllUsers();

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allUsers);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote users to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if("/user/login".equals(actualURL)) {
			login(request,response);
		}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if("/user/login".equals(actualURL)) {
			String json;
			try {
				json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
				log.debug("request to login received");
				ObjectMapper om = new ObjectMapper();
				User u = om.readValue(json, User.class);
				log.trace("username received: " + u.getUsername());
				log.trace("password received: " + u.getPassword()) ;
				
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				// write json to the body of the response

				User actualUser = us.login(u);
				String uid = Integer.toString(actualUser.getRole());
				
				PrintWriter writer = response.getWriter();
				writer.write(uid);
				System.out.println("id: " + uid);
				
				String test = actualUser.toString();
				log.trace("ACTUAL USER: " + test);
				
				if(actualUser == null) {
					response.setStatus(401);
				} else {
					request.getSession().setAttribute("user", actualUser);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// User u = (User) request.getSession().getAttribute("user");
		
	}
	

}
