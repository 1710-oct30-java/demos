package com.revature.banking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogIn {
	
	//This method allows the user to enter their username and password to attempt a login.
	public static void enterLoginCredentials() throws IOException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();

		attemptLogin(username, password);

		scan.close();
	}

	
	//This method checks the database for a username/password match.
	public static void attemptLogin(String username, String password) throws IOException {
		for (User user : Terminal.userList) {
			if (user.getUsername().equals(username)) {
				if (user.getPassword().equals(password)) {
					// Successful login.
					System.out.println("Welcome, " + user.getFirstName() + ".");
					AccountManagement.beginAccountManagement(user);
				} else {
					System.out.println("The password entered was incorrect.");
					Terminal.landingScreen();
				}

				return;
			}
		}

		System.out.println("Username not found.");
		Terminal.landingScreen();
	}

}
