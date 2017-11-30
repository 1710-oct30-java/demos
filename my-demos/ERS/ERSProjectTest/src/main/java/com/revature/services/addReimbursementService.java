package com.revature.services;

import com.revature.beans.ErsReimbursement;
import com.revature.dao.AddReimbursementJDBC;;

public class addReimbursementService {
	private AddReimbursementJDBC addReimbursement = new AddReimbursementJDBC();

	public void addReimbursement(ErsReimbursement reimbursement) {
		addReimbursement.submitReimbReq(reimbursement);
	}

}
