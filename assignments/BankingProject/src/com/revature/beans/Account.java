package com.revature.beans;

/*
 * Class: Account
 * Creator: Kyle Settles
 * Description: Class used to represent the Account object for use in the 
 * banking application. Has a type, determined by the user.
 */

import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 7344758684475211551L;
	private String type;
	private Double balance;
	
	public Account() {
		super();
	}

	public Account(String type) {
		super();
		this.type = type;
		balance = 0.0;
	}
	
	public Account(String type, Double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Account other = (Account) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}