package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Reimbursement;
import com.revature.services.ReimbService;

public class ReimbController {
	private Logger log = Logger.getRootLogger();
	private ReimbService rs = new ReimbService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request has been delegated to reimb controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimbs".length());

		log.debug("in delegate get: actualURL is " + actualURL);

		if ("/all".equals(actualURL)) {
			try {

				// get all of the reimbs from the service
				List<Reimbursement> allReimbs = rs.getAll();

				log.debug("allReimbs :" + allReimbs.toString());
				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allReimbs);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.trace("json: " + json);
				log.debug("wrote reimbs to body of the response");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("POST request delegated to reimb controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimbs".length());

		if ("/submit".equals(actualURL)) {

			log.debug("delegate post /reimbs/submit");

			try {
				String j = request.getReader() // get the buffered reader
						.lines() // stream it
						.reduce((acc, cur) -> acc + cur) // reduce it to a single value
						.get(); // get that single value
				log.trace("json received = " + j);
				ObjectMapper om = new ObjectMapper();
				Reimbursement r = om.readValue(j, Reimbursement.class);
				log.trace("object created from json = " + r);

				rs.save(r);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}