package com.revature.daos;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDao {
	List<Reimbursement> getPastReimbursements(int id);
	
	List<Reimbursement> getAllReimbursements();
	
	boolean approveReimbursement(int id, int resolverID);
	
	void denyReimbursement(int id, int resolverID);
	
	void addNewReimbursement(int amount, String descript, Blob receipt, int auth, int status, int type);
}
