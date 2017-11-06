package com.edel.banking.application;

import java.util.Scanner;

import com.edel.banking.bank.Bank;
import com.edel.banking.serialization.Deserialize;
import com.edel.banking.serialization.Serialize;

public class Application
{
	protected static Bank bank = new Bank();
	protected static boolean mainMenu = true;
	
	// Start application
	public static void start()
	{
		// Create accounts file if it doesn't exist
		if(!Serialize.accountsFile.exists())
		{
			Serialize.serializeAccounts();
		}
		
		// Create users file if it doesn't exist
		if(!Serialize.usersFile.exists())
		{
			Serialize.serializeUsers();
		}
		
		// Deserialize accounts and users to read data upon application start
		Deserialize.deserializeAccounts();
		Deserialize.deserializeUsers();
		
		// Enter into main menu
		mainMenu();
	}
	
	// Print goodbye message to user upon exit of application
	protected static void goodbyeMessage()
	{
		System.out.println("\nThank you for using Edel Banking Solutions!\n");
	}
	
	// Print stars
	protected static void printStars()
	{
		System.out.println("\n*\t*\t*\t*\t*\t*\t*\t*\t*\t*\t\n");
	}
	
	// Display main menu options
	protected static void displayMainMenu()
	{
		String welcomeTitle = "\t\tWelcome to Edel Banking Solutions!\n";
		String mainMenu = "\nBanking Center\n"
						+ "1) Open a new account\n"
						+ "2) Exit application\n"
						+ "\nCustomer Portal\n"
						+ "3) Login\n"
						+ "\nPlease enter a selection: ";
		
		System.out.print(welcomeTitle + mainMenu);
	}
	
	// Main Menu
	protected static void mainMenu()
	{
		Scanner scanner;
		String mainMenuSelection;
		
		displayMainMenu();
		
		while(mainMenu)
		{
			try
			{
				scanner = new Scanner(System.in);
				mainMenuSelection = scanner.nextLine();
				
				switch (mainMenuSelection)
				{
					// Open a new account
					case "1":
						printStars();
						OpenAccount.openAccount();
						break;
						
					// Exit application
					case "2":
						scanner.close();
						goodbyeMessage();
						mainMenu = false;
						break;
					
					// User login
					case "3":
						printStars();
						UserLogin.login();
						break;
					
					default:
						if(!mainMenuSelection.isEmpty() && Character.isDigit(mainMenuSelection.charAt(0)))
						{
							System.err.println("Invalid input!");
							printStars();
							mainMenu();
						}
						else
						{
							System.err.println("Invalid selection!");
							printStars();
							mainMenu();
						}
						break;
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		} // End main application loop		
	}
	
}
