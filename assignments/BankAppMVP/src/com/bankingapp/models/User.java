package com.bankingapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class User {
	private String mUsername;
	private String mPassword;
	private List<Account> mAccounts;
	
	public User(String username, String password) {
		mUsername = username;
		mPassword = password;
	}
	
	public String getUsername() {
		return mUsername;
	}
	
	public List<Account> getAccounts() {
		return mAccounts;
	}
	
	public void createNewAccount(Account account) {
		mAccounts.add(account);
	}
	
	public Account viewAccount(int index) {
		return mAccounts.get(index);
	}
	
	public void deleteAccount(int index) {
		mAccounts.remove(index);
	}
	
}
