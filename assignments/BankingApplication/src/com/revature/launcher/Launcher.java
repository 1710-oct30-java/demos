package com.revature.launcher;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Serializer;
import com.revature.beans.User;

/*
 * Class to imulate the banking application. Gives the user options to the user to do something to their account.
 * Reads the serialized objects from the users.txt file and writes any changes to the same file.
 */
public class Launcher {
	private static List<User> users = new LinkedList<>();
	private static Serializer<List<User>> usersSerializer = new Serializer<>();
	private static Scanner input;
	private static User currentUser;

	public static void main(String[] args) {

		// read from serialized object
		users = usersSerializer.readObject("users.txt");

		/*
		 * User menu - the options that the user has 1. user can log in 2. user can view
		 * their existing accounts 3. user can deposit and withdraw from accounts 4.
		 * user can create or delete accounts 5. user can sign out
		 */
		System.out.println("Welcome");
		input = new Scanner(System.in);

		int option;

		do {
			System.out.println("Options: ");

			System.out.println("1. Log In");
			System.out.println("2. View Account");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Delete Account");
			System.out.println("6. Create Account");
			System.out.println("7. Sign Out");

			System.out.println("Enter an option: ");

			option = Integer.parseInt(input.nextLine());
			switch (option) {
			case 1:
				currentUser = logIn();
				break;
			case 2:
				viewAccount(currentUser);
				break;
			case 3:
				deposit(currentUser);
				usersSerializer.writeObject(users, "users.txt");
				break;
			case 4:
				withdraw(currentUser);
				usersSerializer.writeObject(users, "users.txt");
				break;
			case 5:
				deleteAccount(currentUser);
				usersSerializer.writeObject(users, "users.txt");
				break;
			case 6:
				createAccount(currentUser);
				usersSerializer.writeObject(users, "users.txt");
				break;
			case 7:
				signOut(currentUser);
				currentUser = null;
				break;
			default:
				System.out.println("Not an option");
				break;
			}

		} while (option != 0);
	}

	private static void signOut(User user) {
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			user.setLoogedIn(false);
			// System.out.println(users);
			System.out.println("Logged Out");
		}
	}

	/*
	 * deleteAccount - parameter User, returns nothing. Deletes an account from the
	 * user
	 */
	private static void deleteAccount(User user) {
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			Account account = null;
			if (user.getAccounts().size() > 1) {
				System.out.println("Enter the ID of account to delete: ");
				int accountId = Integer.parseInt(input.nextLine());
				for (int i = 0; i < user.getAccounts().size(); i++) {
					if (user.getAccounts().get(i).getId() == accountId) {
						account = user.getAccounts().get(i);
					}
				}
				// use the remove method to remove account
				user.getAccounts().remove(account);

			} else {
				//if user only has one account remove the user from the list of users
				account = user.getAccounts().get(0);
				users.remove(user);
			}
		}
		System.out.println("Deleted account");

	}

	/*
	 * Method to withdraw - parameter is a User and returns nothing
	 */

	private static void withdraw(User user) {
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			Account account = null;
			if (user.getAccounts().size() > 1) {
				System.out.println("Enter the ID of account to withdraw money from: ");
				int accountId = Integer.parseInt(input.nextLine());
				for (int i = 0; i < user.getAccounts().size(); i++) {
					if (user.getAccounts().get(i).getId() == accountId) {
						account = user.getAccounts().get(i);
					}
				}
			} else {
				account = user.getAccounts().get(0);
			}

			System.out.println("Enter amount of money to withdraw: ");
			double amount = Double.parseDouble(input.nextLine());
			account.withdraw(amount);
		}

	}

	/*
	 * Deposit Method - Get the user and accounts. If the user has more than one
	 * account ask the user to enter the id to the account that they would like to
	 * deposit to.
	 */
	private static void deposit(User user) {
		Account account = null;
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			if (user.getAccounts().size() > 1) {
				System.out.println("Enter the ID of account to deposit money to: ");
				int accountId = Integer.parseInt(input.nextLine());
				for (int i = 0; i < user.getAccounts().size(); i++) {
					if (user.getAccounts().get(i).getId() == accountId) {
						account = user.getAccounts().get(i);
					}
				}
			} else {
				account = user.getAccounts().get(0);
			}

			System.out.println("Enter amount of money to deposit: ");
			double amount = Double.parseDouble(input.nextLine());
			account.deposit(amount);
		}
	}

	/*
	 * Method to let an existing user create an account. Ask user for their name,
	 * username, email, and password. Create the new account
	 */
	private static void createAccount(User user) {
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			System.out.println("What type of accout would you like to create: \n " + "1. Checking \n 2. Savings");
			String accountType = "";
			int type = Integer.parseInt(input.nextLine());
			if (type == 1) {
				accountType = "Checking";
			} else {
				accountType = "Savings";
			}

			Account ac = new Account(0, accountType);
			user.getAccounts().add(ac);

			System.out.println("Account Created");
		}
	}

	/*
	 * Log in method - ask user for username and password if the username and
	 * password match to one of the users the user is returned
	 */
	public static User logIn() {
		String username;
		String password;
		System.out.print("Enter username: ");
		username = input.nextLine();
		System.out.print("Enter password: ");
		password = input.nextLine();

		if (!users.isEmpty()) {
			for (User user : users) {
				if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
					System.out.println("Logged In");
					user.setLoogedIn(true);
					return user;
				} else if (username.equals(user.getUsername()) && !password.equals(user.getPassword())) {
					System.out.println("Your password doesn't match");
				} else if (!username.equals(user.getUserEmail())) {
					System.out.println("Username does not exit");
					return null;
				}
			}
		} else {
			System.out.println("Account not found");
		}
		return null;
	}

	/*
	 * View method - Display information about the users account
	 */
	public static void viewAccount(User user) {
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			for (int i = 0; i < user.getAccounts().size(); i++) {
				System.out.println("Account ID: " + user.getAccounts().get(i).getId());
				System.out.println("Account Type: " + user.getAccounts().get(i).getType());
				System.out.println("Account Balance: " + user.getAccounts().get(i).getBalance());
			}
		}
	}
	
	/*
	 * Can use this method to initialize the file with serialized objects. 
	 */
	public void initializeFile() {
		Account ac = new Account(1000, "Savings");
		Account ac1 = new Account(5000, "Checking");
		Account ac2 = new Account(9000, "Savings");
		Account ac3 = new Account(20000.4, "Savings");
		List<Account> listAc = new LinkedList<>();
		List<Account> listAc1 = new LinkedList<>();
		List<Account> listAc2 = new LinkedList<>();
		List<Account> listAc3 = new LinkedList<>();
		listAc.add(ac);
		listAc1.add(ac1);
		listAc2.add(ac2);
		listAc3.add(ac3);
		users.add(new User("Rosario Rojas", "rojas73@gmail.com", "A#1", "rosariorojas", listAc));
		users.add(new User("Lidia Vidales", "lili@yahoo.com", "LoveDany#1", "liliVida", listAc1));
		users.add(new User("Robert Smith", "srobert@gmail.com", "GreenChair#1", "smithrobert", listAc2));
		users.add(new User("Jacob Adams", "jadams@yahoo.com", "ButterfliesFly#1", "jacobadams", listAc3));

		usersSerializer.writeObject(users, "users.txt");
		//System.out.println(users);
	}
}
