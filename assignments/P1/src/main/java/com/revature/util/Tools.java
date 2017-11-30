package com.revature.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Credentials;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOjdbc;

public class Tools {
	private Logger log = Logger.getRootLogger();

	private static UsersDAO udao = UsersDAOjdbc.getUserDAOjdbc();
	private static Tools t = new Tools();

	private Tools() {
	}

	public static Tools getTools() {
		return t;
	}

	public User validate(Credentials c) {
		log.debug("finding User");
		return udao.exists(c.getUsername(), EncryptionHandler.Encrypt(c.getPassword()));

	}

	public boolean loadResponseSingle(HttpServletResponse response, Object obj) {
		log.trace("loading list");
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
			log.trace(json);
			response.getWriter().write(json);
		} catch (IOException e) {
			log.warn("Unable to convert reimbursements to json " + e);
			return false;
		}
		return true;
	}

	public boolean loadResponseList(HttpServletResponse response, List<Object> obj) {
		log.trace("loading list");
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
			log.trace(json);
			response.getWriter().write(json);
		} catch (IOException e) {
			log.warn("Unable to convert reimbursements to json " + e);
			return false;
		}
		return true;
	}

	public boolean checkUser(String json) {
		
		return false;
	}
	public List<Object> removeReceiptAndObjectify(List<Reimbursement> reims)
	{
		for (Reimbursement reim : reims) {
			reim.setReceipt(null);
		}
		List<Object> objects = new ArrayList<>();
		objects.addAll(reims);
		return objects;
	}
}
