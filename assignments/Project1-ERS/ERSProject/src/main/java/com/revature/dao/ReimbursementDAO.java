package com.revature.dao;

/*
 * Interface: ReimbursementDAO
 * Author: Kyle Settles
 * Description: Interface used to define the methods for handling reimbursements in database for easy transition between databases
 * 		Implemented by the ReimbursementDAOJdbc
 */

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	// gets reimbursement from database by ID
	Reimbursement getReimbursementByID(int id);
	
	// gets all reimbursements from database
	List<Reimbursement> retrieveAllReimbursements();
	
	// gets all reimbursements from database by a specific user
	List<Reimbursement> getReimbursementsByUser(int id);
	
	// adds a new reimbursement to the database
	int addReimbursement(Reimbursement rb);
	
	// approve or deny a specific reimbursement by ID and sets resolver
	boolean approveDeny(String choice, int id, int resolverId);
}