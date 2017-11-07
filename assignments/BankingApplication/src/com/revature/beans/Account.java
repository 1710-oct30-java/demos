package com.revature.beans;

import java.io.Serializable;

/*
 * Account class - describes an account
 * id - account has an id
 * user - account has a user
 * balance - the balance of the bank account
 * type - the type of bank account: savings, checking
 */
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7383635038800454272L;
	private static int idNum = 1;
	private int id;
	private User user;
	private double balance;
	private String type;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(double balance, String type) {
		super();
		this.balance = balance;
		this.type = type;
		this.id = idNum++;
	}

	public Account(User user, double balance, String type) {
		super();
		this.user = user;
		this.balance = balance;
		this.type = type;
		this.id = idNum++;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", balance=" + balance + ", type=" + type + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	/*
	 * Withdraw Method
	 * Arguments: double - how much money they would like to withdraw
	 * Modifies the balance of the account - balance = balance - withdraw
	 */
	public void withdraw(double amount) {
		double b = balance - amount;
		if(b <= 0) {
			System.out.println("Not enough founds.");
		}else {
			balance = b;
		}
	}
	
	/*
	 * Deposit Method
	 * Arguments: double - how much money they would like to deposit
	 * Modifies the balance of the account - balance = balance + deposit
	 */
	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Cannot deposit a negative value.");
		}else {
			balance += amount;
		}
	}
}
