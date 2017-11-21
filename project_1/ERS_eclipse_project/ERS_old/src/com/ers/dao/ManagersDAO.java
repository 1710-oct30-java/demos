package com.ers.dao;

import com.ers.beans.Reimbursement;

public interface ManagersDAO {
	
	/**
	 * Method used to view all pending requests.
	 */
	public void viewPendingRequests();
	
	/**
	 * Method used to view all approved requests.
	 */
	public void viewApprovedRequests();
	
	/**
	 * Method used to view all denied requests.
	 */
	public void viewDeniedRequests();
	
}
