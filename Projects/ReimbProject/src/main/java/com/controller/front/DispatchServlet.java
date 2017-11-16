package com.controller.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.controller.LoginController;

public class DispatchServlet extends DefaultServlet
{
	private LoginController lc = new LoginController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(actualURL);

		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		}

		if ("/".equals(actualURL)) {
			// forward, the clients url will not change
			lc.delegateGet(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request made with url" + request.getRequestURI());
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		lc.delegatePost(request, response);
//		if(actualURL.startsWith("/flashcard")) {
//			fc.delegatePost(request, response);
//		}

	}
}
