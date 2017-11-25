package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoJdbc;

public class ReimbursementService {

	private Logger log = Logger.getRootLogger();
	private ReimbursementDao rd = new ReimbursementDaoJdbc();
	
	public void addReimbursement(Reimbursement reimb) {
		log.debug("Attempting to send reimbursement to DAO");
		rd.newReimbursement(reimb);
	}
}
