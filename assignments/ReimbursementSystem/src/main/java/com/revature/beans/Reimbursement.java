package com.revature.beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/*
 * Java object that represents the ers_reimbursement table
 */
@JsonDeserialize
public class Reimbursement {
	
	private int reimbId;								//the reimbursement id
	private double reimbAmount;							//the amount of the reimbursement
	private String reimbSubmitted;						//date that the request is submitted
	private String reimbResolved;						//date that the request is resolved
	private String reimbDescription;					//description of the reimbursement
	private User reimbAuthor;							//the user that submits the request
	private User reimbResolver;							//the user that resolves the reimbursement
	private ReimbursementStatus reimbStatusId;			//reimbursement status id
	private ReimbursementType reimbTypeId;				//reimbursement type
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbId, double reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, User reimbAuthor, User reimbResolver, ReimbursementStatus reimbStatusId, ReimbursementType reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public User getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(User reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public User getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(User reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public ReimbursementStatus getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(ReimbursementStatus reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public ReimbursementType getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(ReimbursementType reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatusId="
				+ reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
	}
	
	
	
	
	
}
