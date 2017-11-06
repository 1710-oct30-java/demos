package com.revature.banking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding.Use;

public class AccountCreation {
	public static void createUser() throws IOException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter your first AND last name: ");
		String[] names = scan.nextLine().split(" ");
		String firstName = names[0];
		String lastName = names[1];

		// Continue looping until a unique username is chosen.
		String username;
		do {
			System.out.println("Please select a username: ");
			username = scan.nextLine();

		} while (checkExistingUsernames(username));

		System.out.println("Please enter a password: ");
		String password = scan.nextLine();

		//Assemble a new user class using the information provided above by the user.
		User newUser = new User(firstName, lastName, username, password);

		System.out.println("Account \"" + username + "\" created.");

		// Write to the database.
		Terminal.userList.add(newUser);
		Terminal.UpdateDatabase();

		Terminal.landingScreen();
	}

	//This method ensures that the username is not already taken.
	private static boolean checkExistingUsernames(String desiredUsername) throws IOException {
		for (User user : Terminal.userList) {
			if (user.getUsername().equals(desiredUsername)) {
				System.out.println("Username already in use. Please select another.");
				return true;
			}
		}

		return false;
	}
}
