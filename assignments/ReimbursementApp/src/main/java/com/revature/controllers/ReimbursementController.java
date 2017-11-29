package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
public class ReimbursementController {

	private Logger log = Logger.getRootLogger();
	private ReimbursementService rs = new ReimbursementService();
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("Get request in Reimbursement controller");
		request.getRequestDispatcher("/static/reimbursements.html").forward(request, response);
		//List to store retrieved reimbursements
		List<Reimbursement> rl = new ArrayList<>();
		//Gets current logged in User's ID
		int userId = (int) request.getSession(false).getAttribute("userId");
		rl = rs.getReimbursements(userId);
		log.trace(rl);
		
		//Convert reimbursements to JSON
	    String json = new Gson().toJson(rl);
	    log.trace(json);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	    
	    //Exception thrown here
	    response.getWriter().close();
	    
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("Post request delegated to Reimbursement controller");
		//String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/home".length());

			try {
				String json = request.getReader() // Get the buffered reader for reading request body
						.lines() // Stream it
						.reduce((acc, curr) -> acc + curr) // Convert lines to one String
						.get(); // Get that single string value
				ObjectMapper om = new ObjectMapper();
				Reimbursement newReimbursement = om.readValue(json, Reimbursement.class);
				newReimbursement.setAuthorId((int) request.getSession(false).getAttribute("userId"));
				log.trace("Author: " + newReimbursement.getAuthorId());
				log.trace("Type received: " + newReimbursement.getTypeId());
				log.trace("Amount: $ " + newReimbursement.getAmount());
				log.trace("Description: ) "+ newReimbursement.getDescip());
				log.trace("Time: " + newReimbursement.getSubmitted());
				rs.addReimbursement(newReimbursement);
				
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
