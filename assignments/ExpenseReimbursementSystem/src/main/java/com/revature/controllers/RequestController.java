package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Request;
import com.revature.beans.User;
import com.revature.services.RequestService;
import com.revature.services.UserService;

public class RequestController {

	private Logger log = Logger.getRootLogger();
	private RequestService rs = new RequestService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to request controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/request".length());
		log.debug(actualURL);
		User u = (User) request.getSession().getAttribute("user");
		int author = u.getId();
		
		/*
		 * Retrieves all pending requests
		 */

		if ("/pending/".equals(actualURL)) {
			try {
				// get all of the pending requests
				List<Request> pendingRequests = rs.getPendingRequests();

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(pendingRequests);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote pending requests to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * Retrieves all approved requests
			 */

		} else if ("/approved/".equals(actualURL)) {
			try {
				// get all of the pending requests
				List<Request> approvedRequests = rs.getApprovedRequests();

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(approvedRequests);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote pending requests to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * Retrieves all denied requests
			 */

		} else if ("/denied/".equals(actualURL)) {
			try {
				// get all of the pending requests
				List<Request> deniedRequests = rs.getDeniedRequests();

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(deniedRequests);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote pending requests to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * Retrieves all requests for the user currently logged in
			 */
			
		} else if ("/userAll".equals(actualURL)) {
			try {
				// get all of the pending requests
				List<Request> userRequests = rs.getUserRequests(author);

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(userRequests);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote pending requests to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * Retrieves all pending requests for the user currently logged in
			 */
			
		} else if ("/userPending".equals(actualURL)) {
			try {
				// get all of the pending requests
				List<Request> userPendingRequests = rs.getUserPendingRequests(author);

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(userPendingRequests);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote pending requests to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if ("/".equals(actualURL) || "".equals(actualURL)) {
			try {
				// get all of the users from the service
				List<Request> allRequests = rs.getAllRequests();

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allRequests);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote users to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {

		log.debug("POST request delegated to request controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/request".length());

		User u = (User) request.getSession().getAttribute("user");

		// Are we using approval username or approval employee id?????
		int author = u.getId();
		String json;

		System.out.println(actualURL);
		
		/* Approves a reimbursement 
		 * 
		 */

		if ("/approve".equals(actualURL)) {

			try {
				json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();

				log.debug("request to post approval to database received");

				log.trace("approved by username received: " + author);
				log.trace("reimbursement id received: " + json);
				log.trace("user id approving request is: " + author);
				
				String n = json.replace("\"", "");
				int jsonNum = Integer.parseInt(n);

				Request req = rs.appRequest(jsonNum, author);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/*
		 * Denies a reimbursement
		 */
		
		
		if ("/deny".equals(actualURL)) {

			try {
				json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();

				log.debug("request to post denial to database received");

				log.trace("denied by username received: " + author);
				log.trace("reimbursement id received: " + json);
				log.trace("user id denying request is: " + author);

				String n = json.replace("\"", "");
				int jsonNum = Integer.parseInt(n);

				Request req = rs.denRequest(jsonNum, author);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if ("/new".equals(actualURL)) {
			try {
				String json2;
				json2 = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
				log.debug("request for new reimbursement received");
				ObjectMapper om = new ObjectMapper();

				Request r = om.readValue(json2, Request.class);
				String output = r.toString();
				System.out.println(output);
				Request nr = rs.newRequest(r, author);

				log.debug("wrote new request to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
