package com.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.controller.LoginController;
import com.controller.ReimbController;
import com.services.ReimbService;

public class DispatchServlet extends DefaultServlet
{
	Logger log = Logger.getRootLogger();
	ReimbService rs = new ReimbService();
	LoginController lc = new LoginController();
	ReimbController rc = new ReimbController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		log.debug(actualURL);
		if (actualURL.startsWith("/static"))
		{
			super.doGet(request, response);
			return;
		}
		else
		{
			switch (actualURL)
			{
				case "/":
					// forward, the clients url will not change
					request.getRequestDispatcher("/static/index.html").forward(request, response);
					break;
				case "/login":
					lc.delegateGet(response, request);
					break;
				case "/reimb":
					rc.delegateGet(response, request);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());

		switch (actualURL)
		{
			case "/login":
				lc.delegatePost(response, request);
				break;
			case "/reimb":
				rc.delegatePost(response, request);
				break;
		}
		// TODO Auto-generated method stub
		// super.doPost(request, response);
		// ObjectMapper om = new ObjectMapper();
		// ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		// String json = ow.writeValueAsString(rs.getAllReimb());
		// PrintWriter out = response.getWriter();
		// out.print(json);
		// out.close();
	}
}
