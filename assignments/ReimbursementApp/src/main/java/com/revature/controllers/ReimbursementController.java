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
import com.revature.beans.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class ReimbursementController {

	private Logger log = Logger.getRootLogger();
	private ReimbursementService rs = new ReimbursementService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("Get request in Reimbursement controller");
		request.getRequestDispatcher("/static/home.html").forward(request, response);
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("Post request delegated to Reimbursement controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/home".length());

		if ("".equals(actualURL)) {
			try {

				PrintWriter writer = response.getWriter();
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbId(1);
				reimb.setAmount(200);
				reimb.setSubmitted(new Date());
				reimb.setDescip("Enthuware");
				reimb.setAuthorId(1);
				reimb.setStatusId(0);
				reimb.setTypeId(4);
				rs.addReimbursement(reimb);
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(reimb);
				writer.write(json);

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

}
