package com.revature.banking;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class AccountManagement {
	public static void beginAccountManagement(User user) throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean validInput = false;
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		while (!validInput) {
			System.out.println("Please select:");

			System.out.println("<1> Open New Account");
			System.out.println("<2> Log out");

			for (int i = 0; i < user.getAccounts().size(); i++) {
				Account acc = user.getAccounts().get(i);
				System.out.println("<" + Integer.toString(i + 3) + "> " + acc.getType() + " ["
						+ nf.format(acc.getBalance()) + "]");
			}

			int input = scan.nextInt();
			scan.nextLine();
			validInput = true;

			if (input == 1) {
				openNewAccount(user);
			} else if (input == 2) {
				System.out.println("Successfully logged out.");
				Terminal.landingScreen();
			} else if (input > 2 && input < user.getAccounts().size() + 3) {
				AccountModification.ModifyAccount(user.getAccounts().get(input - 3));
			}

			System.out.println("Invalid input.");
			validInput = false;

		}
	}

	public static void openNewAccount(User user) throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean validInput = false;

		while (!validInput) {
			System.out.println("Please select a new account type to open:");
			System.out.println("<1> Checking");
			System.out.println("<2> Savings");
			System.out.println("<3> Cancel");

			int input = scan.nextInt();
			scan.nextLine();

			validInput = true;

			switch (input) {
			case 1:
				System.out.println("Opening a new Checking account.");
				user.getAccounts().add(new Account(user, AccountType.Checking));
				break;
			case 2:
				System.out.println("Opening a new Savings account.");
				user.getAccounts().add(new Account(user, AccountType.Savings));
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid input.");
				validInput = false;
				break;
			}
		}
		
		Terminal.UpdateDatabase();
		beginAccountManagement(user);
	}

}
