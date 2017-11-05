package com.edel.banking.application;

import java.util.Scanner;

import com.edel.banking.bank.Bank;
import com.edel.banking.login.Login;
import com.edel.banking.user.User;

public abstract class UserLogin extends Application
{
	// Main Menu - Case 2 - Open a new account
	protected static void login()
	{
		Scanner scanner;
		boolean userLoginMenu = true;
		String email;
		String password;
		
		while(userLoginMenu)
		{
			System.out.println("\t\tLogin to your portal\n"
							+ "\t\t0 - Exit Application\n"
							+ "\t\t1 - Go Back\n");
			try
			{
				System.out.print("Email: ");
				scanner = new Scanner(System.in);
				email = scanner.nextLine();
				
				// Exit application
				if(email.equals("0"))
				{
					goodbyeMessage();
					userLoginMenu = false;
					mainMenu = false;
				}
				
				else if(email.equals("1"))
				{
					printStars();
					mainMenu();
					userLoginMenu = false;
				}
				
				// Else try to log in user
				else
				{
					System.out.print("Password: ");
					scanner = new Scanner(System.in);
					password = scanner.nextLine();
					
					// If log in info is correct, log in user and display accounts information
					if(Login.checkLogin(email, password))
					{
						printStars();
						bank.setUserAccounts(Login.getUser());
						userLoginMenu = false;			// Current user log in menu
						UserAccount.userAccount();
					}
					
					else
					{
						System.err.println("Invalid login!\n");
					}
				}
			} catch (Exception e)
			{
				//e.printStackTrace();
			}
		}
	}
	
}
