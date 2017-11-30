package com.revature.dao;

import java.util.List;

import com.revature.beans.Request;

public interface RequestDAO {

	List<Request> findAll();

	List<Request> findPending();

	Request approveRequest(int reimbId, int author);

	List<Request> findDenied();

	List<Request> findApproved();

	Request denyRequest(int reimbId, int approvedBy);

	Request newRequest(Request r, int author);

	List<Request> userAll(int author);

	List<Request> userPending(int author);

}
