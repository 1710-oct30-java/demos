package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.pojo.Number;
import com.revature.service.ReimbursementService;
import com.revature.token.Token;
import com.revature.util.Tools;

public class SubmitController {
	private static SubmitController sc = new SubmitController();
	private Logger log = Logger.getRootLogger();
	private static Token t = Token.getToken();
	private static Tools tools = Tools.getTools();
	private static ReimbursementService rs = ReimbursementService.getReimburesmentService();
	private SubmitController() {}

	public static SubmitController getSubmitController() {
		return sc;
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		log.info("In SubmitController Post");
		if (t.validateToken(request)) {
			try {
				String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
				log.trace("json received = " + json);
				int id = rs.newReimbursement(json,((User) request.getSession().getAttribute("user")).getId());
				log.trace(id);
				Number num = new Number();
				num.number = id;
				tools.loadResponseSingle(response, num);
				log.trace("sending: " + id + " in num");
			} catch (IOException e) {
				log.warn("error reading json " + e);
			}
		} else {
			try {
				response.sendError(403);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
}
