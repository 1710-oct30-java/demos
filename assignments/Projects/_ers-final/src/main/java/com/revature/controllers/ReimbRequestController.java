package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.ReimbRequest;
import com.revature.beans.User;
import com.revature.services.ErsRequestor;

public class ReimbRequestController implements DelegateController {
	private Logger log = Logger.getRootLogger();

	@Override
	public void delegatePost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, HTTPException {
		ErsRequestor requestor = new ErsRequestor();
		log.info("Attempting to write log to server.");

		requestor.handleNewReimbursement(request);
		request.getRequestDispatcher("/fetch").forward(request, response);
	}

	@Override
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, HTTPException {
		log.info("Get Request received by reimbursement request controller.");
		User currentUser = (User) request.getSession().getAttribute("user");

		if (currentUser == null) {
			ErsRequestor requestor = new ErsRequestor();
			ReimbRequest re = requestor.getRequestById(1);

			response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
			response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");

			response.getWriter().write(JSONStringify(re));

			// log.warn("delegateGet: 403 Forbidden during session " +
			// request.getSession().getId());
			// throw new ErsForbiddenException();
		} else {
			List<ReimbRequest> output = currentUser.getRequests();
			String json = JSONStringify(output);

			response.getWriter().write(json);
			log.info("User on session session " + request.getSession().getId() + " getting reimbursement requests.");

		}
	}

	private String JSONStringify(Object obj) {
		try {
			ObjectMapper map = new ObjectMapper();
			ObjectWriter writer = map.writer().withDefaultPrettyPrinter();
			String json = writer.writeValueAsString(obj);
			return json;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
