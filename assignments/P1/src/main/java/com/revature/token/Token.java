package com.revature.token;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.beans.User;

public class Token {
	private static Token t = new Token();

	private Token() {
	}

	private static Logger log = Logger.getRootLogger();

	public static Token getToken() {
		return t;
	}

	public boolean validateToken(HttpServletRequest request) {
		log.debug("Validating Token");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		String[] urlParsed = actualURL.split("/");
		log.trace("Validation URL = " + actualURL);
		log.trace("Validation request session = " + request.getSession().getAttribute("user"));
		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return false;
		switch (urlParsed[1]) {
		case ("admin"):
			return user.getRoleId() == 3;
		case ("user"):
			return user.getRoleId() == 1;
		case ("manager"):
			return user.getRoleId() == 2;
		case ("submit"):
			return user.getRoleId() == 2 || user.getRoleId() == 1;
		case ("file"):
			return user.getRoleId() == 2 || user.getRoleId() == 3;
		default:
			return false;

		}
	}

}
