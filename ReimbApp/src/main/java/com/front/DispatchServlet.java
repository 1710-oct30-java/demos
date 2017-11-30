package com.front;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.controller.LoginController;
import com.controller.RegisterController;
import com.controller.ReimbController;
import com.controller.ReimbMController;
import com.services.ReimbService;

public class DispatchServlet extends DefaultServlet
{
	Logger log = Logger.getRootLogger();
	ReimbService rs = new ReimbService();
	LoginController lc = new LoginController();
	RegisterController regc = new RegisterController();
	ReimbController rc = new ReimbController();
	ReimbMController rmc = new ReimbMController();

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
				case "/login":
					request.getSession().setAttribute("user", null);
					request.getSession().invalidate();
					lc.delegateGet(response, request);
					break;
				case "/register":
					request.getSession().setAttribute("user", null);
					request.getSession().invalidate();
					regc.delegateGet(response, request);
					break;
				case "/reimb":
					rc.delegateGet(response, request);
					break;
				case "/reimbM":
					rmc.delegateGet(response, request);
					break;
				default:
					request.getSession().setAttribute("user", null);
					request.getSession().invalidate();
					lc.delegateGet(response, request);
					break;

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
			case "/register":
				try
				{
					regc.delegatePost(response, request);
				}
				catch (NoSuchAlgorithmException | NoSuchProviderException e)
				{
					e.printStackTrace();
				}
				break;
			case "/reimb":
				rc.delegatePost(response, request);
				break;
			case "/reimbM":
				rmc.delegatePost(response, request);
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
