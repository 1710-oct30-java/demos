package com.revature.services;

import java.util.ArrayList;
import java.util.List;

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

	public List<Reimbursement> getReimbursements(int userId) {
		List<Reimbursement> rl = new ArrayList<>();
		rl = rd.findReimbursement(userId);
		return rl;

	}

	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> rl = new ArrayList<>();
		rl = rd.allReimbursements();
		return rl;

	}

	public void approveReimbursement(int reimbursements) {
		rd.approved(reimbursements);

	}

	public void denyReimbursement(int reimbursements) {
		rd.denied(reimbursements);
	}
}
