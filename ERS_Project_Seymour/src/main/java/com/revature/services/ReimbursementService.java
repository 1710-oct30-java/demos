package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDAO rd = new ReimbursementDAOImpl();
	
	public List<Reimbursement> getAllReimbursements() {
		return rd.getAllReimbs();
	}

	public List<Reimbursement> getReimbsById(int uid) {
		return rd.getReimbsById(uid);
	}

	public Boolean addReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return rd.addReimbursement(r);
	}

	public Boolean approveRequests(int uid, List<Integer> reimbIdsToBeApproved) {
		// TODO Auto-generated method stub
		return rd.approveRequests(uid, reimbIdsToBeApproved);
	}

	public Boolean denyRequests(int uid, List<Integer> reimbIdsToBeDenied) {
		// TODO Auto-generated method stub
		return rd.denyRequests(uid, reimbIdsToBeDenied);
	}
}
