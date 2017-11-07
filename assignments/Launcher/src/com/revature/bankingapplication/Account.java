package com.revature.bankingapplication;

import java.util.Scanner;

public class Account {
	
	private int id;
	private static double balance = 0;
	private String type;
	
	public Account(int id, double balance, String type) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static double getBalance() {
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


	
	
}
