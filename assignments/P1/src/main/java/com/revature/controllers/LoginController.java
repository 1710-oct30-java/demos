package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.util.Tools;

public class LoginController {
	private static LoginController lc = new LoginController();
	private static Logger log = Logger.getRootLogger();
	private static Tools tools = Tools.getTools();

	private LoginController() {
		super();
	}

	public static LoginController getLoginController() {
		return lc;
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("login controller handling POST");
		try {
			String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
			log.trace("json received = " + json);
			ObjectMapper om = new ObjectMapper();
			Credentials c = om.readValue(json, Credentials.class);
			log.trace("Object created = " + c);
			User actualUser = tools.validate(c);
			log.trace(actualUser);
			if (actualUser == null) {
				response.sendError(401);
			} else if (actualUser.getFlag().equals("Y")) {
				response.sendError(401);
			} else {
				switch (actualUser.getRoleId()) {
				case 1:
					log.trace("employee");
					request.getSession().setAttribute("user", actualUser);
					response.setStatus(210);
					break;
				case 2:
					log.trace("manager");
					request.getSession().setAttribute("user", actualUser);
					response.setStatus(211);
					break;
				case 3:
					log.trace("admin");
					request.getSession().setAttribute("user", actualUser);
					response.setStatus(212);
					break;
				default:
					response.sendError(401);
					break;
				}
			}
		} catch (IOException e) {
			log.warn("Issue in Handling post " + e);
		}
	}

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("login controller handling get");
		try {
			request.getRequestDispatcher("/static/Login.html").forward(request, response);
		} catch (ServletException | IOException e) {
			log.debug("we dun fuckd up " + e);
		}

	}

	public void handleLogOutPost(HttpServletRequest request, HttpServletResponse response) {
		log.trace("removing attribute user");
		request.getSession().removeAttribute("user");
		try {
			response.sendRedirect("login");
		} catch (IOException e) {
			log.warn("unable to redirect from logout: " + e);
		}
	}

}
