package com.revature.beans;

import java.io.Serializable;
import java.util.List;

/*
 * User class - this class represents a user. The user has a user e-mail, password, username, name, list of accounts,
 * and a boolean to check if they are logged in
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -727626359378125009L;
	private String name; 
	private String userEmail;
	private String password;
	private String username;
	private List<Account> accounts;
	private boolean loogedIn;
	
	public boolean isLoogedIn() {
		return loogedIn;
	}


	public void setLoogedIn(boolean loogedIn) {
		this.loogedIn = loogedIn;
	}


	public User() {
		super();
	}

	public User(String name, String userEmail, String password, String username, List<Account> accounts) {
		super();
		this.name = name;
		this.userEmail = userEmail;
		this.password = password;
		this.username = username;
		this.accounts = accounts;
		this.setLoogedIn(false);
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}




	@Override
	public String toString() {
		return "User [name=" + name + ", userEmail=" + userEmail + ", password=" + password + ", username=" + username
				+ ", accounts=" + accounts + ", loogedIn=" + loogedIn + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
