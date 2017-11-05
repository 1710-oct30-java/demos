package GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import actions.Login;
import actions.Parser;
import actions.Signup;
import objects.User;

public class Home {

	public static ArrayList<User> userData;

	public static void main(String[] args) throws IOException {
		
		// Program starts from here.
		// Asks user to sign up for a new account or log in to existing account

		Parser p = new Parser();
		userData = p.ParseUser();
		String choice;

		Scanner in = new Scanner(System.in);
		System.out.println("What do you want to do?");
		System.out.println("1. Sign up as new user");
		System.out.println("2. login as old user");
		choice = in.nextLine();
		// System.out.println(choice);
		if (choice.equals("1")) {
			Signup.sup();
			System.out.println("option 1 chosen");

		} else if (choice.equals("2")) {
			Login.login(userData);

		} else {
			System.out.println("Invalid Option");
			Home.main(null);
		}

	}
}
