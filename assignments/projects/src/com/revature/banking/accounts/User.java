package com.revature.banking.accounts;

import java.util.ArrayList;
import java.util.List;

public class User extends Account{
	private String username;
	private String password;
	private int accountID;
	private List<Account> userAccounts = new ArrayList<Account>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fullName, String password) {
		super();
		this.username = fullName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [fullName=" + username + ", password=" + password + ", accounts=" +"]";
	}
	public List<Account> getUserAccounts() {
		return userAccounts;
	}
	public void setUserAccounts(List<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}
	public String getFullName() {
		return username;
	}
	public void setFullName(String fullName) {
		this.username = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void newAccount() {
		
		Account account = new Account(0,accountID++);
		userAccounts.add(account);
		System.out.println("Account Created Successfully");
	}
}
