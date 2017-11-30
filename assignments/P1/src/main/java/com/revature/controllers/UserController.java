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

public class UserController {
	private static UserController uc = new UserController();
	private static Token t = Token.getToken();
	private static Logger log = Logger.getRootLogger();
	private static ReimbursementService rs = ReimbursementService.getReimburesmentService();
	private static Tools tools = Tools.getTools();
	private static UserService us = UserService.getUserService();

	private UserController() {
		super();
	}

	public static UserController getUserController() {
		return uc;
	}

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		log.trace("In GET in UserController");
		if (t.validateToken(request)) {
			String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/user".length());
			if (actualURL.equals("")) {
				try {
					request.getRequestDispatcher("static/EmployeeMainPage.html").forward(request, response);
				} catch (ServletException | IOException e) {
					log.warn("issue forwarding: " + e);
				}
			} else if (actualURL.equals("/me")) {
				log.trace("sending me");
				User u = (User) request.getSession().getAttribute("user");
				tools.loadResponseSingle(response, u);
			} else {
				int num = -1;
				User u = (User) request.getSession().getAttribute("user");
				num = u.getId();
				if (num > 0) {
					List<Reimbursement> reim = rs.getReimbursement(num);
					for(Reimbursement r : reim)
					{
						r.setReceipt(null);
					}
					List<Object> objects = new ArrayList<>();
					objects.addAll(reim);
					if (tools.loadResponseList(response, objects)) {
						log.debug("Successfully loaded all reimbursements of ID: " + num);
					}

				} else {

				}
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

	public boolean checkAdmin() {
		List<User> u = us.getUsers();
		return u.stream().anyMatch(i -> i.getUsername().equals("Admin"));
	}

	public void createAdmin() {
		User u = new User(1, "Admin", "password", "Admin", "Admin", "Admin@Admin.com", 3, "N");
		us.postUserViaUser(u);

	}
}