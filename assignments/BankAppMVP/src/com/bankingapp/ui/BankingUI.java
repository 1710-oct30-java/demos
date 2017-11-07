package com.bankingapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.bankingapp.models.*;

public class BankingUI {
	private User mUser;
	private Account mAccount;
	private BufferedReader mReader;
	private Map<String, String> mMenu;
	
	public BankingUI() {
		mReader = new BufferedReader(new InputStreamReader(System.in));
		mMenu = new HashMap<>();
		mMenu.put("create", "Create a new user");
		mMenu.put("login", "Login as existing user");
		mMenu.put("quit", "Exit the program");
	}
	
	private String promptAction() throws IOException {
		System.out.println("Welcome to the Banking Application MVP");
		System.out.println("Here are your options");
		for(Map.Entry<String,String> option : mMenu.entrySet()) {
			System.out.printf("%s - %s%n", option.getKey(), option.getValue());
		}
		System.out.println("What do you want to do:   ");
		String choice = mReader.readLine();
		return choice.trim().toLowerCase();
	}
	
	public void run() {
		String choice = "";
		do {
			try {
				choice = promptAction();
				switch(choice) {
					case "create":
						createUser();
						break;
					case "login":
						if(mUser != null) {
							System.out.println("Enter your user name");
							String username = mReader.readLine();
							System.out.println("Enter your password");
							String password = mReader.readLine();
							if(username.equals(mUser.getUsername()) && password.equals(mUser.getPassword())) {
								login();
							} else {
								System.out.println("Try again");
								run();
							}
						} else {
							System.out.printf("Please create a user account to log in! %n%n%n");
						}
						break;
					case "quit":
						System.out.println("Goodbye");
						break;
					default:
						System.out.printf("Unknown choice:   '%s'. Try Again. %n%n%n", choice);
				}
				
			} catch(IOException ioe) {
				System.out.println("Problem with input");
				ioe.printStackTrace();
			}
		} while(!choice.equals("quit"));
	}
	
	public void login() {
		boolean status = true;
		String choice = "";
		try {
			do {
				System.out.println("What would you like to do?");
				System.out.println("Enter 'create' to create a new account, 'view' accounts, " + 
				"'delete' to delete an account, or 'logout' to logout");
				choice = mReader.readLine();
				
				switch(choice) {
					case "create":
						createAccount();
						break;
					case "view":
						System.out.println("Here are your accounts");
						for(Account userAccount : mUser.getAccounts()) {
							System.out.println(userAccount);
						}
						
				}
				
				
			} while(status);
		} catch(IOException ioe) {
			System.out.println("Problem with input");
			ioe.printStackTrace();
		}
	}
	
	public void createUser() {  //
		try {
			System.out.println("Enter a username");
			String username = mReader.readLine();
			System.out.println("Enter a password");
			String password = mReader.readLine();
			mUser = new User(username, password);
			System.out.printf("User successfully created! %n%n%n");
		} catch(IOException ioe) {
			System.out.println("Problem with input");
			ioe.printStackTrace();
		}
		run();
	}
	
	public void createAccount() {  //method causes NullPointerException
		mAccount = new Account(0);
		try {
			System.out.println("Enter the balance for the account");
			String amount = mReader.readLine();
			float balance = Float.parseFloat(amount);
			mAccount.deposit(balance);
			System.out.printf("Created account with balance: %.2f %n%n&n", mAccount.getBalance());
			login();
			
		} catch(IOException ioe) {
			System.out.println("Problem with input");
			ioe.printStackTrace();
		}
		
	}
	
	
	
}
