package com.revature.controllers;

/*
 * Class: ReimbursementController
 * Author: Kyle Settles
 * Description: This class is used for taking in requests from the dispatcher servlet
 * 		and then calls the method needed from the reimbursement service for each task performed
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementController {
	
	private ReimbursementService rs = new ReimbursementService();

	// used to decide what happens when the server sends a POST request
	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(actualURL) {
		case "/reimbursements/add":
			add(request,response);
			break;
		case "/reimbursements/approve":
			approve(request,response);
			break;
		case "/reimbursements/deny":
			deny(request,response);
			break;
		}
	}

	// used to decide what happens when the server sends a GET request
	public void processGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
	
		switch(actualURL) {
		case "/reimbursements/all":
			displayAll(request,response);
			break;
		case "/reimbursements/user":
			getUserReimbursements(request,response);
			break;
		}
	}
	
	// method used to display reimbursements for a specific user on the webpage
	// converts the reimbursements to json and sends to server
	private void getUserReimbursements(HttpServletRequest request, HttpServletResponse response) {
		String json;
		List<Reimbursement> userReimb = rs.getByUser((Integer)request.getSession().getAttribute("user"));
				
		try {
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(userReimb);
			PrintWriter writer = response.getWriter();
			writer.write(json);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	// method used to display all reimbursements on the webpage
	// converts the reimbursements to json and sends back to server
	private void displayAll(HttpServletRequest request, HttpServletResponse response) {
		String json;
		List<Reimbursement> allReimb = rs.getAllReimb();
		
		try {
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(allReimb);
			PrintWriter writer = response.getWriter();
			writer.write(json);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// used to add a reimbursement takes info from client and creates a reimbursement 
	// to be sent to the database
	private void add(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			r.setAuthorId((Integer)request.getSession().getAttribute("user"));
			int newReimbursement = rs.add(r);
			
			r.setId(newReimbursement);
			
			if(newReimbursement == 0) {
				response.setStatus(401);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void approve(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();			
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			System.out.println("attempting to approve reimbursement");
			boolean success = rs.statusChange(r, "approve", (Integer)request.getSession().getAttribute("user"));
			
			if(success == false) {
				response.setStatus(401);
				response.setHeader("error", "manager");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deny(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			boolean success = rs.statusChange(r, "deny", (Integer)request.getSession().getAttribute("user"));
			
			if(success == false) {
				response.setStatus(401);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
