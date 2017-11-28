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
		List<Reimbursement> rl = new ArrayList<>();
		int userId = (int) request.getSession(false).getAttribute("userId");
		rl = rs.getReimbursements(userId);
		log.trace(rl);
//		PrintWriter writer = response.getWriter();
//		ObjectMapper om = new ObjectMapper();
//		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
//		String printJson = ow.writeValueAsString(rl);
//		writer.write(printJson);
		
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
				PrintWriter writer = response.getWriter();
				Reimbursement reimb = new Reimbursement();
				rs.addReimbursement(newReimbursement);
				//ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				//String printJson = ow.writeValueAsString(reimb);
				//writer.write(printJson);

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
