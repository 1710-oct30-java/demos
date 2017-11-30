package com.revature.dao;

import java.util.Date;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDao {

	List<Reimbursement> findReimbursement(int userId);

	List<Reimbursement> allReimbursements();

	int newReimbursement(Reimbursement newReimb);

	int approved(int reimbursement);

	int denied(int reimbursement);
	
}
