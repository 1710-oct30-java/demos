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

public class AdminController {
	private static Token t = Token.getToken();
	private Logger log = Logger.getRootLogger();
	private static AdminController ac = new AdminController();
	private UserService us = UserService.getUserService();
	private ReimbursementService rs = ReimbursementService.getReimburesmentService();
	private Tools tools = Tools.getTools();

	private AdminController() {
	}

	public static AdminController getAdminController() {
		return ac;
	}

	public void handlePut(HttpServletRequest request, HttpServletResponse response) {
		if (t.validateToken(request)) {
			String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user/".length());
			System.out.println("actualURL in handlePut" + actualURL);
			if (actualURL.equals("/putUser")) {
				log.debug("attempting to put User");
				String json;
				try {
					json = request.getReader().lines().reduce((c, a) -> c + a).get();
					if (us.putUser(json)) {
						response.setStatus(200);
					} else {
						response.setStatus(401);
					}
				} catch (IOException e) {
					log.warn("Failed to parse json: " + e);
				}
			} else if (actualURL.equals("/putReim")) {
				String json;
				try {
					json = request.getReader().lines().reduce((c, a) -> c + a).get();
					if (rs.putReimbursement(json, (User)request.getSession().getAttribute("user"))) {
						response.setStatus(200);
					} else {
						response.setStatus(401);
					}
				} catch (IOException e) {
					log.warn("Failed to parse json: " + e);
				}
			}
		} else {
			try {
				response.sendError(403);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		if (t.validateToken(request)) {
			String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user/".length());
			System.out.println("actualURL in handleGet " + actualURL);
			if (actualURL.equals("/all")) {
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

			} else if (actualURL.equals("/reim")) {
				log.debug("attempting to get all reims");
				List<Reimbursement> reims = rs.getAllReimbursements();
				for(Reimbursement reim : reims)
				{
					reim.setReceipt(null);
				}
				List<Object> objects = new ArrayList<>();
				objects.addAll(reims);
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
			}

			else {
				try {
					request.getRequestDispatcher("/static/AdminMainPage.html").forward(request, response);
				} catch (ServletException | IOException e) {
					log.debug("Issues loading: " + e);
				}
			}
		} else {
			try {
				response.sendError(403);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void handleDelete(HttpServletRequest request, HttpServletResponse response) {
		log.info("In Admin Delete");
		if (t.validateToken(request)) {
			String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user/".length());
			System.out.println("actualURL in handleDelete " + actualURL);
			if (actualURL.equals("/deleteUser")) {
				log.debug("attempting to Delete User");
				String json;
				try {
					json = request.getReader().lines().reduce((c, a) -> c + a).get();
					if (us.deleteUser(json)) {
						log.trace("userDeleted");
						response.setStatus(200);
					} else {
						response.setStatus(401);
					}
				} catch (IOException e) {
					log.warn("Failed to parse json: " + e);
				}
			} else if (actualURL.equals("/deleteReim")) {
				log.trace("attempting to delete Reim in Admin");
				String json;
				try {
					json = request.getReader().lines().reduce((c, a) -> c + a).get();
					if (rs.deleteReimbursement(json)) {
						response.setStatus(200);
					} else {
						response.setStatus(401);
					}
				} catch (IOException e) {
					log.warn("Failed to parse json: " + e);
				}
			}

		} else {
			try {
				response.sendError(403);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
