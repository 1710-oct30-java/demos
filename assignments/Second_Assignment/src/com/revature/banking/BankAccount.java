package com.revature.banking;

import java.io.Serializable;

/* Author: Stephen Huelsman
 * 
 * 
	Users can log in
	users can create and close multiple bank accounts
	users can deposit and withdraw
	users/bank accounts will be serialzed to a text file

	account
		int id
		user owner
		double balance
		String accountType
		
 * 
 */
public class BankAccount implements Serializable {
	public int id;
	public User owner;
	public double balance;
	public String type;
	
	public BankAccount(int x, User u, double d, String s) {
		id = x;
		owner = u;
		balance = d;
		type = s;
	}
	
	public int getID() {
		return id;
	}
	
	public void deposit(double d) {
		balance = balance + d;
	}
	
	public void withdraw(double d) {
		balance = balance - d;
	}
	
}