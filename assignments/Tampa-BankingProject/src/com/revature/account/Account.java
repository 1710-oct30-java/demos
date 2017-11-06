package com.revature.account;

import java.io.Serializable;

import com.revature.banklauncher.BankLauncher;

public class Account implements Serializable{

	public String owner;
	public String type;
	public double balance;
	public int id;
	public static int counter = 0;

	public Account(String owner, String type, double balance, int num) {
		super();
		this.owner = owner;
		this.type = type;
		this.balance = balance;
		counter = counter + 1;
		this.id = counter;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", owner=" + owner + ", type=" + type + ", balance=" + balance + "]";
	}
	
	
	
	

}
