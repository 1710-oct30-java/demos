package com.revature.banklauncher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.User;

/*
 * Written by Austin Hearn
 */

public class BankLauncher {

	public static int menuInt = 0;
	public static int idNum = 1;
	public static double withdraw = 0.0;
	public static double deposit = 0.0;
	public static int currentId = 0;
	public static int newId = 0;
	public static Boolean exist = false;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username: ");
		String user = scanner.nextLine();
		System.out.println("Enter password: ");
		String pw = scanner.nextLine();

		try {
			FileInputStream pInput = new FileInputStream(
					"C:\\Users\\iaust\\eclipse-workspace\\Tampa-BankingProject\\resources\\user.properties");
			FileOutputStream fout = new FileOutputStream(
					"C:\\Users\\iaust\\eclipse-workspace\\Tampa-BankingProject\\src\\com\\revature\\banklauncher\\accountinfo");
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			Properties properties = new Properties();
			properties.load(pInput);

			String realPass = properties.getProperty(user);

			if (!pw.equals(realPass)) {
				System.out.println("Username or Password is incorrect");
				return;
			} else {
				System.out.println("Welcome back " + user);

				BankLauncher bl = new BankLauncher();
				User readUser = (User) bl.ReadObject();
				System.out.println(readUser);
				System.out.println("~~~~Main Menu~~~~");
				System.out.println("'1' to view accounts and account menu");
				System.out.println("'2' to logout");
				menuInt = scanner.nextInt();

				if (menuInt == 1) {

					System.out.println(readUser.accounts);
					System.out.println("~~~~Account Menu~~~~");
					System.out.println("'1' to withdraw from an account");
					System.out.println("'2' to deposit to an account ");
					System.out.println("'3' to create an account");
					System.out.println("'4' to delete an account");
					System.out.println("'5' to logout");
					menuInt = scanner.nextInt();

					for (Account b : readUser.accounts) {
						if (b.id > currentId) {
							currentId = b.id;
						}

					}
					newId = currentId + 1;

					switch (menuInt) {
					case 1:
						System.out.println("Enter the account id you wish to withdraw from");
						menuInt = scanner.nextInt();
						for (Account a : readUser.accounts) {
							if (a.id == menuInt) {
								System.out.println("Account is: " + " [" + a.owner + " " + a.type
										+ "] with balance of: " + a.balance);
								System.out.println("Please enter the amount you wish to withdraw:");
								withdraw = scanner.nextInt();
								if (withdraw > a.balance) {
									System.out.println("Withdraw amount is greater than current balance");
									System.out.println("Insufficient funds");
									break;
								} else {
									a.balance = a.balance - withdraw;
									System.out.println("You have successfully withdrawn: " + withdraw);
									System.out.println("Your new account balance is: " + a.balance);

									WriteObject.emptyFile();
									WriteObject.writeFile(readUser);
									break;
								}

							}

						}
						break;

					case 2:
						System.out.println("Enter the account id you wish to deposit to");
						menuInt = scanner.nextInt();
						for (Account a : readUser.accounts) {
							if (a.id == menuInt) {
								System.out.println("Account is: " + " [" + a.owner + " " + a.type
										+ "] with balance of: " + a.balance);
								System.out.println("Please enter the amount you wish to deposit:");
								deposit = scanner.nextInt();
								if (deposit > 0) {
									a.balance = a.balance + deposit;
									System.out.println("You have successfully deposited: " + deposit);
									System.out.println("Your new account balance is: " + a.balance);
									WriteObject.emptyFile();
									WriteObject.writeFile(readUser);
									break;
								} else {
									System.out.println("Deposit amount must be greater than 0");
									break;
								}

							}

						}
						break;

					case 3:
						System.out.println("Please select the type of account you wish to create");
						System.out.println("'1' for checking account");
						System.out.println("'2' for savings account");
						menuInt = scanner.nextInt();
						if (menuInt == 1) {
							System.out.println("Creating a new checking account for user: " + readUser.username);
							Account newAcc = new Account(readUser.username, "checking", 0.00, newId);
							System.out.println(
									"New checking account created for " + readUser.username + " with id = " + newId);
							readUser.accounts.add(newAcc);
							System.out.println("Account has been successfully added to your username with balance of: "
									+ newAcc.balance);
							WriteObject.emptyFile();
							WriteObject.writeFile(readUser);
							break;
						} else if (menuInt == 2) {
							System.out.println("Creating a new savings account for user: " + readUser.username);
							Account newAcc = new Account(readUser.username, "savings", 0.00, newId);
							System.out.println(
									"New savings account created for " + readUser.username + " with id = " + newId);
							readUser.accounts.add(newAcc);
							System.out.println("Account has been successfully added to your username with balance of: "
									+ newAcc.balance);
							/*
							 * 
							 * Update Serializable File
							 * 
							 */
							break;
						} else {
							System.out.println("Incorrect menu selection");
							break;
						}

					case 4:
						System.out.println("Current accounts: ");
						System.out.println(readUser.accounts);
						System.out.println("Please enter the account id you wish to delete");
						menuInt = scanner.nextInt();

						for (Account a : readUser.accounts) {
							if (menuInt == a.id) {
								System.out.println("Deleting: " + a);
								exist = true;
							}
						}
						if (exist == false)
							System.out.println("Account ID does not exist");
						break;

					case 5:
						System.out.println("Logging out user " + readUser.username);
						System.exit(1);

						WriteObject.emptyFile();
						WriteObject.writeFile(readUser);

					} // close switch

				} else {
					System.out.println("Now logging out...");
					System.exit(0);
				}

			}

			pInput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Object ReadObject() throws InvalidClassException {

		try {

			FileInputStream fileInput = new FileInputStream(
					"C:\\\\Users\\\\iaust\\\\eclipse-workspace\\\\Tampa-BankingProject\\\\src\\\\com\\\\revature\\\\banklauncher\\\\accountinfo.txt");
			ObjectInputStream ois = new ObjectInputStream(fileInput);
			Object bl = ois.readObject();

			return bl;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
