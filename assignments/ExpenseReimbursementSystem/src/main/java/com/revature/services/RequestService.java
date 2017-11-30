package com.revature.services;

import java.util.List;

import com.revature.beans.Request;
import com.revature.dao.RequestDAO;
import com.revature.dao.RequestDAOJDBC;

public class RequestService {

	private RequestDAO rd = new RequestDAOJDBC();

	public List<Request> getAllRequests() {
		// have checks to see if the user requesting this is an admin

		return rd.findAll();
	}

	public List<Request> getPendingRequests() {

		return rd.findPending();
	}

	public List<Request> getApprovedRequests() {

		return rd.findApproved();
	}

	public List<Request> getDeniedRequests() {

		return rd.findDenied();
	}

	public Request appRequest(int reimbId, int author) {
		return rd.approveRequest(reimbId, author);
	}

	public Request denRequest(int reimbId, int author) {
		return rd.denyRequest(reimbId, author);
	}

	public Request newRequest(Request r, int author) {
		return rd.newRequest(r, author);
	}

	public List<Request> getUserRequests(int author) {
		return rd.userAll(author);
	}

	public List<Request> getUserPendingRequests(int author) {
		return rd.userPending(author);
	}

}
