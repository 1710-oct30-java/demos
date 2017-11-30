package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Simple;
import com.revature.service.SimpleService;

public class TypeController {
	private static TypeController ts = new TypeController();
	private SimpleService ss = SimpleService.getReimbursementTypeService();

	private TypeController() {
	}

	Logger log = Logger.getRootLogger();

	public static TypeController getTypeController() {
		return ts;
	}

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		log.trace("Handling Get in TypeController");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/types".length());
		log.trace(actualURL);
		if (actualURL.equals("/types")) {
			log.trace("loading reimbursement Types");
			List<Simple> types = ss.getReimbursementTypes();
			try {
				String json = new ObjectMapper().writeValueAsString(types);
				log.trace(json);
				response.getWriter().write(json);
				log.debug("loaded json and sending");
			} catch (IOException e) {
				log.warn("IO Exception in Type HandleGet! " + e);
			}
		} else if (actualURL.equals("/status")) {
			log.trace("loading reimbursement Statuses");
			List<Simple> statuses = ss.getReimbursementStatuses();
			try {
				String json = new ObjectMapper().writeValueAsString(statuses);
				log.trace(json);
				response.getWriter().write(json);
				log.debug("loaded json and sending");
			} catch (IOException e) {
				log.warn("IO Exception in Type HandleGet! " + e);
			}
		} else if (actualURL.equals("/roles"))
		{
			log.trace("loading User Roles");
			List<Simple> roles = ss.getUserRoles();
			try {
				String json = new ObjectMapper().writeValueAsString(roles);
				log.trace(json);
				response.getWriter().write(json);
				log.debug("loaded json and sending");
			} catch (IOException e) {
				log.warn("IO Exception in Type HandleGet! " + e);
			}
		}
	}
}
