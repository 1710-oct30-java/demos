package com.revature.bankingproject.account;

import java.util.List;

public class AccountView {
	// Primary method to view all accounts
	public static void viewAccounts(List<Account> accounts, boolean adminIsChecking) {
		if (adminIsChecking && !accounts.isEmpty()) {
			accounts.stream().forEach(AccountView::printAccount);
		} else if (accounts.isEmpty()) {
			System.out.println("I'm sorry you don't seem to have any Accounts with us");
			return;
		} else {
			System.out.println("Here are your Accounts:");
			accounts.stream().forEach(AccountView::printAccount);
		}
	}

	// Method that prints out an account
	private static void printAccount(Account acc) {
		System.out.println("*" + acc.getType() + "* *" + acc.getId() + "*");
		System.out.println("Balance: " + acc.getBalance());
	}

}
