package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

import oracle.sql.TIMESTAMP;

public class ReimbursementController {

	private Logger log = Logger.getRootLogger();
	private ReimbursementService rs = new ReimbursementService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to reimbursement controller");
		String actualURL = request.getRequestURI()
				.substring(request.getContextPath().length() + "/reimbursement".length());

		if ("/all".equals(actualURL)) {
			try {
				// get all of the reimbursements from the service
				List<Reimbursement> allReimbursements = rs.getAllReimbursements();

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allReimbursements);
				System.out.println(json);
				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote reimbursements to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("/emp".equals(actualURL)) {
			try {
				// get all of the reimbs by user from the service
				int uid = (int) request.getSession().getAttribute("userId");
				List<Reimbursement> reimbsById = rs.getReimbsById(uid);
				log.debug(reimbsById.toString());
				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(reimbsById);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote reimbursements to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("post request delegated to reimbursement controller");
		String actualURL = request.getRequestURI()
				.substring(request.getContextPath().length() + "/reimbursement".length());
		if ("/add".equals(actualURL)) {
			String json;
			try {
				// get author id from session
				int uid = (int) request.getSession().getAttribute("userId");
				// read the body of the request into a single string
				json = request.getReader() // get buffered reader for reading
											// the request body
						.lines() // stream the reader
						.reduce((acc, cur) -> acc + cur) // reduce the stream to
															// a single string
						.get(); // get that single string
				log.trace("json received: " + json);
				// convert the body of the request into an actual object
				ObjectMapper om = new ObjectMapper();
				Reimbursement r = om.readValue(json, Reimbursement.class);
				log.debug("Description from json is" + r.getDescription());
				r.setAuthor(uid);
				r.setTimeSubmitted(new Timestamp(0));
				log.trace("author received: " + r.getAuthor());
				log.trace("status received: " + r.getStatusId());
				log.trace("description received: " + r.getDescription());
				rs.addReimbursement(r);
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end add method

		if ("/approve".equals(actualURL)) {
			String json;
			try {
				// get author id from session
				int uid = (int) request.getSession().getAttribute("userId");
				// read the body of the request into a single string
				json = request.getReader() // get buffered reader for reading
											// the request body
						.lines() // stream the reader
						.reduce((acc, cur) -> acc + cur) // reduce the stream to
															// a single string
						.get(); // get that single string
				log.trace("json received: " + json);
				String[] numberStrs = json.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "")
						.replaceAll("\"", "").split(",");
				List<Integer> reimbIdsToBeApproved = new ArrayList<>();
				for (int i = 0; i < numberStrs.length; i++) {
					reimbIdsToBeApproved.add(Integer.parseInt(numberStrs[i]));
				}
				rs.approveRequests(uid, reimbIdsToBeApproved);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("/deny".equals(actualURL)) {
			String json;
			try {
				log.debug("deny reimb request requested");
				// get author id from session
				int uid = (int) request.getSession().getAttribute("userId");
				// read the body of the request into a single string
				json = request.getReader() // get buffered reader for reading
											// the request body
						.lines() // stream the reader
						.reduce((acc, cur) -> acc + cur) // reduce the stream to
															// a single string
						.get(); // get that single string
				log.trace("json received: " + json);

				String[] numberStrs = json.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "")
						.replaceAll("\"", "").split(",");
				List<Integer> reimbIdsToBeDenied = new ArrayList<>();
				for (int i = 0; i < numberStrs.length; i++) {
					reimbIdsToBeDenied.add(Integer.parseInt(numberStrs[i]));
				}
				rs.denyRequests(uid, reimbIdsToBeDenied);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
