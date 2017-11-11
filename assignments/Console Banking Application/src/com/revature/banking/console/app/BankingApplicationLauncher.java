package com.revature.banking.console.app;

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class BankingApplicationLauncher {
	final static String userFile = "data.txt";

	public static void main(String[] args) {
		File userSheet = new File(userFile);
		Scanner sysIn = new Scanner(System.in);
		Set<String> keySet;
		Map<String, User> usersMap = new HashMap<String, User>();
		Serializer<Map<String, User>> userSerialize= new Serializer<Map<String, User>>();
		boolean terminate = false;

		if (!userSheet.exists()) {
			System.out.println("Default password = password.");
			User defaultUser = new User("Default", "password");
			usersMap.put(defaultUser.getUserName(), defaultUser);
			userSerialize.writeObject(usersMap, userFile);
		} //If the data sheet doesn't exist, create one and offer a default option 

		else {
			usersMap = userSerialize.readObject(userFile);
		} //if it does exist, populate our map with the details

		System.out.println("Accounts: ");
		keySet = usersMap.keySet();
		for (String userName : keySet) {
			System.out.println(userName);
		}

		while (!terminate) {
			String instruction;
			String userNameIn;
			String passwordIn;
			String accTypeIn;
			double amountIn;
			User currentUser = null;

			System.out.println("[1] Log In\n" + "[2] Register\n" + "[3] Quit");
			instruction = sysIn.nextLine();

			if (instruction.equals("1")) { // Log the user in after prompting for account credentials
				System.out.println("Username: ");
				userNameIn = sysIn.nextLine();

				if (usersMap.containsKey(userNameIn)) { // check if input user even exists first
					System.out.println("Password: ");
					passwordIn = sysIn.nextLine();

					if (usersMap.get(userNameIn).testPassword(passwordIn)) { //check the testPassword method to validate input credentials
						currentUser = usersMap.get(userNameIn); //edit the variable user we're logged into at any given time

						while (currentUser != null) { //the user is logged in to his/her account. Prompt for instructions and execute
							System.out.println("[1] View Accounts\n" + "[2] Make New Account\n" + "[3] Log Out");
							instruction = sysIn.nextLine();

							if (instruction.equals("1") && currentUser.numAccounts() >= 0) {//test and make sure the user has an account
									instruction = null;
									int inInstruction = -1;

									do {
										System.out.println("Select an account. If none exist or you want to go back, enter -1.");
										System.out.println(currentUser.getAccountDetails());
										instruction = sysIn.nextLine();
										inInstruction = Integer.parseInt(instruction); //get an int instruction from input

										if (inInstruction > -1 && inInstruction <= currentUser.numAccounts()) {

											do {
												BitcoinWallet acc = currentUser.getUserAccounts().get(inInstruction - 1);
												System.out.println("Selected " + acc.getWalletType() + " containing: " + acc.getWalletBalance() + " BTC");
												System.out.println("[1] Deposit\n" + "[2] Withdraw\n" + "[3] Delete Account\n" + "[4] Return");
												instruction = sysIn.nextLine();

												if (instruction.equals("1")) {
													System.out.println("Quantity to deposit: ");
													instruction = sysIn.nextLine();
													amountIn = Double.parseDouble(instruction);
													acc.depositToWallet(amountIn);
													userSerialize.writeObject(usersMap, userFile);
												} //user has deposited funds into the account

												else if (instruction.equals("2")) {
													System.out.println("Quantity to withdraw: ");
													instruction = sysIn.nextLine();
													amountIn = Double.parseDouble(instruction);
													acc.withdrawFromWallet(amountIn);
													userSerialize.writeObject(usersMap, userFile);
												} //user has withdrawn from their account. BitcoinWallet method guarantees no overdraw

												else if (instruction.equals("3")) {
													currentUser.getUserAccounts().remove(acc);
													instruction = null; //**reset the instruction or get stuck**
													userSerialize.writeObject(usersMap, userFile);
												} // User deleted the account. update the file and go back

												else if (instruction.equals("4")) {
													instruction = null;
												} //return to the main menu

												else {
													System.out.println("Bad input. One more try?: ");
												}
											} // end of do only after the user instruction is reset. return to main
											while (instruction != null);
											
										}
									} // out of the user account and going to main
									while (inInstruction > -1);
									
									userSerialize.writeObject(usersMap, userFile); //write to the file because the user is done
							} // End view my accounts.

							else if (instruction.equals("2")) { //edit bitcoin wallet to make this make sense
								System.out.println("Enter an account type (wallet -> checking | vault -> savings) If you want multiple, number your accounts. They are retrieved by name1");
								accTypeIn = sysIn.nextLine();
								currentUser.getUserAccounts().add(new BitcoinWallet(accTypeIn, 0.0));
								userSerialize.writeObject(usersMap, userFile); //account made. slap it in the file
							}

							else if (instruction.equals("3")) {
								System.out.println("Logging out, returning to main menu.");
								currentUser = null; //procs return to main with null for user
							} //The user logged out. Returning to main

							else {
								System.out.println("Invalid command entry. Try again.");
							} //all conditions missed. Something went wrong
						} //user is not logged in
					} //user put in an incorrect password. all loops skipped and returning to main

					else {
						System.out.println("Incorrect password");
					} //inform user they got the password wrong
				}//user didn't exist

				else {
					System.out.println("No such user");
				} //inform user the user doesn't exist 
			} // End if command is log in.

			else if (instruction.equals("2")) {
				userNameIn = null;

				do {
					if (userNameIn == null) {
						System.out.println("Please enter a new username");
					}
					else {
						System.out.println("Username exists. Try again");
					}

					System.out.println("Username: ");
					userNameIn = sysIn.nextLine();
				}
				while (usersMap.containsKey(userNameIn));
				
				System.out.println("Password: ");
				passwordIn = sysIn.nextLine();
				usersMap.put(userNameIn, new User(userNameIn, passwordIn));
				userSerialize.writeObject(usersMap, userFile); //user created. add it in the file
			} //new user registration complete. go back to main

			else if (instruction.equals("3")) {
				System.out.println("See you later!");
				terminate = true;
			}

			else {
				System.out.println("Your input managed to miss every single check condition. clearly you suck.");
			}
		} // User prompted for exit. Close out the scanner and we done
		sysIn.close();
	}
}