package com.revature.goshornm.bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.money.MonetaryAmount;

public class User implements Serializable {
	
	/* Non-serialized data */
	private static transient final String FILE_PREFIX = "UserAccounts\\";
	private static transient final String FILE_SUFFIX = ".txt";
	private static transient final int USERNAME_MIN_LENGTH = 5;
	
	private transient List<Account> accounts = new ArrayList<>();
	private transient String username;
	
	/* Serialized data */
	private static final long serialVersionUID = 8392858064415068195L;
	
	private String name;
	private byte[] hash;
	private ArrayList<Long> accountIDs = new ArrayList<>();
	
	public User(String name, String username, byte[] hash) {
		this.name = name;
		this.username = username;
		this.hash = hash;
		this.accounts = new ArrayList<>();
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", hash=" + Arrays.toString(hash) + ", accounts="
				+ accounts + ", accountIDs=" + accountIDs + "]";
	}

	/**
	 * Loads user account data in to memory given a username
	 * @param username - provided username
	 * @return User object correlating to the username hash
	 */
	public static User load(String username) {
		String accountFetchError = "An error occured while trying to access the account.";
		
		/*(
	    		FileInputStream fis = new FileInputStream(FILE_PREFIX + username + FILE_SUFFIX);
	    		ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			Object userObject = ois.readObject();
			fis.close();
			ois.close();
			User user = (User)userObject;*/
		
		User user = User.deserialize(username);
		if(user == null) return null;
		return user;
			
		/*
			return (User)userObject;
	    } catch (IOException e) {
			System.out.println(accountFetchError);
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println(accountFetchError);
			return null;
		}*/
	}

	

	/**
	 * Gets data from user then creates and stores a new User
	 * @return new User object
	 */
	public static User create() {
		//Error message for NoSuchAlgorithmException - login/account creation is broken in this case
		String systemError = "This account could not be created due to an internal system error.";
		String success = "Your new user account has been created. Please login to the account to continue.";
		
		try {
			String username = promptForUsername();
			byte[] hash = Util.promptForPasswordAsHash();
			String name = promptForLegalName();
			
			User user = new User(name, username, hash);
			
			//TODO serialize User object here
			user.serialize();
			
			System.out.println(success+"\n");
			
			return user;
			
		} catch(NoSuchAlgorithmException e) {
			System.out.println(systemError);
			return null;
		}
	}
	
	
	/**
	 * Writes user object to file
	 */
	private void serialize() {
		String address = FILE_PREFIX + username + FILE_SUFFIX;
		Serializer<User> userSerializer = new Serializer<>();
		userSerializer.writeObject(this, address);
		
		for(Account account : accounts) {
			account.serialize();
		}
		
	}
	
	/**
	 * Retrieves user object from file
	 * @return - User object
	 */
	private static User deserialize(String username) {
		String address = FILE_PREFIX + username + FILE_SUFFIX;
		Serializer<User> userSerializer = new Serializer<>();
		User user = userSerializer.readObject(address);
		user.setUsername(username);
		user.accounts = new ArrayList<>();
		user.loadAccounts();
		
		return user;
	}
	

	/**
	 * Loads user accounts from file and adds them to accounts list
	 */
	public void loadAccounts() {
		for(long accountID : accountIDs) {
			accounts.add(Account.load(accountID));
		}
	}

	/**
	 * Prompts user to enter their legal name.
	 * @return user entered legal name
	 */
	private static String promptForLegalName() {
		String prompt = "Please enter your legal name as written on a government issued ID." +
						"\n\t(Valid IDs include birth certificate, driver's license, passport, and death certificate";
		return Util.promptForString(prompt);
	}

	/**
	 * Prompts the user for their username
	 * @return user entered username
	 */
	private static String promptForUsername() {
		String prompt = "Please enter a username to represent your account."
		+ "\n\tUsername must be at least "+USERNAME_MIN_LENGTH+" characters in length.";
		
		String username = "";
		do {
			username = Util.promptForString(prompt);
		} while(!validateUsername(username));
		
		return username;
	}
	
	/**
	 * Validates that a username meets username requirements. Outputs error message if username fails validation.
	 * @param username - Username to validate
	 * @return - True if username is valid, false otherwise
	 */
	public static boolean validateUsername(String username){
		String existsError = "This username is taken.";
		String shortError = "The submitted username is too short.";
		
		//Minimum length requirement
		if(username.length() < USERNAME_MIN_LENGTH) {
			System.out.println(shortError);
			return false;
		}
		
		//Username not already used requirement
		if(User.accountExists(username)) {
			System.out.println(existsError);
			return false;
		}
		
		return true;		
	}
	
	public void addAccount(Account account) {
		this.accountIDs.add(account.getAccountID());
		if(this.accounts == null) accounts = new ArrayList<>();
		this.accounts.add(account);
		
		account.serialize();
		this.serialize();
	}

	/**
	 * Checks if a user account with the supplied username exists.
	 * @param username - Username to check if exists
	 * @return - true if the username is already used, false otherwise
	 */
	public static boolean accountExists(String username) {
		File file = new File(FILE_PREFIX + username + FILE_SUFFIX);
		return file.exists();
	}

	/**
	 * Authenticates for user login.
	 * Authenticates that the byte hash of a user entered password matches the stored password.
	 * @param inputHash - Hash of user input password
	 * @return - true when user data passes authentication, false otherwise
	 */
	public boolean authenticate(byte[] inputHash) {
		if(inputHash.length != hash.length) return false;
		for(int i = 0; i < inputHash.length; i++) {
			if(inputHash[i] != hash[i]) return false;
		}
		return true;
	}
	
	public boolean passwordsMatch(byte[] pass1, byte[] pass2) {
		if(pass1.length != pass2.length) return false;
		for(int i = 0; i < pass1.length; i++) {
			if(pass1[i] != pass2[i]) return false;
		}
		return true;
	}
	
	public void updatePassword() throws NoSuchAlgorithmException {
		byte[] currentPassEnteredHash;
		currentPassEnteredHash = Util.promptForPasswordAsHash();
		
		if(!authenticate(currentPassEnteredHash)) {
			System.out.println("Incorrect password.");
			return;
		}
		
		byte[] pass1 = Util.promptForPasswordAsHash("\nEnter new password:");
		byte[] pass2 = Util.promptForPasswordAsHash("\nReenter password.");
		
		if(passwordsMatch(pass1, pass2)) {
			hash = pass1;
			System.out.println("Your password has been updated.");
			serialize();
		} else {
			System.out.println("Passwords did not match.");
		}
		
	}
	
	public void removeAccountFromUserAccount(Account account) {
		getAccounts().remove(account);
		accountIDs.remove(account.getAccountID());
		serialize();
	}

}
