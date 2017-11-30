package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserController {
	Logger log = Logger.getRootLogger();

	private UserService us = new UserService();

	public void delegatedGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if("/users/home".equals(actualURL)) {
			log.debug("Home Page");
			User u = (User) request.getSession().getAttribute("user");
			try {
				
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(u);
				
				PrintWriter writer = response.getWriter();
				writer.write(json);
				
				log.debug("wrote user info at home page");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//if the user role id is equal to 2 load the home page for a regular user
//			if(u.getRoleId().getUserRoleId() == 2) {
//				//create this later
//			}
		}
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/users/login".equals(actualURL)) {
			login(request, response);
			
			//display the information of the user
			User user = (User) request.getSession().getAttribute("user");
			log.debug("session user: " + user);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// get json
		String json;
		try {
			log.debug("Request to login received");

			// read the body of the request into a single string
			json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
			log.trace("json received: " + json);
			log.debug("request to login received");

			// convert the body of the request into an actual object
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(json, User.class);
			log.trace("username received: " + u.getUsername());
			log.trace("password received: " + u.getPassword());

			// call the user login function
			User actualUser = us.login(u);
			if (actualUser == null) {
				response.setStatus(401);
			} else {
				request.getSession().setAttribute("user", actualUser);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
