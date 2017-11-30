package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.beans.ErsUser;
import com.revature.exceptions.InvalidCredentialException;
import com.revature.services.ErsUserService;

public class ErsUserController extends DefaultServlet {
	private Logger log = Logger.getRootLogger();
	private ErsUserService us = new ErsUserService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        
		super.service(req, resp);
	}
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimbursement".length());
		
		if("/all/".equals(actualURL) || "/all".equals(actualURL)) {
			// get all users
			List<ErsUser> allUsers = us.getAllUsers();
		} 
	}

	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
        if ("/users/login".equals(actualURL)) {
            try {
				us.login(request, response);
			} catch (InvalidCredentialException e) {
				// TODO Auto-generated catch block
				response.setStatus(403);
				e.printStackTrace();
			}
            return;
        } else if ("/users/new".equals(actualURL)) {
        	us.create(request, response);
        	return;
        }
	}
}
