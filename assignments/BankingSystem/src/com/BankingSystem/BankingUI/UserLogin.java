package com.BankingSystem.BankingUI;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.BankingSystem.BankClasses.User;
import com.BankingSystem.BankDataManagement.UserList;

public class UserLogin extends UIElement {
	/*
	 * UI for user login as well as new client creation.
	 */
	private UserList userList;
	private User userEntering;

	public UserLogin() {
		super();
	}

	public User login(UserList uList) {
		// user login
		userEntering = null;
		userList = uList;

		boolean cancel;
		do {
			cancel = false;
			boolean displayFlag = true;
			String uName = null;
			do {
				// input a valid username or 0 to create new user
				System.out.print("Enter Username (Enter 0 to create new user): ");
				uName = getUIn().getWord();
				if (userList.usernameValidation(uName)) {
					userEntering = userList.getUserName(uName);
					displayFlag = false;
				} else if (uName.equals("0")) {
					newUser();
				} else {

					System.out.print("Invalid Username\n");
				}
			} while (displayFlag);
			// input valid password
			displayFlag = true;
			String uPassword = null;
			do {
				System.out.print("Enter 0 to cancel login\nEnter Password: ");
				uPassword = getUIn().getWord();
				if (uPassword.equals("0")) {
					displayFlag = false;
					cancel = true;
				} else if (passwordValidation(uPassword)) {
					displayFlag = false;
				} else {

					System.out.print("Invalid Username/Password Combonation\n");
				}
			} while (displayFlag);
		} while (cancel);

		return userEntering;

	}

	public boolean passwordValidation(String uPassword) {
		// compares inputed string to stored password(hashed)
		MessageDigest hasher;
		try {
			hasher = MessageDigest.getInstance("SHA-256");
			hasher.update(uPassword.getBytes());
			uPassword = new String(hasher.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return userEntering.getPassword().equals(uPassword);
	}

	public void newUser() {
		// Prompts for creating new client user
		userList.createClient(getUIn());
	}

}
