package com.revature.services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.ErsUser;
import com.revature.dao.ErsUserDao;
import com.revature.dao.ErsUserDaoJDBC;
import com.revature.exceptions.InvalidCredentialException;

public class ErsUserService {
	private ErsUserDao ud = new ErsUserDaoJDBC();
	private Logger log = Logger.getRootLogger();

	public ErsUser login(ErsUser u) throws InvalidCredentialException {
		// Turn the password into a hash
		String password = u.getPassword();
		java.security.MessageDigest md;
		try {
			md = java.security.MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			// Get complete hashed password in hex format
			password = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ud.findByUsernameAndPassword(u.getUsername(), password);
	}

	public List<ErsUser> getAllUsers() {
		return ud.findAll();
	}

	public ErsUser getUser(int userId) {
		return ud.findByUserId(userId);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws InvalidCredentialException {

		ErsUserService us = new ErsUserService();

		String json;
		try {
			log.debug("request to login received");

			// read the body of the request into a single string
			json = request.getReader() // get buffered reader for reading the request body
					.lines() // stream the reader
					.reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
					.get(); // get that single string
			// convert the body of the request into an actual object
			ObjectMapper om = new ObjectMapper();
			ErsUser u = om.readValue(json, ErsUser.class);

			ErsUser actualUser = us.login(u);
			if (actualUser == null) {
				response.setStatus(401);
			} else {
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				json = ow.writeValueAsString(actualUser);
				request.getSession().setAttribute("user", json);
				response.getWriter().write(json);
			}
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void create(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request to create new user received");

		try {
			String json;
			// read the body of the request into a single string
			json = request.getReader() // get buffered reader for reading the request body
					.lines() // stream the reader
					.reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
					.get(); // get that single string
			ObjectMapper om = new ObjectMapper();
			ErsUser user = om.readValue(json, ErsUser.class);
			ud.newUser(user);
		} catch (IOException | SQLException e) {
			response.setStatus(401);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
