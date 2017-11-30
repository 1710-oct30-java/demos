package com.revature.controllers;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.services.ReimbursementService;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.ReimbursementType;
import com.revature.beans.Reimbursement;

import org.apache.log4j.Logger;
import com.revature.beans.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

 
public class ReimbursementController {
	private Logger log = Logger.getRootLogger();
	private ReimbursementService rs = new ReimbursementService();
	
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to reimbursement controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
         log.debug(actualURL);
		if("/reimbursements/all".equals(actualURL)) {
			log.debug("It is hitting this line");
			getReimb(request, response);
			return;
			
		}
		else if("/reimbursements/user".equals(actualURL)) {
			getReimbByUser(request, response);
			return;
		}
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("post request delegated to reimbursement controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if("/reimbursements/add".equals(actualURL)) {
			addReimb(request, response);
			return;
		}
		
		else if("/reimbursements/approve".equals(actualURL)) {
			approve(request, response);
			return;
		}
		else if("/reimbursements/deny".equals(actualURL)) {
			deny(request,response);
			return;
		}
	}
    
	
	
	private void deny(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void approve(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String json;	
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();
			
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			
			boolean success = rs.approveReimb(r, (Integer)request.getSession().getAttribute("user"));
			if (success == false) {
				response.setStatus(401);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void addReimb(HttpServletRequest request, HttpServletResponse response) {
	
		String json;	
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();
			
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			r.setAuthorId((Integer)request.getSession().getAttribute("user"));
			boolean success = rs.add(r);
			if (success == false) {
				response.setStatus(401);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private void getReimb(HttpServletRequest request, HttpServletResponse response) {
		String json;	
		List<Reimbursement> allReimb = rs.getAllReimbursement();
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
	private void getReimbByUser(HttpServletRequest request, HttpServletResponse response) {
		String json;	
		List<Reimbursement> reimbUser = rs.getReimbursementsByUser((Integer)request.getSession().getAttribute("user"));
		
		try {
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(reimbUser);
			PrintWriter writer = response.getWriter();
			writer.write(json);
		}
		catch(IOException e) {
			e.printStackTrace();
	}
	}
}


	