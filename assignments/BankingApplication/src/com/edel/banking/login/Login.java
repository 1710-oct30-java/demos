package com.edel.banking.login;

import java.util.Scanner;

import com.edel.banking.bank.Bank;
import com.edel.banking.user.User;

// This class manages the login process

public class Login
{
	private static User user; 
	private static String email;
	private static String password;
	private static boolean session = false;

	public Login()
	{
		
	}

	public static void loginMenu()
	{
		try
		{
			System.out.println("\t\tWelcome!\nPlease enter you credentials below:");
			
			System.out.print("Enter email: ");
			Scanner emailScanner = new Scanner(System.in);
			email = emailScanner.nextLine();
			
			
			System.out.print("Enter password: ");
			Scanner passwordScanner = new Scanner(System.in);
			password = passwordScanner.nextLine();
			
			if(checkLogin(email, password))
			{
				System.out.println("Login successful!");
			}
			else
			{
				System.out.println("Invalid credentials!");
			}
			
			// Close scanners
			emailScanner.close();
			passwordScanner.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Returns true if login credentials are valid
	public static boolean checkLogin(String email, String password)
	{
		for (User usr : Bank.getUsers())
		{
			if (usr.getEmail().equals(email) && usr.getPassword().equals(password))
			{
				user = new User();
				// If a user is logged in, log out current user and log in new user
				if(sessionStatus())
				{
					System.out.println(user.getFirstName() + " logged out!");
					logOutUser();
					
					logInUser(usr); 	// set session = true and log in user
					return true;
				}
				
				// Log in user
				else
				{
					logInUser(usr); 	// set session = true and log in user
					return true;
				}
			}
		}
		return false;
	}
	
	// Return user account
	public static User getUser()
	{
		return user;
	}
	
	// Get session status
	public static boolean getSession()
	{
		return session;
	}
	
	// Set session status
	public static void setSession(boolean se)
	{
		session = se;
	}
	
	// Set session true to log in user
	private static void logInUser(User usr)
	{
		user = usr;
		session = true;
	}
	
	// Set session false to log out user and reset fields
	public static void logOutUser()
	{
		session = false;
		//user = null;
		email = "";
		password = "";
	}
	
	// Returns current session status
	private static boolean sessionStatus()
	{
		if(session == true)
			return true;
		return false;
	}
}