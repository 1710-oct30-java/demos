package com.revature.beans;

/*
 * Java class to represent the ers_reimbursement_status
 */
public class ReimbursementStatus {
	
	private int statusId;
	private String status;
	
	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public ReimbursementStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	
	//if you only know the status id
	public ReimbursementStatus(int statusId) {
		this.statusId = statusId;
		if(statusId == 1) {
			this.status = "Pending";
		}else if(statusId == 2 ) {
			this.status = "Approved";
		}else {
			this.status = "Denied";
		}
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", status=" + status + "]";
	}
	
	
	
	
}
