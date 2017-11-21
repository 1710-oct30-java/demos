package com.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UserController {

	private Logger log = Logger.getRootLogger();
	UserService us = new UserService();

	/**
	 * Get request delegated to user controller
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		request.getRequestDispatcher(actualURL + ".html").forward(request, response);		
	}
	
	public void delegateGetData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("get request delegated to user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		//request.getRequestDispatcher(actualURL + ".html").forward(request, response);
		
		if (actualURL.equals("/pages/data")) {
			try {

				int status_id = 0;
				try {
					status_id = Integer.parseInt(request.getParameter("id"));
				} catch (Exception e) {
					e.printStackTrace();
				}

				List<Reimbursement> list = us.getReimbursementsByStatusId(status_id);

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(list);

				System.out.println(json);
				
				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);
				
				log.debug("wrote to body of response");
				
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
/*
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("post request delegated to user controller");
		try {
			List<Reimbursement> list = us.getReimbursementsByUser(us.getUserFromCredentials("abarry"));

			// convert arraylist to json
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(list);

			// write json to the body of the response
			PrintWriter writer = response.getWriter();
			writer.write(json);
			System.out.println(json);

			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/

}
