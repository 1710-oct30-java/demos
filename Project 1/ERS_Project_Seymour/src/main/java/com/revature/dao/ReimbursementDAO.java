package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDAO {
	public List<Reimbursement> getAllReimbs();

	public List<Reimbursement> getReimbsById(int uid);

	public Boolean addReimbursement(Reimbursement r);

	public Boolean approveRequests(int uid, List<Integer> reimbIdsToBeApproved);

	public Boolean denyRequests(int uid, List<Integer> reimbIdsToBeDenied);
}
