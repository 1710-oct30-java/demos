package com.revature.bankingapplication;

import java.util.Scanner;

public class User {
	
	//
	private String firstname;
	private String lastname;
	private String email;
	
	private String username;
	private String password; 
	
	public Account savings = new Account(1, 0, "savings");
	public Account checking = new Account(2, 0, "checking");
	
	public User(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static void login (String username, String password) {
		
	}
	
public static void logout (String username, String password) {
		
	}
	
	public double deposit(Account a, double amount) {
		double myBalance = a.getBalance();
		myBalance += amount;
		
		return myBalance;
	}
	
	public void withdraw(Account a, double amount) {
		double myBalance = a.getBalance();
		myBalance -= amount;
	}
	
	public static void createAccount() {
		System.out.println("Which type of account would you like to create, saving or checking? Enter checking or saving:");
		
	}
	
	public void deleteAccount(Account a) {
		
	}
	
	
	public static String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public static String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the banking application! what would you like to do?\n");
		String response = scan.nextLine();
		
		if (response == "login") {
			login(username, password);
		}
		
		if (response == "view account") {
			viewAccount(response);
		}
		
		if (response == "deposit") {
			deposit();
		}
		
		if (response == "withdraw") {
			withdraw();
		}
		
		if (response == "create account") {
			createAccount();
		}
		
		if (response == "delete account") {
			deleteAccount(a);
		}
		
		if (response == "logout") {
			createAccount();
		}
	}


	
}
