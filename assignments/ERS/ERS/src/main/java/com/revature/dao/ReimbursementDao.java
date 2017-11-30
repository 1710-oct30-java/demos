package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDao {
	List<Reimbursement> getUserReimbursements(int userId);
	List<Reimbursement> getAllReimbursements();
	void addReimbursement(Reimbursement reimb);
	void updReimbursement(Reimbursement reimb);
}
