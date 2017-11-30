package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Simple;
import com.revature.dao.SimpleDAOs;
import com.revature.dao.SimpleDAOsjdbc;

public class SimpleService {
	private static SimpleService rts = new SimpleService();
	private SimpleService () {}
	Logger log = Logger.getRootLogger();
	private static SimpleDAOs rtdao = new SimpleDAOsjdbc("reimbursement_type", "type_id", "type");
	private static SimpleDAOs rsdao = new SimpleDAOsjdbc("reimbursement_status", "status_id", "status");
	private static SimpleDAOs urdao = new SimpleDAOsjdbc("user_roles", "user_role_id", "user_role");
	public static SimpleService getReimbursementTypeService()
	{
		return rts;
	}

	public List<Simple> getReimbursementTypes() {
		log.trace("getting all reimbursementTypes");
		return rtdao.getAll();
	}
	
	public List<Simple> getReimbursementStatuses(){
		log.trace("getting all reimbursementStatuses");
		return rsdao.getAll();
	}

	public List<Simple> getUserRoles() {
		log.trace("getting all UserRoles");
		return urdao.getAll();
	}
}
