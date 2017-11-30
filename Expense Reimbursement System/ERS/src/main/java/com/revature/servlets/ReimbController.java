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
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimb".length());

		if (actualURL.equals("/") || actualURL.equals("")) {
			try {
				// get all of the reimbs from the service
				List<Reimbursement> allReimbs = rs.getAll();

				// convert arraylist to json
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allReimbs);

				// write json to the body of the response
				PrintWriter writer = response.getWriter();
				writer.write(json);

				log.debug("wrote reimbs to body of the response");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to reimb controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimb".length());

		if (actualURL.equals("")) {
			try {
				String json = request.getReader() // get the buffered reader
						.lines() // stream it
						.reduce((acc, cur) -> acc + cur) // reduce it to a single value
						.get(); // get that single value
				log.trace("json received = " + json);
				ObjectMapper om = new ObjectMapper();
				Reimbursement r = om.readValue(json, Reimbursement.class);
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