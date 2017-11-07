package com.revature.banking.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.revature.banking.*;
import com.revature.banking.accounts.Account;
import com.revature.banking.accounts.User;

public class BankingController {
	int attempts = 0;//var for checking invalid credentials
	Scanner input = new Scanner(System.in);

	public void display(User user) throws IOException {
		String username;
		String password;
		//Displays login
		System.out.println("*************************Banking Login***************************");
		System.out.print("Username: ");
		username = input.nextLine();
		System.out.print("Password: ");
		password = input.nextLine();
		System.out.println("*****************************************************************");
		login(username, password, user);
	}

	public void login(String user, String pass, User account) throws IOException {
		int response;
		//Checks credentials
		if (user.equals(account.getFullName()) && pass.equals(account.getPassword())) {
			System.out.println("Login Successful");
			System.out.println("*****************************************************************");
			do {
				System.out.println("1. View Accounts");
				System.out.println("2. View Balance");
				System.out.println("3. Deposit");
				System.out.println("4. Withrawal");
				System.out.println("5: New Account ");
				System.out.println("6: Logout");
				System.out.print("Select an option: ");
				response = Integer.parseInt(input.nextLine());
				System.out.println("*****************************************************************");
				//Checks users' response and goes to proper method
				switch (response) {
				case 1:
					//Displays user's accounts
					for(Account each: account.getUserAccounts())
					{
						System.out.println(each);
					}
					System.out.println("*****************************************************************");
					break;
				case 2:
					//Displays total balance across accounts
					double totalBalance = 0;
					for(Account each: account.getUserAccounts())
					{
						totalBalance+=each.getBalance();
						
					}
					System.out.println("Total Balance: $" + totalBalance);
					System.out.println("*****************************************************************");
					break;
				case 3:
					double depositAmount;
					System.out.println("Enter amount to deposit: ");
					depositAmount = Double.parseDouble(input.nextLine());
					deposit(account,depositAmount);
					System.out.println("*****************************************************************");
					break;
				case 4:
					double withdrawAmount;
					System.out.println("Enter amount to withdraw: ");
					withdrawAmount = Double.parseDouble(input.nextLine());
					withdraw(account,withdrawAmount);
					System.out.println("*****************************************************************");
					break;
				case 5:
					account.newAccount();
					break;
				case 6:
					logout(account);
					break;
				default:
					System.out.println("Invalid Response");
					break;
				}
			} while (response != 6);

		} else if (attempts > 2)//Ends program after certain # of invalid attempts
			System.out.println("Account Locked");
		else {
			System.out.println("Invalid Credentials. Try again");
			attempts++;
			display(account);
		}
	}
	
	public void deposit(User account, double amount) {//Implementing Deposit method
		Integer response;
		System.out.println("Enter Account # For Deposit");
		response = Integer.parseInt(input.nextLine());
		for(Account each: account.getUserAccounts())
		{
			if(response.equals(each.getAccID()))
			{
					//Adds deposit amount to total balance of account
					each.setBalance(amount);
					System.out.println("Deposit Successful");
			}
		}
		
	}
	
	public void withdraw(User account, double amount) {//Implementing Withdrawal method
		Integer response;
		System.out.println("Enter Account # For Withdrawal");
		response = Integer.parseInt(input.nextLine());
		for(Account each: account.getUserAccounts())
		{
			if(response.equals(each.getAccID()))
			{
					//Subtracts withdrawal amount from total balance of account
					each.setBalance(-amount);
					System.out.println("Withdrawal Successful");
			}
		}
		
	}

	public void logout(User user) throws IOException {//Implementing Logout method
		
		//Serializes new data and writes to file and then closes
		File f = new File("accountDetails.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(user);
		oos.close();

	}
}
