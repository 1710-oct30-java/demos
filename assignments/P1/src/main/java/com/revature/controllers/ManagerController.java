package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import com.revature.token.Token;
import com.revature.util.Tools;

public class ManagerController {
	private static ManagerController mc = new ManagerController();
	private static Logger log = Logger.getRootLogger();
	private static Token t = Token.getToken();
	private static Tools tools = Tools.getTools();
	private UserService us = UserService.getUserService();
	private ReimbursementService rs = ReimbursementService.getReimburesmentService();

	private ManagerController() {
	}

	public static ManagerController getManagerController() {
		return mc;
	}

	public void handlePut(HttpServletRequest request, HttpServletResponse response) {
		log.trace("In Manager Put");
		if (t.validateToken(request)) {
			String json;
			try {
				json = request.getReader().lines().reduce((c, a) -> c + a).get();
				log.trace(json);
				if (rs.putReimbursement(json, (User) request.getSession().getAttribute("user"))) {
					response.setStatus(200);
				} else {
					response.setStatus(401);
				}
			} catch (IOException e) {
				log.warn("Failed to parse json: " + e);
			}
		} else {
			try {
				response.sendError(403);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}

	}

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		log.trace("In Manager Get");
		if (t.validateToken(request)) {
			String actualURL = request.getRequestURI()
					.substring(request.getContextPath().length() + "/manager".length());
			if (actualURL.length() == 0) {
				try {
					request.getRequestDispatcher("/static/ManagerMainPage.html").forward(request, response);
				} catch (ServletException | IOException e) {
					log.error("Something went really bad " + e);
				}
			} else if (actualURL.equals("/me")) {
				log.trace("sending me");
				User u = (User) request.getSession().getAttribute("user");
				tools.loadResponseSingle(response, u);
			} else if (actualURL.equals("/reims")) {
				log.debug("attempting to get all reims");
				List<Reimbursement> reims = rs.getAllReimbursements();
				List<Object> objects = tools.removeReceiptAndObjectify(reims);
				log.trace(objects);
				if (reims != null) {
					if (tools.loadResponseList(response, objects)) {
						log.info("sucessfully loaded all reims");
					} else {
						response.setStatus(500);
					}
				} else {
					response.setStatus(500);
				}
			} else if (actualURL.equals("/users")) {
				log.debug("attempting to get all users");
				List<User> users = us.getUsers();
				List<Object> objects = new ArrayList<>();
				objects.addAll(users);
				log.trace(objects);
				if (users != null) {
					if (tools.loadResponseList(response, objects)) {
						log.info("successfully loaded all users");
					} else {
						response.setStatus(500);
					}
					return;
				} else {
					response.setStatus(500);
				}
			} else {
				response.setStatus(404);
			}
		} else {
			try {
				response.sendError(403);
			} catch (IOException e) {
				log.error("This shouldn't exist: " + e);
			}
		}
	}
}
