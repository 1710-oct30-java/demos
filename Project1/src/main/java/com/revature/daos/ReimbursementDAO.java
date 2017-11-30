package com.revature.daos;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.Users;

public interface ReimbursementDAO {
		
		/**
		 * Method to find all reimbursements in the database
		 * @return
		 */
		List<Reimbursement> findAll();
		
		/**
		 * Method to find a reimbursement by its ID
		 * @param id
		 * @return
		 */
		List<Reimbursement> findById(int id);
		
		/**
		 * Method to find pending reimbursements
		 * @return
		 */
		List<Reimbursement> findPending(); 
		
		/**
		 * Method to find a user's pending reimbursements
		 * @param u
		 * @return
		 */
		List<Reimbursement> findUserPending(Users u);
		
		/**
		 * Method to find resolved reimbursements
		 * @return
		 */
		List<Reimbursement> findAllPastTickets(); 
		
		/**
		 * Method to find a user's resolved reimbursements
		 * @param u
		 * @return
		 */
		List<Reimbursement> findUserPastTickets(Users u); 
		/**
		 * Method to add a reimbursement
		 * @param u, amount, description, typeId
		 */
		void addReimbursement(Users u, int amount, String description, int typeId);
		/**
		 * Method to find a user's reimbursements
		 * @param u
		 * @return
		 */
		List<Reimbursement> findUserReimbursements(Users u);
		/**
		 * Method to approve or deny a reimbursement request
		 * @param u, statusId, id
		 */
		void approveOrDeny (Users u, int statusId, int id);
}
