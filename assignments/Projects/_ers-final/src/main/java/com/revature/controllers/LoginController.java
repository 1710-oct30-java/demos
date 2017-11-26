package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.LoginCredentials;
import com.revature.beans.User;
import com.revature.exceptions.ErsHttpException;
import com.revature.services.Authenticator;

public class LoginController implements DelegateController {
	private Logger log = Logger.getRootLogger();

	@Override
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("In LoginController delegateGet");
		User currentUser = (User) request.getSession().getAttribute("user");
		String uri = request.getRequestURI().toLowerCase();
		String destination = uri.substring(request.getContextPath().length() + 1, uri.length());

		if (destination.equals("login")) {
			getLogin(request, response);
		}

		else if (destination.equals("logout")) {
			if (currentUser == null) {
				log.info("No user logged in.");
			} else {
				log.info("Logging out " + currentUser.getUserName() + "...");
				request.getSession().setAttribute("user", null);
			}
			response.sendRedirect("./home");
		}
	}

	private void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User currentUser = (User) request.getSession().getAttribute("user");

		log.debug("currentUser: " + currentUser);
		if (currentUser != null) {
			try {
				ObjectMapper map = new ObjectMapper();
				ObjectWriter writer = map.writer().withDefaultPrettyPrinter();
				String json = writer.writeValueAsString(currentUser);
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			log.info("Sending empty response to client.");
			String json = JSONStringify(null);
			response.getWriter().write(json);
		}
	}

	@Override
	public void delegatePost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		User currentUser = (User) request.getSession().getAttribute("user");

		if (currentUser == null) {
			log.info("New user attempting to login on session " + request.getSession().getId() + "...");

			String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
			LoginCredentials login = JSONParse(json, LoginCredentials.class);

			currentUser = handleLogin(login);
			request.getSession().setAttribute("user", currentUser);

			if (currentUser == null) {
				response.setStatus(401);
			}

			response.getWriter().write(JSONStringify(currentUser));
			log.info("User login attempt complete. Returning to Front Controller.");
		}

		else {
			log.info("Current logged in user: " + currentUser.toString());
		}
	}

	private User handleLogin(LoginCredentials login) throws ErsHttpException {
		log.info("Creds received: " + login);

		String username = login.getUsername();
		String password = login.getPassword();
		Authenticator auth = new Authenticator();
		User currentUser = auth.attemptLogin(username, password);

		if (currentUser != null) {
			log.info("Login successful, acquiring user data for " + username + "...");
			log.info("User " + currentUser.getFirstName() + " " + currentUser.getLastName() + " retrieved.");
			log.info("Saving user to current session.");
			return currentUser;
		} else {
			log.info("Login failed. Setting session user to null.");
			return null;
		}
	}

	private String JSONStringify(Object obj) {
		try {
			ObjectMapper map = new ObjectMapper();
			ObjectWriter writer = map.writer().withDefaultPrettyPrinter();
			String json = writer.writeValueAsString(obj);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private <T> T JSONParse(String json, Class dest) {
		log.trace("json received: " + json);
		T obj = null;
		ObjectMapper map = new ObjectMapper();
		try {
			obj = (T) map.readValue(json, dest);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return obj;
	}
}
