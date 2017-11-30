package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserDAO;
import com.revature.model.User;
import com.revature.utilities.ConnectionUtil;
import com.revature.utilities.DAOUtilities;

/**
 * Servlet implementation class ERSServlet
 */
@WebServlet("/ers")
public class ERSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO dao = ConnectionUtil.getUserDAO();
		List<User> users = new ArrayList<User>();
		users = dao.getAllUsers();
		
		for (User u : users) {
			System.out.println(u.toString());
		}
		
		request.getSession().setAttribute("users", users);
		request.getRequestDispatcher("ers.jsp").forward(request, response);;
	}
}
