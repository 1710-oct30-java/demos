package com.revature.banking;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Terminal {
	
	//The userList will be held across sessions using serialization to a text file.
	public static List<User> userList = new ArrayList<>();
	public static Serializer<List<User>> userListSerializer = new Serializer<>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Retrieve database, or make a new one if it doesn't exist.
		try {
			userList = (userListSerializer.readObject("userDatabase.txt"));
		} catch (EOFException e) {
			//It's OK if there's no users in the database.
		}
		catch (FileNotFoundException e) {
			FileWriter fw = new FileWriter("userDatabase.txt");
		}
		
		System.out.println("----Welcome to Keener Banking----");
		landingScreen();

	}

	
	//The landing screen is the home hub of the entire application.
	public static void landingScreen() throws IOException {

		Scanner scan = new Scanner(System.in);
		boolean validInput = false;

		//Continue looping until the user has inputted a valid choice.
		while (!validInput) {
			System.out.println("Please select:");
			System.out.println("<1> Log In");
			System.out.println("<2> Create Account");
			
			int input = scan.nextInt();
			scan.nextLine();
		
			validInput = true;

			switch (input) {
			case 1:
				//Take the user to the sign-in screen.
				LogIn.enterLoginCredentials();
				break;
			case 2:
				//Take the user to the account creation screen.
				AccountCreation.createUser();
				break;
			default:
				System.out.println("Invalid input.");
				validInput = false;
				break;
			}
		}
		
		
	}

	public static void UpdateDatabase() throws FileNotFoundException, IOException {
		userListSerializer.writeObject(Terminal.userList, "userDatabase.txt");
	}
	
}
