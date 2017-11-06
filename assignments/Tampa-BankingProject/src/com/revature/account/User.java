package com.revature.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

	public String username;
	public List<Account> accounts = new ArrayList<Account>();

	public User(String username, List<Account> accounts) {
		super();
		this.username = username;
		this.accounts = accounts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", accounts=" + accounts + "]";
	}
	
	

}
