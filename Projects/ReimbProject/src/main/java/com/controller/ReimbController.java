package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ReimbController
{
	Logger log = Logger.getRootLogger();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		log.debug("Get in ReimbCtrler");
		request.getRequestDispatcher("/static/reimb.html").forward(request, response);
	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		log.debug("Post in ReimbCtrler");
	}

}
