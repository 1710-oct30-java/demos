package com.revature.daos;

import java.util.List;

import com.revature.beans.ReimbRequest;

public interface RequestDAO {
	
	/**
	 * @param id
	 * @return Returns a list of Reimbursement Requests from the given User ID.
	 */
	public List<ReimbRequest> getRequestsByUserId(int id);
	
	/**
	 * @param status code
	 * @return Returns a list of Reimbursement Requests from the given status code.
	 */
	public List<ReimbRequest> getRequestsByStatus(int statusCode);
	
	/**
	 * @param req
	 * @return Returns whether the creation of the request was successful.
	 */
	public int createRequest(ReimbRequest req);
}
