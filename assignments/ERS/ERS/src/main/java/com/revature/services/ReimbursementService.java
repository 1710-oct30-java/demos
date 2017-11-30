package com.revature.services;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoJDBC;

public class ReimbursementService {
	private ReimbursementDao rd = new ReimbursementDaoJDBC();

	public List<Reimbursement> findAll() {
		// Insert admin/permission checks here.
		return rd.getAllReimbursements();
	}

	public void addReimbursement(Reimbursement reimb) {
		rd.addReimbursement(reimb);

	}

	public void updateReimbursement(Reimbursement reimb) {
		rd.updReimbursement(reimb);
	}

	// public User getUserById(int id) {
	// return ud.getUserById(id);
	// }
}
