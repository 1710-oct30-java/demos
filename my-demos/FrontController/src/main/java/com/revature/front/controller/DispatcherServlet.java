package com.revature.front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.controllers.FlashCardController;
import com.revature.controllers.UserController;
import com.revature.exceptions.InvalidCredentialException;
import com.revature.exceptions.UrlNotRecognizedException;
import com.revature.services.UserService;

public class DispatcherServlet extends DefaultServlet {
	private UserController uc = new UserController();
	private FlashCardController fc = new FlashCardController();
	private UserService us = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		} else if ("/home".equals(actualURL)) {
			// forward, the clients url will not change
			request.getRequestDispatcher("/static/index.html").forward(request, response);
			// redirect, the clients url will change
			// response.sendRedirect(request.getContextPath() + "/static/index.html");

		} else if (actualURL.startsWith("/user")) {
			uc.delegateGet(request, response);

		} else if (actualURL.startsWith("/flashcard")) {
			fc.delegateGet(request, response);

		} else {
			throw new UrlNotRecognizedException();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			System.out.println("post request made with url" + request.getRequestURI());
			String actualURL = request.getRequestURI().substring(request.getContextPath().length());

			if (actualURL.startsWith("/flashcard")) {
				fc.delegatePost(request, response);
			} else if ("/login".equals(actualURL)) {
				System.out.println("login");
				us.login();

			} else {
				throw new UrlNotRecognizedException();
			}

		} catch (InvalidCredentialException e) {
			response.setStatus(e.getStatusCode());
		}

	}

}
