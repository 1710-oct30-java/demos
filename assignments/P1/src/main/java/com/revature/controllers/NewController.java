package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.service.UserService;

public class NewController {
	private static NewController nc = new NewController();
	private UserService us = UserService.getUserService();
	private Logger log = Logger.getRootLogger();
	private NewController() {super();}
	public static NewController getNewController() {
		return nc;
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((c,a)->c+a).get();
			if(us.postUser(json))
			{
				response.setStatus(200);
			}
			else
			{
				response.setStatus(401);
			}
		} catch (IOException e) {
			log.warn("Failed to parse json: " + e);
		}
		
	}
	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("static/CreateUserPage.html").forward(request, response);
		} catch (ServletException | IOException e) {
			//response.setStatus(500);
			log.info("issue in new controller get");
		}
		
	}

}
