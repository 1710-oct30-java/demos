package com.revature.servlets;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controllers.AdminController;
import com.revature.controllers.FileController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;
import com.revature.controllers.NewController;
import com.revature.controllers.SubmitController;
import com.revature.controllers.TypeController;
import com.revature.controllers.UserController;

@MultipartConfig
public class DispatcherServlet extends DefaultServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getRootLogger();
	private LoginController lc = LoginController.getLoginController();
	private UserController uc = UserController.getUserController();
	private AdminController ac = AdminController.getAdminController();
	private ManagerController mc = ManagerController.getManagerController();
	private SubmitController sc = SubmitController.getSubmitController();
	private NewController nc = NewController.getNewController();
	private TypeController tc = TypeController.getTypeController();
	private FileController fc = FileController.getFileController();

	@Override
	public void init() throws ServletException {
		if (!uc.checkAdmin()) {
			log.info("Creating Admin");
			uc.createAdmin();
		}
		super.init();
	}

	@Override
	protected void doPut(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("Put");
		String actualURL = arg0.getRequestURI().substring(arg0.getContextPath().length());
		String[] UrlParsed = actualURL.split("/");
		Stream.of(UrlParsed).forEach(i -> log.trace(i));
		try {
			log.trace("PUT Switch statement on: " + UrlParsed[1]);
			switch (UrlParsed[1]) {
			case ("login"):
				lc.handlePost(arg0, arg1);
				break;
			case ("admin"):
				ac.handlePut(arg0, arg1);
				break;
			case ("submit"):
				sc.handlePost(arg0, arg1);
				break;
			case ("new"):
				nc.handlePost(arg0, arg1);
				break;
			case ("manager"):
				mc.handlePut(arg0, arg1);
				break;
			default:
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			log.warn(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Post");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		String[] UrlParsed = actualURL.split("/");
		Stream.of(UrlParsed).forEach(i -> log.trace(i));
		try {
			log.trace("Switch statement on: " + UrlParsed[1]);
			switch (UrlParsed[1]) {
			case ("login"):
				lc.handlePost(request, response);
				break;
			case ("submit"):
				sc.handlePost(request, response);
				break;
			case ("new"):
				nc.handlePost(request, response);
				break;
			case ("logout"):
				lc.handleLogOutPost(request, response);
				break;
			case ("file"):
				fc.handlePost(request, response);
				break;
			default:
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			log.warn(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Get");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		String[] UrlParsed = actualURL.split("/");
		Stream.of(UrlParsed).forEach(i -> log.trace(i));
		log.trace(actualURL);
		log.trace("Switch statement on: " + UrlParsed[1]);
		switch (UrlParsed[1]) {
		case ("login"):
			lc.handleGet(request, response);
			break;
		case ("user"):
			uc.handleGet(request, response);
			break;
		case ("admin"):
			ac.handleGet(request, response);
			break;
		case ("manager"):
			mc.handleGet(request, response);
			break;
		case ("new"):
			nc.handleGet(request, response);
			break;
		case ("types"):
			tc.handleGet(request, response);
			break;
		case ("file"):
			fc.handleGet(request, response);
			break;
		default:
			super.doGet(request, response);
			break;
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Delete");
		String actualURL = req.getRequestURI().substring(req.getContextPath().length());
		String[] UrlParsed = actualURL.split("/");
		Stream.of(UrlParsed).forEach(i -> log.trace(i));
		log.trace(actualURL);
		log.trace("Switch statement on: " + UrlParsed[1]);
		switch (UrlParsed[1]) {
		case ("admin"):
			ac.handleDelete(req, resp);
			break;
		default:
			super.doDelete(req, resp);
			break;
		}
	}
}
