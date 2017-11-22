package front.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import controllers.UserController;

public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
    private UserController uc = new UserController();
	
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(URL);
		
		if (URL.startsWith("/static")){
			super.doGet(request, response);
			return;
		}
		
		if (URL.startsWith("/user")) {
			uc.delegateGet(request, response);
		}
		
		if ("/home".equals(URL)) {	

			request.getRequestDispatcher("/static/index.html").forward(request, response);
//			redirecting
//			response.sendRedirect(request.getContextPath() + "/static/index.html");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = request.getRequestURI().substring(request.getContextPath().length());
		
		if (URL.startsWith("/reimbursements")) {
			
		}
		if (URL.startsWith("/users/")) {
			try {
				uc.processPost(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
