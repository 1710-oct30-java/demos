// Author: Micah West
// Date Started: 11/01/2017
// Date Finished: --/--/----
// Purpose: Simulate a simple bank system.
// [Sample I/O not provided.]

package com.revature.banksoftware;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class _BankMain {
	
	final static String USERS_FILE = "userData.txt";
	
	public static void main(String[] args) {
		
		File usersFile = new File(USERS_FILE);
		
		Scanner sysIn = new Scanner(System.in);
		
		// Define the data structures being used.
		Set<String> keySet;
		Map<String, User> usersMap = new HashMap<String, User>();
		Serializer<Map<String, User>> userSerializer = new Serializer<Map<String, User>>();
		
		boolean closeSystem = false;
		
		// Load user file OR create admin user if none is found.
		if(!usersFile.exists()) {
			
			System.out.println("No users saved, creating admin user with default password.");
			User admin = new User("admin@banking.rev", "admin", Passwords.hashPassword("password"));
			usersMap.put(admin.getUserName(), admin);
			
			userSerializer.writeObject(usersMap, USERS_FILE);
		}
		else {
			
			// Load user file.
			System.out.println("Loading user data file...");
			usersMap = userSerializer.readObject(USERS_FILE);
			
		}
		
		System.out.println("Loading complete.\n"
						 + "Users available: ");
		
		keySet = usersMap.keySet();
		
		for(String userName: keySet) {
			
			System.out.println("\t" + userName);
		}
		
		// System initialization complete.
		// User interface routines start here.
		
		// Honestly this entire system could have been optimized to use an implementation of multi-branched
		// trees, but... I couldn't quite get that to function within the time frame I wanted to.
		// This method was completed first and it functions. I just expect that better implementations
		// that make proper use of objects are likely used within our class.
		
		while(!closeSystem) {
			
			String inputCommand;
			
			String inputName;
			String inputPassword;
			String inputEmail;
			
			String inputAccountType;
			double inputAmount;
			
			User currentUser = null;
			
			
			System.out.println("\nWelcome! What would you like to do?");
			System.out.println("[1] Log In\n"
							 + "[2] Register New User\n"
							 + "[3] Exit");
			
			inputCommand = sysIn.nextLine();
			
			if(inputCommand.equals("1")) { // Log In
				
				System.out.println("\tLOG IN");
				
				System.out.print("\tUsername: ");
				inputName = sysIn.nextLine();
				
				if(usersMap.containsKey(inputName)) { // check if input user exists
					
					System.out.print("\tPassword: ");
					inputPassword = Passwords.hashPassword(sysIn.nextLine());
					
					if(usersMap.get(inputName).checkPassword(inputPassword)) {
						
						currentUser = usersMap.get(inputName);
						
						while(currentUser != null) { // if currentUser is null, then no user is logged in.
							
							System.out.println("\tHello, " + currentUser.getUserName() + ". What would you like to do today?");
							
							// If a user has the admin email, they are an admin.
							if(currentUser.getEmailAddress().equals("admin@banking.rev")) {
								
								System.out.println("\t[1] View All Accounts\n"
												 + "\t[2] Approve Pending Accounts\n"
												 + "\t[3] Log Out");
								
								inputCommand = sysIn.nextLine();
								
								if(inputCommand.equals("1")) { // View all accounts.
									
									keySet = usersMap.keySet();
									for(String key: keySet) {
										
										User person = usersMap.get(key);
										
										System.out.println("\tUser " + person.getUserName() + " has " + person.countAccounts() + " accounts.");
										System.out.println(person.getAccountDetails());
										
									} // end for each key in usersMap
									
								} // end if admin command is list users
								
								else if(inputCommand.equals("2")) { // Approve pending accounts.
									
									inputCommand = null;
									
									System.out.println("\tAccounts pending approval:");
									
									List<User> pendingUsers = new ArrayList<User>();
									List<Account> pending = new ArrayList<Account>();
									keySet = usersMap.keySet();
									
									for(String key: keySet) {
										
										User person = usersMap.get(key);
										int index = 0;
										
										for(int i = 0; i < person.getAccounts().size(); i++) {
											
											Account acc = person.getAccounts().get(i);
											if(!acc.getApproved()) {
												
												pending.add(acc);
												pendingUsers.add(person);
												System.out.println("\t\t [" + (index+1) + "] " + person.getUserName() + " | " + acc.getType());
												index++;
											}
										}
									}
									
									if(pending.size() > 0) {
										
										System.out.println("\n\tEnter the indexes shown to approve specific accounts, 0 for all, and -1 to go back.");
										inputCommand = sysIn.nextLine();
										
										while(!inputCommand.contains("-1") && pending.size()>0) {
											
											int commandInts[];
											int index = 0;
											
											if(inputCommand.contains("0")) { // the user approves all the accounts.
												
												commandInts = new int[pending.size()];
												
												for(int i = 0; i < pending.size(); i++) {
													
													commandInts[i] = i;
												}
											}
											else { // the user approves only specific accounts.
												
												commandInts = new int[inputCommand.split(" ").length];
												
												for(String num: inputCommand.split(" ")) {
													
													commandInts[index] = Integer.parseInt(num)-1;
													index++;
												}
												
												Arrays.sort(commandInts);
											}
											
											// Run through the accounts ready to be approved, and approve them.
											for(int i = commandInts.length-1; i >= 0; i--) {
												
												System.out.print(i + " " + commandInts[i] + " ");
												pending.get(commandInts[i]).approve();
												
												System.out.println("\tApproved account " + commandInts[i] + " of type " + pending.get(commandInts[i]).getType());
												
												pending.remove(commandInts[i]);
												pendingUsers.remove(commandInts[i]);
											}
											
											if(pending.size() > 0) { // There are remaining accounts. Ask if the user wishes to approve more accounts.
												
												System.out.println("\tAccounts still pending approval:");
												
												for(int i = 0; i < pending.size(); i++) {
													
													System.out.println("\t\t [" + (i+1) + "] " + pendingUsers.get(i).getUserName() + " | " + pending.get(i).getType());
												}
												
												System.out.println("\n\tEnter the indexes shown to approve specific accounts, 0 for all, and -1 to go back.");
												inputCommand = sysIn.nextLine();
											}
											
											else { // No remaining accounts, return to main menu.
												
												System.out.println("\n\tNo accounts pending approval. Returning to main menu.");
												inputCommand = "-1";
											}
											
										}
										
										System.out.println("\tReturning to previous menu.");
										userSerializer.writeObject(usersMap, USERS_FILE);
										
									} // End if there are pending accounts.
									
									else { // No accounts pending approval.
										
										System.out.println("\tThere were no pending accounts. Returning to main menu.\n");
									}
									
								} // end if admin command is approve pending accounts.
								
								else if(inputCommand.equals("3")) { // Log out
									
									System.out.println("\tLogging out, returning to main menu.");
									currentUser = null;
								} // end of log out command
								
								else { // invalid command.
									
									System.out.println("\tInvalid command entry \"" + inputCommand + "\". Please try again.");
								}
								
							} // end of admin login
							
							else { // normal user login
								
								System.out.println("\t[1] View My Accounts\n"
												 + "\t[2] Create New Account\n"
												 + "\t[3] Log Out");
								
								inputCommand = sysIn.nextLine();
								
								if(inputCommand.equals("1")) { // View my accounts.
									
									if(currentUser.countAccounts() > 0) {
										
										inputCommand = null;
										int commandNumber = -1;
										
										do {
											
											System.out.println("\n\tWhich account would you like to access? Type -1 to go back.");
											System.out.println("\tYou have " + currentUser.countAccounts() + " accounts.");
											System.out.println(currentUser.getAccountDetails());
											
											inputCommand = sysIn.nextLine();
											commandNumber = Integer.parseInt(inputCommand);
											
											if(commandNumber > -1 && commandNumber <= currentUser.countAccounts()) {
												
												do {
													
													Account acc = currentUser.getAccounts().get(commandNumber-1);
													System.out.println("\n\t\tSelected your " + acc.getType() + " account with a balance of $ " + acc.getBalance());
													System.out.println("\t\tWhat would you like to do with it?");
													System.out.println("\t\t[1] Deposit\n"
																	 + "\t\t[2] Withdraw\n"
																	 + "\t\t[3] Delete Account\n"
																	 + "\t\t[4] Go Back");
													
													inputCommand = sysIn.nextLine();
													
													if(inputCommand.equals("1")) {
														
														System.out.println("\t\tEnter how much money you wish to deposit.");
														System.out.print("\t\t: ");
														inputCommand = sysIn.nextLine();
														
														inputAmount = Double.parseDouble(inputCommand);
														
														acc.deposit(inputAmount);
														userSerializer.writeObject(usersMap, USERS_FILE);
													}
													
													else if(inputCommand.equals("2")) {
														
														System.out.println("\t\tEnter how much money you wish to withdraw.");
														System.out.print("\t\t: ");
														inputCommand = sysIn.nextLine();
														
														inputAmount = Double.parseDouble(inputCommand);
														
														acc.withdraw(inputAmount);
														userSerializer.writeObject(usersMap, USERS_FILE);
													}
													
													else if(inputCommand.equals("3")) { // Delete the account.
														
														System.out.println("\t\tAre you sure you wish to delete this account? Type your password to confirm.");
														System.out.print("\t\tPassword: ");
														
														inputCommand = Passwords.hashPassword(sysIn.nextLine());
														
														if(currentUser.checkPassword(inputCommand))
														{
															currentUser.getAccounts().remove(acc);
															inputCommand = null;
															
															System.out.println("\t\tAccount successfully deleted, returning to account menu.");
															userSerializer.writeObject(usersMap, USERS_FILE);
														}
														
													} // End of delete account.
													
													else if(inputCommand.equals("4")) {
														
														System.out.println("\t\tReturning to account menu.");
														inputCommand = null;
													}
													
													else {
														
														System.out.println("\t\tInvalid command entry \"" + inputCommand + "\". Please try again.");
													}
												}
												while(inputCommand != null);
											}
										}
										while(commandNumber > -1);
										
										userSerializer.writeObject(usersMap, USERS_FILE);
									}
									else {
										
										System.out.println("\tYou have no accounts. Returning to previous menu.");
									}
								} // End view my accounts.
								
								else if(inputCommand.equals("2")) {
									
									System.out.print("\tEnter an account type: ");
									inputAccountType = sysIn.nextLine();
									
									currentUser.getAccounts().add(new Account(inputAccountType, 0.0));
									System.out.println("\tAccount of type \"" + inputAccountType + "\" has been created.");
									System.out.println("\tPlease await administrator approval before making deposits.");
									
									userSerializer.writeObject(usersMap, USERS_FILE);
								}
								
								else if(inputCommand.equals("3")) { // Log out
									
									System.out.println("\tLogging out, returning to main menu.");
									currentUser = null;
								} // end of log out command
								
								else { // invalid command.
									
									System.out.println("\tInvalid command entry \"" + inputCommand + "\". Please try again.");
								}
							}
						} // End while user's logged in.
						
					} // End if password is correct
					else {// Password is incorrect
						
						// If password is incorrect, say that, and return to the main menu.
						System.out.println("\tInvalid password. Returning to main menu.");
					}
				}
				else {
					
					System.out.println("\tGiven username \"" + inputName + "\" not found. Returning to main menu.");
				}
			} // End if command is log in.
			
			
			else if(inputCommand.equals("2")) { // Register a new user.
				
				System.out.println("\tREGISTER NEW USER");
				
				// A username in the map is used as the key
				// This means that you cannot have more than one username.
				// To prevent redundancy, entering a unique username uses a do-while, with a check
				// to see if the user entered *something* on the previous iteration.
				// If the inputName field contains nothing (null), then there was no previous iteration.
				// If there is a string in the inputName field, the previous iteration must have failed
				// and the given username must already exist as a key.
				inputName = null;
				
				do {
					if(inputName == null) {
						System.out.println("\tPlease enter the username you would like to use.");
					}
					else {
						System.out.println("\tUsername \"" + inputName + "\" already in use. Please try again.");
					}
					
					System.out.print("\tUsername: ");
					inputName = sysIn.nextLine();
				}
				while(usersMap.containsKey(inputName));
				
				// Other information is not checked for uniqueness, it can just be placed in the map.
				System.out.print("\tPassword: ");
				inputPassword = Passwords.hashPassword(sysIn.nextLine());
				
				System.out.print("\tEmail Address: ");
				inputEmail = sysIn.nextLine();
				
				usersMap.put(inputName, new User(inputEmail, inputName, inputPassword));
				
				userSerializer.writeObject(usersMap, USERS_FILE);
				
				System.out.println("\tRegistration complete! Returning to main menu.");
				
			} // End while command is register new user.
			
			
			else if(inputCommand.equals("3")) {
				System.out.println("Thank you, goodbye.");
				closeSystem = true;
			}
			
			else { // None of the above commands were entered.
				System.out.println("Invalid command entry \"" + inputCommand + "\". Please try again.");
			}
			
		} // End while system is running.
		
		// Close the console Scanner.
		sysIn.close();
		
	}
	
}
