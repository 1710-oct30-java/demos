package com.edel.banking.application;

import java.util.Scanner;

public abstract class CloseAccount extends Application
{
	// User Login - Close accounts
	public static void closeAccount()
	{
		Scanner scanner;
		boolean closeAccount = true;
		String closeAccountSelection;
		
		String closeAccountMenu = "What would you like to do?\n"
								+ "1) Close Account\n"
								+ "2) Close All Accounts\n"
								+ "3) Go Back\n"
								+ "4) Exit Application\n"
								+ "\nPlease enter a selection: ";
		
		System.out.print(closeAccountMenu);
		
		while(closeAccount)
		{
			try
			{
				scanner = new Scanner(System.in);
				closeAccountSelection = scanner.nextLine();
				
				switch (closeAccountSelection)
				{
					// Close Account
					case "1":
					
						break;
						
					// Close All Accounts
					case "2":
					
						break;
					
					// Go Back
					case "3":
						Application.printStars();
						Application.mainMenu();
						closeAccount = false;	// Current open account loop
						break;
					
					// Exit Application
					case "4":
						goodbyeMessage();
						closeAccount = false;	// Current open account loop
						mainMenu = false;			// Main application loop
						break;
						
					default:
						if(Character.isDigit(closeAccountSelection.charAt(0)))
						{
							System.err.println("Invalid selection!");
							printStars();
							closeAccount();
						}
						else
						{
							System.err.println("Invalid selection!");
							printStars();
							closeAccount();
						}
						break;
				}
			} catch (Exception e)
			{
				//e.printStackTrace();
			}
			
		}
	}
}
