package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Reimbursement;
import com.revature.services.ReimbursementService;

public class HomeController {
	private Logger log = Logger.getRootLogger();
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("Get request in Home controller");
		request.getRequestDispatcher("/static/home.html").forward(request, response);
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("Post request delegated to Home controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/home".length());

		
	}
}
