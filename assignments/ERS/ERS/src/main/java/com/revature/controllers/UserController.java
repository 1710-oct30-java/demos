package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserController {
	private UserService us = new UserService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = null;
		// read the body of the request into a single string
		// json = request.getReader() // get buffered reader for reading the request
		// body
		// .lines() // stream the reader
		// .reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
		// .get(); // get that single string
		// log.trace("json received: " + json);
		// convert the body of the request into an actual object
		ObjectMapper om = new ObjectMapper();
		User u = new User();

		List<User> allUsers = us.findAll();

		// request.getSession().setAttribute("user", actualUser);
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		json = ow.writeValueAsString(allUsers);

		// write json to the body of the response
		PrintWriter writer = response.getWriter();
		writer.write(json);

	}

}
