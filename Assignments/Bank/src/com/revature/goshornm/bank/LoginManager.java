package com.revature.goshornm.bank;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.revature.goshornm.bank.user.User;
import com.revature.goshornm.bank.user.UserAccountManager;

public class LoginManager {
	
	public void entry() {
		String systemErrorMessage = "Login attempt failed due to a system error.";
		String inputErrorMessage  = "Username and/or password is incorrect.";
		
		//Prompt user for username
		String username = getUsername();
		byte[] hash = new byte[0];
		
		//Attempt to prompt user for password (Stored as hash)
		try {
			hash = Util.promptForPasswordAsHash();
		} catch(NoSuchAlgorithmException exception) {
			System.out.println(systemErrorMessage);
			return;
		}
		
		//Authenticate
		User user = authenticate(username, hash);
		
		if(user == null) {
			System.out.println(inputErrorMessage);
			return;
		}
		
		
		
		UserAccountManager userAccountManager = new UserAccountManager(user);
		userAccountManager.entry();
	}
	

	public String getUsername() {
		String prompt = "Please enter your username: ";
		
		String input = Util.promptForString(prompt);
		
		System.out.println();
		return input;
	}
	
	public User findUserAccount(String userAccountHash) {
		String prefix = "Accounts/";
		String suffix = ".txt";
		Serializer<User> serializer = new Serializer<>();
		return serializer.readObject(prefix + userAccountHash + suffix);
	}
	
	public User authenticate(String username, byte[] hash) {
		//Check if username exists
		if(!User.accountExists(username) ) { return null; }
		
		User user = User.load(username);
		//TODO crash here when attempting to log in to non-existant account
		if(user.authenticate(hash)) {
			return user;
		}
		return null;
		
	}

	
	
}
