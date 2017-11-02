package com.revature.BankingSystem.BankingUI;

import java.util.ArrayList;

import com.revature.BankingSystem.BankClasses.*;

public class AccountManager extends UIElement {
	/*
	 * UI for managing a user's accounts
	 */
	private ClientUser currUser;

	public AccountManager(ClientUser currAcc) {

		super();
		currUser = currAcc;
	}

	public void AccounManagment() {
		// general menu options
		boolean accManageFlag = true;

		do {

			System.out.println("\n1 - Deposit into account" + "\n2 - Withdraw from account" + "\n3 - Create new account"
					+ "\n4 - Teriminate exsiting account" + "\n5 - Transfer Funds" + "\n6 - Accounts Overview"
					+ "\n0 - Exit account management\n");
			int userMenu;
			if (currUser.getAccounts().size() != 0) {
				userMenu = getUIn().getInt(0, 6);
			} else {
				do {
					System.out.println("No accounts for this user.\nCan only create an account or exit.");

					userMenu = getUIn().getInt(0, 6);
				} while ((userMenu != 0 && userMenu != 3));
			}

			switch (userMenu) {
			case 0:
				accManageFlag = false;
				break;
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				create();
				break;
			case 4:
				destroy();
				break;
			case 5:
				transfer();
				break;
			case 6:
				overview();
				break;
			default:
				break;
			}

		} while (accManageFlag);

	}

	private void deposit() {
		// deposit money into an account
		Account acc = chooseAccount();

		System.out.println("Amount to deposit: ");
		double amount = getUIn().getDouble(true);
		acc.setBalance(acc.getBalance() + amount);
		System.out.println(acc);
	}

	private void withdraw() {
		// withdraw money from an account. Can't go negative
		Account acc = chooseAccount();

		System.out.println("Amount to withdraw: ");
		double amount = getUIn().getDouble(true);
		if (acc.getBalance() - amount >= 0.0) {
			acc.setBalance(acc.getBalance() - amount);

			System.out.println("New Balance: " + acc.getBalance());
		} else {

			System.out.println("Cannot have negative balance");
		}

	}

	private void create() {
		// create and add an account
		System.out.println("Type of Account: ");
		String type = getUIn().getWord();

		System.out.println("Initial balance: ");
		double b = getUIn().getDouble(true);
		currUser.addAccount(type, b);

		System.out.println(currUser.getAccounts().get(currUser.getAccounts().size() - 1) + " Succesfully created");
	}

	private void destroy() {
		// delete an account (only when no money in it; Don't burn money!)
		Account acc = chooseAccount();
		if (acc.getBalance() == 0) {

			System.out.println("Account destoryed");
			currUser.getAccounts().remove(acc);
		} else {

			System.out.println("Can only terminate account with 0 balence");
		}
	}

	private void transfer() {
		// transfer money between user accounts
		System.out.println("Origin of transfer: ");
		Account acc1 = chooseAccount();

		System.out.println("Destination of transfer: ");
		Account acc2 = chooseAccount();

		System.out.println("Amount to transfer: ");
		double amount = getUIn().getDouble(true);

		if (acc1.getBalance() - amount >= 0.0) {
			acc1.setBalance(acc1.getBalance() - amount);
			acc2.setBalance(acc2.getBalance() + amount);
			System.out.println(acc1 + "\n" + acc2);

		} else {

			System.out.println("Cannot have negative balance");
		}

	}

	private void overview() {
		// display accounts and their info
		ArrayList<Account> userAcc = currUser.getAccounts();

		System.out.println("Accounts: ");
		for (int i = 0; i < userAcc.size(); i++) {
			System.out.println(userAcc.get(i));
		}
	}

	private Account chooseAccount() {
		// choose one of your accounts
		ArrayList<Account> userAcc = currUser.getAccounts();

		System.out.println("Choose account to manage: ");
		for (int i = 0; i < userAcc.size(); i++) {
			System.out.println("" + (i + 1) + " - " + userAcc.get(i));
		}

		int userMenu = getUIn().getInt(1, userAcc.size()) - 1;

		return userAcc.get(userMenu);
	}

}
