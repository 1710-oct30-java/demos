package com.revature.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.Banking;
import com.revature.beans.Account;

public class BankingTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scn = new Scanner(System.in);
		Banking b = new Banking();
		
		List<Account> accounts = new ArrayList<>();
		Account currentAccount=null;
		
		// Gets list of users from the text file
		accounts = b.getAllUsers();
		int currentAccountIndex = 0;
		
		// Checks user and password and gets the account index within the list
		while (currentAccount==null) {
			currentAccount=b.login(accounts);
			currentAccountIndex = b.getCurrentAccountIndex(accounts, currentAccount);
		}
		
		// Prints menu and prompts user
		printMenu();
		int i = scn.nextInt();
		
		
		while (i != 0) {
			switch (i) {
			case 1:
				// Checks the balance of the current user
				System.out.println("Your current balance is " +b.getBalance(accounts.get(currentAccountIndex)));
				printMenu();
				i = scn.nextInt();
				break;
			case 2:
				// Makes deposit to current users account
				System.out.println("How much would you like to deposit");
				double d = scn.nextDouble();
				b.deposit(accounts.get(currentAccountIndex), d);
				
				// commits changes to accounts list
				accounts = b.getAllUsers();
				System.out.println("Deposited $"+ d);
				printMenu();
				i = scn.nextInt();
				break;
			case 3:
				// Makes withdraw to current users account
				System.out.println("How much would you like to withdraw");
				double w = scn.nextDouble();
				b.withdraw(accounts.get(currentAccountIndex), w);
				accounts = b.getAllUsers();
				System.out.println("Withdrew $"+ w);
				printMenu();
				i = scn.nextInt();
				break;
			case 4:
				// Creates an account and writes it to the text file
				System.out.println("Create an account");
				b.createAccount();
				accounts = b.getAllUsers();
				printMenu();
				i = scn.nextInt();
				break;
			case 5:
				// Deletes an account form the text file
				System.out.println("Delete an account");
				System.out.println("What is the username of the account to be deleted? ");
				String uname = scn.nextLine();
				Account a = Banking.getAccountByUsername(accounts, uname);
				b.deleteAccount(a);
				accounts.subList(0, accounts.size()-1);
				printMenu();
				i = scn.nextInt();
				break;
			case 6:
				// Shows all users in the text file
				System.out.println("Showing all users");
				b.printAllUsers(accounts);
				printMenu();
				i = scn.nextInt();
				break;
			case 7:
				// Terminates program/signs user out
				System.out.println("Goodbye");
				System.exit(0);
				break;
			}
		}
	}

	public static void printMenu() {
		System.out.println("What would you like to do: " + "\n(1) View Existing Account" + "\n(2) Make A Deposit"
				+ "\n(3) Make A Withdraw" + "\n(4) Create an account" + "\n(5) Delete an account" 
				+ "\n(6) Show all Users" + "\n(7) Sign out");
	}

}
