package com.revature.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	private int reimbId;
	private double amount;
	private Timestamp timeSubmitted;
	private Timestamp timeResolved;
	private String description;
	private Blob receipt;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;
	public Reimbursement() {
		super();
	}
	public Reimbursement(int reimbId, double amount, Timestamp timeSubmitted, Timestamp timeResolved,
			String description, Blob receipt, int author, int resolver, int statusId, int typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTimeSubmitted() {
		return timeSubmitted;
	}
	public void setTimeSubmitted(Timestamp timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	public Timestamp getTimeResolved() {
		return timeResolved;
	}
	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + author;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + reimbId;
		result = prime * result + resolver;
		result = prime * result + statusId;
		result = prime * result + ((timeResolved == null) ? 0 : timeResolved.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
		result = prime * result + typeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author != other.author)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (resolver != other.resolver)
			return false;
		if (statusId != other.statusId)
			return false;
		if (timeResolved == null) {
			if (other.timeResolved != null)
				return false;
		} else if (!timeResolved.equals(other.timeResolved))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", description=" + description + ", receipt=" + receipt
				+ ", author=" + author + ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId
				+ "]";
	}
	
	
}
