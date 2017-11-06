package com.revature.banking;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class AccountModification {

	public static void ModifyAccount(Account account) throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean validInput = false;
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		while (!validInput) {
			System.out.println(
					"Please select an option for: " + account.getType() + "[" + nf.format(account.getBalance()) + "]");
			System.out.println("<1> Deposit");
			System.out.println("<2> Withdraw");
			System.out.println("<3> Delete Account");
			System.out.println("<4> Cancel");

			int input = scan.nextInt();
			scan.nextLine();

			validInput = true;

			if (input == 1 || input == 2) {
				boolean validDouble = false;
				double amount = 0;
				while (!validDouble) {
					try {
						System.out.println("Enter amount: ");
						validDouble = true;
						amount = scan.nextDouble();
						scan.nextLine();

					} catch (Exception e) {
						validDouble = false;
					}
				}

				if (input == 1)
					account.deposit(amount);
				else if (input == 2)
					account.withdraw(amount);
			}

			else if (input == 3) {
				System.out.println("Account deleted.");
				account.getOwner().getAccounts().remove(account);
				Terminal.UpdateDatabase();
			}

			// Return back to the main User screen.
			AccountManagement.beginAccountManagement(account.getOwner());
		}
	}

}
