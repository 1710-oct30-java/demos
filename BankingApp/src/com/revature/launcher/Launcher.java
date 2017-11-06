package com.revature.launcher;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.utility.Serializer;

public class Launcher {
	private static Serializer<List<User>> userListSerializer = new Serializer<>();
	private static Serializer<List<Account>> accountListSerializer = new Serializer<>();
	
	// Needed for inputs
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// List of the users
		List<User> userList = new ArrayList<User>();

		// See if the users file exists
		File tmpDir = new File("users.txt");
		if (!tmpDir.exists()) {
			// if it doesn't, create it
			try {
				tmpDir.createNewFile();
				System.out.println("No User database found. \nNew User database created, Creating a defaut Admin.");
				//Just making sure the grader knows the default
				System.out.println("Default Admin Usr: Admin, Pass: Password");
				
				//Default Admin's username is Admin and the Password is Password
				User admin = new User("", "Admin", "", "");
				admin.setPassword("Password");
				admin.setAdmin(true);
				admin.setApproval(true);
				userList.add(admin);
				userListSerializer.writeObject(userList, "users.txt");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		

		// See if the accounts file exists
		File tmpDir2 = new File("accounts.txt");
		if (!tmpDir2.exists()) {
			// if it doesn't, create it and populate it with a default account
			try {
				tmpDir2.createNewFile();
				System.out.println("No Accounts database found. \nNew Accounts database created.");
				Account accountPrime = new Account("", 0, "", 0);
				List<Account> accountPrimus = new ArrayList<Account>();
				accountPrimus.add(accountPrime);
				accountListSerializer.writeObject(accountPrimus, "accounts.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Begin basic interface
		boolean on = true;
		while (on) {
			userList = userListSerializer.readObject("users.txt");
			
			// User input
			System.out.println("****************************************************************");
			System.out.println("Enter Username/Email:");
			System.out.println("(Enter 'Register' to create an account)");
			System.out.println("(Enter esc to end)");

			String userIn = input.nextLine().trim();

			// Begin new user registration
			if (userIn.toLowerCase().equals("register")) {
				createUser(false);
			}
			
			else if (userIn.toLowerCase().equals("esc")) {
				on = false;
			}

			// Login
			else {
				boolean found = false;
				for (User ele : userList) {
					if(!found) {
						// if the input matches a username or email, check to see if it is approved and then ask for a password
						if ((ele.getUsername().equals(userIn)) || (ele.getEmail().equals(userIn))) {
							if(ele.isApproved()) {
								System.out.println("Enter Password:");
								String password = input.nextLine().trim();
								
								//Turn the password into a hash
								java.security.MessageDigest md;
								try {
									md = java.security.MessageDigest.getInstance("MD5");
									md.update(password.getBytes());
									byte[] bytes = md.digest();
									StringBuilder sb = new StringBuilder();
									for(int i=0; i< bytes.length ;i++)
							        {
							            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
							        }
									
							        //Get complete hashed password in hex format
									password = sb.toString();
								} catch (NoSuchAlgorithmException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println(password);
								System.out.println(ele.getPassword());
								
								if(password.equals(ele.getPassword())) {
									//the username and password are correct, so now it's time to load up the next interface, one for
									//regualr users, and one for admins
									if(ele.isAdmin()) {
										adminInterface(ele);
									}
									else {
										userInterface(ele);
									}
									
								}
								else {
									System.out.println("Incorrect Password");
								}
							}
							else {
								System.out.println("Your account is not Active, please wait for approval or contact an Admin.");
								found = true;
							}
						}
					}
				}
				// if the username/email doesn't exist give an error and let them try again
				if(!found) {
					System.out.println("Username/Email not found");
				}
			}
		}
	}

	public static void createUser(boolean admin) {
		System.out.println("**********************************************************");
		
		boolean done = false;
		User newUser = new User();
		List<User> userList = userListSerializer.readObject("users.txt");

		// this is used to create the default admin
		newUser.setAdmin(admin);
		newUser.setApproval(admin);

		// this loop will allow the User to re-enter any wrongfully input information
		// at the end of the process
		while (!done) {
			// username input and loop to make sure it's not already taken
			boolean nameTest = true;
			while (nameTest) {
				nameTest = false;
				System.out.println("Enter your desired Username:");
				newUser.setUsername(input.nextLine().trim());
				for (User ele : userList) {
					if (ele.getUsername().equals(newUser.getUsername())) {
						nameTest = true;
						System.out.println("Username already taken");
					}
				}
			}

			// email input and loop to make sure it's not already taken
			boolean emailTest = true;
			while (emailTest) {
				emailTest = false;
				System.out.println("Enter your email:");
				newUser.setEmail(input.nextLine().trim());
				for (User ele : userList) {
					if (ele.getEmail().equals(newUser.getEmail())) {
						emailTest = true;
						System.out.println("Email is already in use");
					}
				}
			}

			System.out.println("Enter your name:");
			newUser.setName(input.nextLine().trim());
			System.out.println("Enter your desired Password:");
			newUser.setPassword(input.nextLine().trim());

			// check the info with the user
			boolean done2 = false;
			while (!done2) {
				System.out.println("\n" + newUser.toString());
				System.out.println("Is the above information correct? (y/n)");
				String user = input.nextLine().trim().toLowerCase();
				if (user.equals("y") || user.equals("yes")) {
					done = true;
					done2 = true;
				} else if (user.equals("n") || user.equals("no")) {
					done2 = true;
				}
			}
		}
		// update the users file with the new user
		userList.add(newUser);
		userListSerializer.writeObject(userList, "users.txt");

	}
	
	//The actual user interface that allows the user to view and manipulate accounts, and to log out
	private static void userInterface(User userObj) {		
		System.out.println("**********************************************");
		boolean loggedIn = true;
		while (loggedIn) {
			//open the accountlist
			List<Account> accountList = new ArrayList<Account>(accountListSerializer.readObject("accounts.txt"));
			List<Account> userAccountList = new ArrayList<Account>();
			//pull the user's accounts
			for(Account ele: accountList) {
				if(ele.getOwner().equals(userObj.getName())) {
					userAccountList.add(ele);
				}
			}
			
			//Print out the user options
			System.out.println("Please Select An Option:");
			System.out.println("  (1)View Accounts");
			System.out.println("  (2)Deposit/Withdraw");
			System.out.println("  (3)Create/Delete Accounts");
			System.out.println("  (4)Logout");
			
			switch(input.nextLine()) {
			case "1":
				System.out.println(userAccountList.toString());
				break;
			case "2":
				selectAccount(accountList, userAccountList, 1);
				break;
			case "3":
				createDelete(accountList, userAccountList, userObj);
				break;
			case "4":
				System.out.println("******************************************************************");
				loggedIn = false;
				break;
			default:
				System.out.println("Invaild selection, please enter a number between 1 and 4");
				break;
			}
		}
	}
	
	//Admin interface, with more options than the OG user one
	private static void adminInterface(User adminObj) {
		System.out.println("******************************************");
		boolean loggedIn = true;
		while (loggedIn) {
			List<User> userList = userListSerializer.readObject("users.txt");
			//open the accountlist
			List<Account> accountList = new ArrayList<Account>(accountListSerializer.readObject("accounts.txt"));
			List<Account> userAccountList = new ArrayList<Account>();
			//pull the user's accounts
			for(Account ele: accountList) {
				if(ele.getOwner().equals(adminObj.getName())) {
					userAccountList.add(ele);
				}
			}
			
			//Print out the user options
			System.out.println("Please Select An Option:");
			System.out.println("  (1)View Personal Accounts");
			System.out.println("  (2)Deposit/Withdraw");
			System.out.println("  (3)Create/Delete Personal Accounts");
			System.out.println("  (4)View All Accounts");
			System.out.println("  (5)Modify User Accounts");
			System.out.println("  (6)Create New User");
			System.out.println("  (7)Logout");
			
			switch(input.nextLine()) {
			case "1":
				System.out.println(userAccountList.toString());
				break;
			case "2":
				selectAccount(accountList, userAccountList, 1);
				break;
			case "3":
				createDelete(accountList, userAccountList, adminObj);
				break;
			case "4":
				System.out.println(accountList.toString());
				break;
			case "5":
				//Select users to modify
				selectUser(userList);
				break;
			case "6":
				createUser(false);
				break;
			case "7":
				System.out.println("******************************************************************");
				loggedIn = false;
				break;
			default:
				System.out.println("Invaild selection, please enter a number between 1 and 7");
				break;
			}
		}	
	}

	//Select users
	private static void selectUser(List<User> userList) {
		System.out.println("**************************************");
		
		boolean done = false;
		while (!done) {
			System.out.println(userList.toString());
			System.out.println("Enter the name of the user you would like to modify or enter 'esc' to exit:");
			String adminInput = input.nextLine().trim();
			if(adminInput.equals("esc")) {
				done = true;
			}
			else {
				boolean found = false;
				for(User ele : userList) {
					if (ele.getName().equals(adminInput)) {
						found = true;
						modUser(userList, ele);
					}
				}
				if(!found) {
					System.out.println("Invaild Input");
				}
			}
		}
		
		System.out.println("**************************************");
	}
	
	//Modify users (activate, deactivate, toggle admin)
	private static void modUser(List<User> userList, User user) {
		System.out.println("**************************************");
		
		boolean done = false;
		while(!done) {
			System.out.println(user.toString());
			System.out.println("Choose an Action:");
			System.out.println("  (1)Toggle Activation Status");
			System.out.println("  (2)Toggle Admin Status");
			System.out.println("  (3)Save & Exit");
			
			switch(input.nextLine().trim()) {
			case "1":
				user.setApproval(!user.isApproved());
				break;
			case "2":
				user.setAdmin(!user.isAdmin());
				break;
			case "3":
				done = true;
				userListSerializer.writeObject(userList, "users.txt");
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		}
		
		System.out.println("**************************************");
	}
	
	//account selection interface that then passes to depositWithdraw or deletes it based on option
	private static void selectAccount(List<Account> accountList, List<Account> userAccountList, int option) {
		System.out.println("***********************************");
		//Check to make sure they actually have an account
		if (!userAccountList.isEmpty()) {
			boolean accountSelected = false;
			
			//Loop until they correctly select an account
			while(!accountSelected) {
				System.out.println("Please Select an account (from their ID):");
				System.out.println("Input 0 to cancel:");
				System.out.println(userAccountList.toString());
				Integer usrIn = Integer.parseInt(input.nextLine().trim());
				
				//cancel out
				if (usrIn == 0) {
					accountSelected = true;
					System.out.println("*******************************************");
				}
				else {
					for(Account ele : userAccountList) {
						//A correct account is chosen
						if (ele.getId() == usrIn) {
							accountSelected = true;
							System.out.println("**************************************************");
			
							//passes to next method depending on option
							switch(option) {
							//Deposit/Withdraw
							case 1:
								depositWithdraw(ele);
								break;
							//Delete Account
							case 2:
								userAccountList.remove(ele);
								accountList.remove(ele);
								accountListSerializer.writeObject(accountList, "accounts.txt");
								break;
							}
							
						}
					}
				}
				
				if(!accountSelected) {
					System.out.println("Invalid ID input");
				}
			}
		}
		//reject them if they don't have any accounts yet
		else {
			System.out.println("No accounts found to modify, Please create an account first");
		}
	}
	
	private static void depositWithdraw(Account ele) {
		System.out.println("**********************************************************");
		boolean done = false;
		while (!done) {
			System.out.println("Please Select an Action:");
			System.out.println("  (1) Deposit");
			System.out.println("  (2) Withdraw");
			System.out.println("  (3) Cancel");
			
			switch(input.nextLine()) {
			case "1":
				System.out.println("Current balance: " + ele.getAmount());
				System.out.println("How much would you like to deposit?");
				ele.setAmount(ele.getAmount() + Double.parseDouble(input.nextLine().trim()));
				break;
			case "2":
				System.out.println("Current balance: " + ele.getAmount());
				System.out.println("How much would you like to withdraw?");
				ele.setAmount(ele.getAmount() - Double.parseDouble(input.nextLine().trim()));
				break;
			case "3":
				done = true;
				System.out.println("*************************************************");
				break;
			default:
				System.out.println("Invaild Input (type 1, 2, or 3)");
				break;
			}
		}
	}

	private static void createDelete(List<Account> accountList, List<Account> userAccountList, User user) {
		System.out.println("********************************************************************");
		boolean done = false;
		while (!done) {
			System.out.println("Please Select an Action:");
			System.out.println("  (1) Create Account");
			System.out.println("  (2) Delete Account");
			System.out.println("  (3) Cancel");
			
			switch(input.nextLine()) {
			
			//Create a new account
			case "1":
				Account newAcc = new Account();
				//Set known information
				accountList.get(0).setId(accountList.get(0).getId()+1);
				newAcc.setId((accountList.get(0).getId()));
				newAcc.setOwner(user.getName());
				
				//Set type
				boolean done2 = false;
				while(!done2) {
					System.out.println("What type of account would you like to open?");
					System.out.println("  (1) Checking");
					System.out.println("  (2) Savings");
					switch (input.nextLine().trim()) {
					case "1":
						done2 = true;
						newAcc.setType("Checking");
						break;
					case "2":
						done2 = true;
						newAcc.setType("Savings");
						break;
					default:
						System.out.println("Invaild Input");
						break;
					}
				}
				
				//Set Amount
				System.out.println("How much would you like to Deposit?");
				newAcc.setAmount(Double.parseDouble(input.nextLine().trim()));
				
				//Update the data file
				userAccountList.add(newAcc);
				accountList.add(newAcc);
				accountListSerializer.writeObject(accountList, "accounts.txt");
				break;
				
				//pass to select account with the delete option
			case "2":
				selectAccount(accountList, userAccountList, 2);
				break;
				
				//cancel out of the operation
			case "3":
				done = true;
				System.out.println("**************************************************");
				break;
			default:
				System.out.println("Invaild Input (type 1, 2, or 3)");
				break;
			}
		}
	}
}


