package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.revature.beans.User;
import com.revature.services.ServiceUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class LoginController {
	
	
	private Logger log = Logger.getRootLogger();
	private ServiceUser us = new ServiceUser();
	
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
        String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        if ("/home/login".equals(actualURL)) {
            login(request, response);
        }
    }

	
	
/*	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to login controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		request.getRequestDispatcher(actualURL + ".html").forward(request, response);
	}*/
	
	private void login(HttpServletRequest request, HttpServletResponse response) {
        String json;
        try {
            log.debug("The request to login has been received");
            
            json = request.getReader() 
                    .lines() // stream the reader
                    .reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
                    .get(); // get that single string
            
            log.trace("The json was received: " + json);
            
            // this will transfer the body of the request into a real object
            ObjectMapper om = new ObjectMapper();
            User u = om.readValue(json, User.class);
            User currentUser = us.login(u);
            log.trace("Username Received: " + u.getUsername());
            log.trace("Password Received: " + u.getPassword());
            
            ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
            String statusUser = ow.writeValueAsString(currentUser);
            
            
        	if (currentUser == null) {
        		  response.setStatus(401);
        	}
        	else {
        		request.getSession().setAttribute("user", currentUser.getUser_id());
        		response.setHeader("user", statusUser) ;
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}

    