package com.ers.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.dao.ReimbursementDAOJdbc;

public class ManagerService extends ReimbursementDAOJdbc {

	private Logger log = Logger.getLogger(ReimbursementDAOJdbc.class);
	
	/**
	 * Returns true if the user has a role of manager.
	 * @param user
	 * @return true if user is a manager
	 */
	public boolean isUserManager(User user) {
		
		log.debug("Checking if user is a manager...");
		
		if(user.getRole_id() == 1) {
			log.debug("User '" + user.getUsername() + "' is a manager!\n");
			return true;
		}
		
		log.debug("User is not a manager!\n");
		return false;
	}
	
	
	/**
	 * Check if manager can approve request; a manager cannot approve
	 * its own reimbursement request.
	 * @param user
	 * @param reimb
	 * @return true if manager is able to approve reimbursement request
	 */
	public boolean canApproveRequest(User user, Reimbursement reimb) {
		
		log.debug("Checking if user can update request...");
		
		for(Reimbursement rm:user.getReimbursements()) {
			if(rm.getR_id() == reimb.getR_id()) {
				log.debug("User cannot update request!\n");
				return false;
			}
		}
		
		log.debug("User can update reuest!\n");
		return true;
	}
	
	
	/**
	 * Update reimbursement information upon approval or denial.
	 * Uses stored procedure --> 
	 * 		updateReimbursement(rr_id, rr_resolved, rr_resolver, rr_status_id
	 * @param reimb
	 */
	public void updateReimbursement(User user, Reimbursement reimb, int r_status_id) {
		if(isUserManager(user)) {
			if(canApproveRequest(user, reimb)) {
				super.updateReimbursement(user, reimb, r_status_id);
			}
		}
	}
	
	
	/**
	 * Returns list of all reimbursements in the database.
	 * @return List<Reimbursement>
	 */
	public List<Reimbursement> getAllReimbursements() {
		return super.getReimbursementsAllReimbursements();
	}
	
	
	/**
	 * Returns list of all reimbursements by user ID.
	 */
	public List<Reimbursement> getReimbursementsByUserID(int r_author) {
		return super.getReimbursementsByUserID(r_author);
	}
}
