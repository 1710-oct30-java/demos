package com.revature.services;

import java.util.List;

import com.revature.beans.ErsReimbursement;
import com.revature.dao.ManagerViewJDBC;

public class ManagerService {
	private ManagerViewJDBC mv = new ManagerViewJDBC();

	public List<ErsReimbursement> getAllReimbursements() {
		return mv.getAllRequests();
	}

	public List<ErsReimbursement> getStatusById(int reimbStatusId) {
		return mv.getRequestsByStatusId(reimbStatusId);
	}

}
