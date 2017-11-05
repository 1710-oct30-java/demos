package com.edel.banking.application;

import java.util.Scanner;

import com.edel.banking.account.Account;
import com.edel.banking.login.Login;
import com.edel.banking.serialization.Deserialize;
import com.edel.banking.serialization.Serialize;
import com.edel.banking.user.User;

public abstract class UserAccount extends Application
{
	private static boolean userAccountMenu = true;
	
	private static void displayUserInfo()
	{
		System.out.println("Welcome, " + Login.getUser().getFirstName() + "!\n");
		bank.displayAccountsByUser();
	}
	
	protected static void userAccount()
	{
		Scanner scanner;
		userAccountMenu = true;
		String userAccountMenuSelection;
		
		try
		{
			displayUserInfo();
			
			while(userAccountMenu)
			{
				System.out.print("1) Deposit\n"
							   + "2) Withdraw\n"
							   + "3) Close Account\n"
							   + "4) Close All Accounts\n"
							   + "5) Log out\n"
							   + "\nSelection: ");
				scanner = new Scanner(System.in);
				userAccountMenuSelection = scanner.nextLine();
				
				switch(userAccountMenuSelection)
				{
					// Deposit
					case "1": 
						deposit();
						printStars();
						displayUserInfo();
						break;
						
					// Withdraw
					case "2":
						withdraw();
						printStars();
						displayUserInfo();
						break;
					
					// Close Account
					case "3":
						closeAccount();
						printStars();
						displayUserInfo();
						break;
					
					// Close All Accounts
					case "4":
						//userAccountMenu = false;	// Current menu
						closeAllAccounts();
						break;
					
					// Log out
					case "5":
						userAccountMenu = false;	// Current menu
						userAccountMenuSelection = "";
						System.out.println("\nGoodbye, " + Login.getUser().getFirstName() + "!");
						bank.removeAccountsFromUsersList();
						Login.logOutUser();
						printStars();
						displayMainMenu();
						break;
						
					default:
						if(Character.isDigit(userAccountMenuSelection.charAt(0)))
						{
							System.err.println("Invalid input!");
							printStars();
							userAccount();
						}
						else
						{
							System.err.println("Invalid selection!");
							printStars();
							userAccount();
						}
						break;
				}
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	// Case 1 - Deposit
	private static void deposit()
	{
		Scanner scanner;
		int ID = 0;
		int amount = 0;
		
		System.out.print("Account #: ");
		scanner = new Scanner(System.in);
		ID = scanner.nextInt();
		
		if(bank.idMatchesUser(ID, Login.getUser()))
		{
			System.out.print("Amount: $ ");
			scanner = new Scanner(System.in);
			amount = scanner.nextInt();
			
			bank.getAccount(ID).deposit(amount);
		}
		
		else
		{
			System.err.println("That is not your account number!");
		}
	}
	
	// Case 2 - Withdraw
	private static void withdraw()
	{
		Scanner scanner;
		int ID = 0;
		int amount = 0;
		
		System.out.print("Account #: ");
		scanner = new Scanner(System.in);
		ID = scanner.nextInt();
		
		if(bank.idMatchesUser(ID, Login.getUser()))
		{
			System.out.print("Amount: $ ");
			scanner = new Scanner(System.in);
			amount = scanner.nextInt();
			
			bank.getAccount(ID).withdraw(amount);
		}
		
		else
		{
			System.err.println("That is not your account number!");
		}
		
	}
	
	// Case 3 - Close Account
	private static void closeAccount()
	{
		Scanner scanner;
		int ID = 0;
		int amount = 0;
		
		System.out.print("Account #: ");
		scanner = new Scanner(System.in);
		ID = scanner.nextInt();
		
		if(bank.idMatchesUser(ID, Login.getUser()))
		{
			bank.closeAccount(ID);
			System.out.println("Account #" + ID + " closed!");
		}
		
		else
		{
			System.err.println("That is not your account number!");
		}
	}

	// Case 3 - Close All Accounts
	private static void closeAllAccounts()
	{
		Scanner scanner;
		boolean closeAllAccountsMenu = true;
		String input;
		try
		{
			while(closeAllAccountsMenu)
			{
				System.err.print("\nAre you sure you want to close all your accounts? (y/n): ");
				scanner = new Scanner(System.in);
				input = scanner.nextLine();
				
				if(input.charAt(0) == 'y' || input.charAt(0) == 'Y')
				{
					bank.closeAllUserAccounts(Login.getUser());
					
					Serialize.serializeAccounts();
					Serialize.serializeUsers();
					
					Deserialize.deserializeAccounts();
					Deserialize.deserializeUsers();
					
					System.out.println("All accounts closed!");
					Login.logOutUser();
					closeAllAccountsMenu = false;
					userAccountMenu = false;
					displayMainMenu();
				}
				else if(input.charAt(0) == 'n' || input.charAt(0) == 'N')
				{
					closeAllAccountsMenu = false;
					printStars();
					displayUserInfo();
				}
				
				else
				{
					System.err.println("Invalid entry!\n");
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
