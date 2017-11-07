package com.revature.banking.accounts;

import java.io.Serializable;

public class Account implements Serializable{//Allow us to serialize the objects of the class
	
	private double balance;
	private int accID;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(double balance, int accID) {
		super();
		this.balance = balance;
		this.accID = accID;
	}
	@Override
	public String toString() {
		return "Account " +accID+": "+"[balance=" + balance + "]";
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance += balance;
	}
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}

	

}
