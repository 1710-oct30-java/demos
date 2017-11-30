package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.beans.User;
import com.revature.daos.UserDaoJdbc;

public class ErsServlet extends DefaultServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ErsServlet init");
		super.init(config);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("ErsServlet service");
		super.service(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("ErsServlet doGet");
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post");
		super.doPost(request, response);

		BufferedReader reader = request.getReader();

		String username = reader.readLine();
		String password = reader.readLine();
		User newUser = new User(1, username, password, "first", "last", "test@test.com", 1);

		UserDaoJdbc jdbc = new UserDaoJdbc();
		jdbc.save(newUser);
	}
}