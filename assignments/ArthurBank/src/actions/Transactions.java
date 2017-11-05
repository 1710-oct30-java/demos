package actions;

import java.io.IOException;

import objects.Account;

public class Transactions {

	public static double withdraw(String accountID, double wamount) throws IOException {

		// finds the account the user wants to withdraw from, subtracts the amount the
		// user wants to withdraw from the original amount, updates the account
		// information in accountList to match the new balance, returns the updates
		// balance for display

		double newAmount = 0;
		for (Account a : Login.accountData) {
			if (a.getaccID().equals(accountID)) {
				if (a.getBalance() - wamount >= 0) {
					newAmount = a.getBalance() - wamount;
					a.setBalance(newAmount);
					System.out.println("Your new balance is: " + newAmount);
				} else {
					System.out.println("Insufficient Funds");
				}
			}
		}
		UpdateAccount.update();

		return newAmount;

	}

	public static double deposit(String accountID, double damount) throws IOException {

		// finds the account the user wants to deposit into, adds the deposit amount to
		// the balance, updates the account information to match the new balance and
		// returns the new balance for display

		double newAmount = 0;
		for (Account a : Login.accountData) {
			if (a.getaccID().equals(accountID)) {
				newAmount = a.getBalance() + damount;
				a.setBalance(newAmount);
				System.out.println("Your new balance is: " + newAmount);
			}
		}
		UpdateAccount.update();
		return newAmount;

	}
}
