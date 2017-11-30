package com.revature.services;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoJDBC;

public class ReimbursementService {
	private ReimbursementDao rd = new ReimbursementDaoJDBC();
	
	public List<Reimbursement> viewPastReimbursements(int id){
		return rd.getPastReimbursements(id);
	}
	
	public List<Reimbursement> viewAllReimbursements(){
		return rd.getAllReimbursements();
	}
	
	public boolean approve(int id, int resolverID) {
		return rd.approveReimbursement(id, resolverID);
	}
	
	public void deny(int id, int resolverID) {
		rd.denyReimbursement(id, resolverID);
	}
	
	public void addReimbursement(int amount, String descript, Blob receipt, int auth, int status, int type) {
		rd.addNewReimbursement(amount, descript, receipt, auth, status, type);
	}
}
