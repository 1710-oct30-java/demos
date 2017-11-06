package com.revature.banksoftware;

import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 4761305079590286201L;
	
	private String type;
	private double balance;
	private boolean approved;
	
	public Account(String type, double balance) {
		
		super();
		this.type = type;
		this.balance = balance;
		this.approved = false;
	}

	public Account(String type, double balance, boolean approved) {
		
		super();
		this.type = type;
		this.balance = balance;
		this.approved = approved;
	}
	

	public void deposit(double amount) {
		
		balance += amount;
	}
	
	public boolean withdraw(double amount) {
		
		if(balance < amount)
			return false;
		else
		{
			balance -= amount;
			return true;
		}
	}
	
	public void setBalance(double balance) {
		
		this.balance = balance;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	
	public String getType() {
		
		return type;
	}
	
	public void setType(String type) {
		
		this.type = type;
		approved = false;
	}
	
	public void setType(String type, boolean approved) {
		
		this.type = type;
		this.approved = approved;
	}
	
	
	public boolean getApproved() {
		
		return approved;
	}
	
	public void approve() {
		
		approved = true;
	}
	
}
