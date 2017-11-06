/*
 * Class: User
 * Creator: Kyle Settles
 * Description: This class is used to represent the User of the Banking system.
 */

package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = 8579155359588960811L;
	private String name;
	private int pin;
	private List<Account> listAccounts = new ArrayList<Account>();
	private boolean isAdmin = false;
		
	public User() {
		super();
	}

	public User(String name, int pin) {
		super();
		this.name = name;
		this.pin = pin;
		if(pin == 0000) {
			isAdmin = true;
		}
	}
	
	public void createAccount(String type){
		Account newAccount = new Account(type);
		listAccounts.add(newAccount);
	}
	
	public void deleteAccount(int index) {
		listAccounts.remove(index);
	}
	
	public double withdrawFunds(Account acc, double amt) {
		double newBal = acc.getBalance() - amt;
		acc.setBalance(newBal);
		return newBal;
	}
	
	public double depositFunds(Account acc, double amt) {
		double newBal = acc.getBalance() + amt;
		acc.setBalance(newBal);
		return newBal;
	}
	
	public double viewBal(Account acc) {
		return acc.getBalance();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getListAccounts() {
		return listAccounts;
	}

	public void setListAccounts(List<Account> listAccounts) {
		this.listAccounts = listAccounts;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}