package com.revature.beans;

import java.util.Date;

public class Reimbursement {
	private int reimbursementId;
	private double reimbursementAmount;
	private Date submittedDate;
	private Date resolvedDate;
	private String description;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public int getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	public Date getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	
	
}
