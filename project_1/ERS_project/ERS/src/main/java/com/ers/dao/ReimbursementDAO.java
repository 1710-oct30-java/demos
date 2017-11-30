package com.ers.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;

public interface ReimbursementDAO {
	
	/**
	 * Returns list of reimbursements of the user.
	 * @param User object
	 * @return list of reimbursements
	 */
	public List<Reimbursement> getReimbursementsByUser(User user);
	
	
	/**
	 * Returns a reimbursement based on the input ID.
	 * @param r_id
	 * @return Reimbursement object based on ID
	 */
	public Reimbursement getReimbursementById(int r_id);
	
	
	/**
	 * Returns list of reimbursements by status.
	 * Reimbursement Status 1) Pending 2) Approved 3) Denied
	 * @param reimbursement status id
	 * @return list of reimbursements
	 */
	public List<Reimbursement> getReimbursementsByStatusID(int r_status_id);
	
	
	/**
	 * Adds a reimbursement to the database
	 * @param User object
	 */
	public void addReimbursement(User user, Reimbursement reimb);
	
	
	/**
	 * Update reimbursement information upon approval or denial.
	 * Uses stored procedure --> 
	 * 		updateReimbursement(rr_id, rr_resolved, rr_resolver, rr_status_id
	 * @param reimb
	 */
	public void updateReimbursement(User user, Reimbursement reimb, int r_status_id);
	
	
	/**
	 * Returns list of all reimbursements.
	 * @return List<Reimbursement>
	 */
	public List<Reimbursement> getReimbursementsAllReimbursements();

	
	/**
	 * Returns list of all reimbursements by given user ID.
	 * @param r_author
	 * @return List
	 */
	public List<Reimbursement> getReimbursementsByUserID(int r_author);
	
	
	/**
	 * Returns last reimbursement added to the database
	 * @return Reimbursement
	 */
	public int getIdOfLastReimbusement();
}
