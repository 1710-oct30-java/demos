package com.revature.services;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOJdbc;

public class ReimbursementService {
	
	private ReimbursementDAO r = new ReimbursementDAOJdbc();
	
	/*
	 * Method to get all of the reimbursements
	 */
	public List<Reimbursement> getAllReimbursements(){
		return r.viewAllReimbursements();
	}
	
	/*
	 * Method to get the reimbursements of the specified user by the user's id
	 */
	public List<Reimbursement> getReimbursementsById(User u){
		return r.reimbursementsByUserId(u.getUsersId());
	}
	
	/*
	 * Method to create a new reimbursement user must be signed in
	 * to create a new reimbursement
	 */
	public void requestReimbursement(Reimbursement reimb) {
		if(reimb != null) {
			r.addReimbursement(reimb);
		}
	}

	public List<Reimbursement> listToApproveOrDeny(User u) {
		return r.approveOrDeny(u.getUsersId());		
	}
	
	//update database reimbursement
	public void updateReimbursement(Reimbursement r2, User u) {
		r2.setReimbStatusId(new ReimbursementStatus(r2.getReimbStatusId().getStatusId()));
		r.updateReimbursement(r2.getReimbId(), r2.getReimbStatusId().getStatusId(), u.getUsersId());
	}

}
