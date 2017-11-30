package com.revature.beans;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	private int reimbID;
	private int amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Blob receipt;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public Reimbursement() {
		
	}
	public Reimbursement(int id, int amt, Timestamp sub, Timestamp res, String des, Blob rec, int auth, int reso, int status, int type ) {
		reimbID = id;
		amount = amt;
		submitted = sub;
		resolved = res;
		description = des;
		receipt = rec;
		author = auth;
		resolver = reso;
		statusID = status;
		typeID = type;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	

}
