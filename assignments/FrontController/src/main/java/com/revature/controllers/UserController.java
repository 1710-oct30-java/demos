package com.revature.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jdk.internal.instrumentation.Logger;

public class UserController {
	private Logger log = Logger.getRootLogger();
	private UserS
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user".length());
		
		if("/".equals(actualURL) || "".equals(actualURL)) {
			try {
				
				List<User> allUsers = us.getAllUsers();
				
				ObjectMapper om  = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allUsers);
				
				PrintWriter writer = response.getWriter();
				writer.write("This goes in the body of our response");
				
				log.debug("wrote users to the body of the response");
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
