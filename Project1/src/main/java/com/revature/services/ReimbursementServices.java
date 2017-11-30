package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.Users;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOJdbc;


public class ReimbursementServices {

	private ReimbursementDAO reimbDAO = new ReimbursementDAOJdbc();
	private Logger log = Logger.getRootLogger();

	public List<Reimbursement> getAllReimbursements() {
		// have checks to see if the user requesting this is an admin
		return reimbDAO.findAll();
	}
	
	public List<Reimbursement> getReimbursementById(int id)
	{
		return reimbDAO.findById(id);
	}
	
	public List<Reimbursement> getPendingReimbursements() {
		return reimbDAO.findPending();
	}
	
	public List<Reimbursement> getUserPendingTickets(Users u) {
		return reimbDAO.findUserPending(u);
	}
	
	public List<Reimbursement> getPastTickets() {
		return reimbDAO.findAllPastTickets();
	}
	
	public List<Reimbursement> getUserPastTickets(Users u) {
		return reimbDAO.findUserPastTickets(u);
	}
	public List<Reimbursement> getAllUserReimbursements(Users u) {
		return reimbDAO.findUserReimbursements(u);
	}
	public void requestReimbursement(Users u, Reimbursement reimb){
		reimbDAO.addReimbursement(u, reimb.getReimb_amount(), reimb.getReimb_description(), reimb.getReimb_type_id());
	}
	
	public void resolve (Users u, Reimbursement reimb) {
		reimbDAO.approveOrDeny(u, reimb.getReimb_status_id(), reimb.getReimb_id());
	}
}
