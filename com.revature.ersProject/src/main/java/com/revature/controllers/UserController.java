package com.revature.controllers;
//Creator: Robert Choboy
//UserController
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.services.ServiceUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UserController {

	private Logger log = Logger.getRootLogger();
	ServiceUser us = new ServiceUser();
	
//Get
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("The get request was delegated to the user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		request.getRequestDispatcher(actualURL + ".html").forward(request, response);		
	}
//Get Data	
	public void delegateGetData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.debug("The get request was delegated to the user controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		request.getRequestDispatcher(actualURL + ".html").forward(request, response);

		if (actualURL.equals("/pages/data")) {
			try {

				int status_id = 0;
				try {
					status_id = Integer.parseInt(request.getParameter("id"));
				} catch (Exception e) {
					e.printStackTrace();
				}

				List<Reimbursement> list = us.getReimbursementsByStatusId(status_id);
				
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(list);

				System.out.println(json);
				
				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);
				
				log.debug("json was written to body of response");
				
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
