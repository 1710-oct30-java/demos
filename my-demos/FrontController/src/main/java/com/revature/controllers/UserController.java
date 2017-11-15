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

}
