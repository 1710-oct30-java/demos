package com.revature.banking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/*
 * For the Account class, we do not want balance or type to be directly accessible. 
 * Balance can only be accessed via withraw() and deposit(). Type must be initialized in the
 *  constructor and cannot be changed thereafter.
*/

public class Account implements Serializable {
	private User owner;
	private AccountType type;
	private double balance;

	public Account(User owner, AccountType type) {
		super();
		this.owner = owner;
		this.type = type;
	}

	public <T extends Number> void deposit(T amount) throws FileNotFoundException, IOException {
		balance += amount.doubleValue();
		Terminal.UpdateDatabase();
	}

	public <T extends Number> void withdraw(T amount) throws FileNotFoundException, IOException {
		if (balance >= amount.doubleValue()) {
			balance -= amount.doubleValue();
		} else
			System.out.println("Insufficient Funds.");

		Terminal.UpdateDatabase();
	}

	// We only want these fields to be read-only.
	public User getOwner() {
		return owner;
	}

	public AccountType getType() {
		return type;
	}

	public double getBalance() {
		return balance;
	}

}
