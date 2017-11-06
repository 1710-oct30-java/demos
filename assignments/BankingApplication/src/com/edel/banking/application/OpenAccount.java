package com.edel.banking.application;

import java.util.Scanner;

import com.edel.banking.account.Account;
import com.edel.banking.account.CheckingAccount;
import com.edel.banking.account.SavingsAccount;
import com.edel.banking.serialization.Deserialize;
import com.edel.banking.serialization.Serialize;
import com.edel.banking.user.User;

public abstract class OpenAccount extends Application
{
	protected static boolean openAccountMenu = true;
	
	// Main Menu - Case 1 - Open a new account
	protected static void openAccount()
	{
		Scanner scanner;
		
		String newAccountSelection;
		
		while(openAccountMenu)
		{
			String newAccountMenu = "\t\t\t\tBanking Center\n"
					+ "What would you like to do?\n"
					+ "1) Open Checking Account\n"
					+ "2) Open Savings Account\n"
					+ "3) Go Back\n"
					+ "4) Exit Application\n"
					+ "\nPlease enter a selection: ";

			System.out.print(newAccountMenu);
			
			try
			{
				scanner = new Scanner(System.in);
				newAccountSelection = scanner.nextLine();
				
				switch (newAccountSelection)
				{
					// Open Checking Account
					case "1":
						printStars();
						newCheckingAccount();
						Application.mainMenu();
						break;
						
					// Open Savings Accounts
					case "2":
						openAccountMenu = false;	// Current open account loop
						printStars();
						newSavingsAccount();
						Application.mainMenu();
						break;
					
					// Go Back
					case "3":
						openAccountMenu = false;	// Current open account loop
						Application.printStars();
						Application.mainMenu();
						break;
					
					// Exit Application
					case "4":
						goodbyeMessage();
						openAccountMenu = false;	// Current openAccountMenu loop
						mainMenu = false;			// Main application loop
						break;
						
					default:
						if(!newAccountSelection.isEmpty() && Character.isDigit(newAccountSelection.charAt(0)))
						{
							System.err.println("Invalid input!");
							printStars();
							openAccount();
						}
						else
						{
							System.err.println("Invalid selection!");
							printStars();
							openAccount();
						}
						break;
				}
			} catch (Exception e)
			{
				//e.printStackTrace();
			}
			
		}
	}
	
	// Open new checking account
	public static void newCheckingAccount()
	{
		boolean newCheckingAccMenu = true;
		Scanner scanner;
		Account account;
		User user;
		
		try
		{
			while(newCheckingAccMenu)
			{
				System.out.println("\t\tNew Checking Account\n");
				
				System.out.print("First name: ");
				scanner = new Scanner(System.in);
				String firstName = scanner.nextLine();
				
				System.out.print("Last name: ");
				scanner = new Scanner(System.in);
				String lastName = scanner.nextLine();
				
				System.out.print("Email: ");
				scanner = new Scanner(System.in);
				String email = scanner.nextLine();
				
				System.out.print("Password: ");
				scanner = new Scanner(System.in);
				String password = scanner.nextLine();
				
				
				
				System.out.print("Balance (Minimum of $25): $ ");
				scanner = new Scanner(System.in);
				double balance = scanner.nextDouble();
				
				// Check balance is at least $25
				while(balance < 25)
				{
					System.err.println("\n$25 minimum to open a Checking Account!\n");
					
					System.out.print("Balance (Minimum of $25): $ ");
					scanner = new Scanner(System.in);
					balance = scanner.nextDouble();
				}
				
				// Create user and and user to list (done by createUser method)
				user = new User(firstName, lastName, email, password);
				bank.createUser(firstName, lastName, email, password);
				
				// Open new checking account
				account = new CheckingAccount(user, balance);
				bank.openAccount(account);
				
				// Write info to file
				Serialize.serializeAccounts();
				Serialize.serializeUsers();
				
				// Read info from file
				Deserialize.deserializeAccounts();
				Deserialize.deserializeUsers();
				
				System.out.println("\nAccount created!");
				System.out.println("Your account #: " + account.getID());
				newCheckingAccMenu = false;
			}
		} catch (Exception e)
		{
			// e.printStackTrace();
		}
	}
	
	
	// Check that password matches if user already exists
	
	
	
	// Open new savings account
	public static void newSavingsAccount()
	{
		boolean newSavingAccMenu = true;
		Scanner scanner;
		Account account;
		User user;
		
		try
		{
			while(newSavingAccMenu)
			{
				System.out.println("\t\tNew Savings Account\n");
				
				System.out.print("First name: ");
				scanner = new Scanner(System.in);
				String firstName = scanner.nextLine();
				
				System.out.print("Last name: ");
				scanner = new Scanner(System.in);
				String lastName = scanner.nextLine();
				
				System.out.print("Email: ");
				scanner = new Scanner(System.in);
				String email = scanner.nextLine();
				
				System.out.print("Password: ");
				scanner = new Scanner(System.in);
				String password = scanner.nextLine();
				
				System.out.print("Balance (Minimum of $1000): $ ");
				scanner = new Scanner(System.in);
				double balance = scanner.nextDouble();
				
				// Check balance is at least $1000
				while(balance < 1000)
				{
					System.err.println("\n$25 minimum to open a Checking Account!\n");
					
					System.out.print("Balance (Minimum of $1000): $ ");
					scanner = new Scanner(System.in);
					balance = scanner.nextDouble();
				}
				
				// Create user and and user to list (done by createUser method)
				user = new User(firstName, lastName, email, password);
				bank.createUser(firstName, lastName, email, password);
				
				// Open new checking account
				account = new SavingsAccount(user, balance);
				bank.openAccount(account);
				
				// Write info to file
				Serialize.serializeAccounts();
				Serialize.serializeUsers();
				
				// Read info from file
				Deserialize.deserializeAccounts();
				Deserialize.deserializeUsers();
				
				System.out.println("\nAccount created!");
				System.out.println("Your account #: " + account.getID());
				newSavingAccMenu = false;
			}
		} catch (Exception e)
		{
			// e.printStackTrace();
		}
	}
}
