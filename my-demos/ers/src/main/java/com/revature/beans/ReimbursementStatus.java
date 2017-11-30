package com.revature.beans;

public class ReimbursementStatus {
	private int statusID;
	private String status;
	
	public ReimbursementStatus(int x, String s) {
		statusID = x;
		status = s;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
