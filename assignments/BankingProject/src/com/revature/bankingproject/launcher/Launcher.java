package com.revature.bankingproject.launcher;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankingproject.account.Account;
import com.revature.bankingproject.account.AccountCreateOrDestroy;
import com.revature.bankingproject.account.AccountDepositOrWithdraw;
import com.revature.bankingproject.account.AccountView;
import com.revature.bankingproject.files.FileHandler;
import com.revature.bankingproject.login.LoginHandler;
import com.revature.bankingproject.tools.InputValidator;
import com.revature.bankingproject.tools.UserTools;
import com.revature.bankingproject.user.Admin;
import com.revature.bankingproject.user.User;

public class Launcher {
	private static Logger log = Logger.getRootLogger();
	private static List<User> users;
	private static LoginHandler userTools = new LoginHandler();
	private static Scanner scan = new Scanner(System.in);
	private static AccountCreateOrDestroy makeRemoveAccount = new AccountCreateOrDestroy();
	private static AccountDepositOrWithdraw addRemoveFromAccount = new AccountDepositOrWithdraw();

	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		log.info("Loading");
		try {
			users = FileHandler.loadSerializedFile();
			int maximumAccountID = 1;
			for (User user : users) {
				for (Account acc : user.getAccounts()) {
					if (acc.getId() >= maximumAccountID) {
						maximumAccountID = acc.getId();
						log.debug("Increasing maximumAccountID to: " + maximumAccountID);
						maximumAccountID++;
					}
				}
			}
			Account.userIdCount = maximumAccountID;
		} catch (IOException e) {
			log.warn("Unable to load from file.  Resetting users List");
			users = new LinkedList<>();
			new Admin(users);
			log.info("Only user is Admin");
		}
		while (true) {
			User currentUser = userTools.userLandingPage(users);
			if (currentUser == null) {
				log.info("User has quit");
				System.out.println("Have a wonderful day!");
				FileHandler.saveSerializedFile(users);
				return;
			} else if (UserTools.isAdmin(currentUser)) {
				log.debug("user is ADMIN");
				launcher.adminMainPage();

			} else {
				log.debug("user is not ADMIN");
				launcher.mainPage(currentUser);
			}
		}

	}

	// primary view and portal for handling the main page
	public void mainPage(User currentUser) {
		boolean validInput;
		String inputString = "";
		int input;
		do {
			do {
				System.out.println("Welcome " + currentUser.getName() + "! How may we assist you today?");
				System.out.println("1. View Accounts");
				System.out.println("2. Withdraw/Deposit");
				System.out.println("3. Add/Remove Accounts");
				System.out.println("4. Logout");
				if (scan.hasNextLine())
					inputString = scan.nextLine();
				validInput = InputValidator.mainPageValidInput(inputString);
			} while (!validInput);
			input = Integer.parseInt(inputString);
			switch (input) {
			case (1):
				AccountView.viewAccounts(currentUser.getAccounts(), false);
				break;
			case (2):
				addRemoveFromAccount.depositOrWithdraw(currentUser.getAccounts(), scan);
				FileHandler.saveSerializedFile(users);
				break;
			case (3):
				makeRemoveAccount.createOrDestroy(currentUser, scan);
				FileHandler.saveSerializedFile(users);

				break;
			case (4):
				return;
			}
		} while (input != 4);
	}

	private void adminMainPage() {
		String inputString = null;
		int input;
		boolean validInput;
		do {
			do {
				System.out.println("Hello sir");
				System.out.println("1. See all Accounts");
				System.out.println("2. Approve New Accounts");
				System.out.println("3. Remove User");
				System.out.println("4. Logout");
				if (scan.hasNextLine())
					inputString = scan.nextLine();
				validInput = InputValidator.mainPageValidInput(inputString);
			} while (!validInput);
			input = Integer.parseInt(inputString);
			switch (input) {
			case (1):
				Admin.viewAllAccounts(users, scan);
				break;
			case (2):
				input = Admin.deFlagUsers(users, scan);
				FileHandler.saveSerializedFile(users);
				break;
			case (3):
				input = Admin.removeUser(users, scan);
				FileHandler.saveSerializedFile(users);
				break;
			case (4):
				break;
			}
		} while (input != 4);
	}
}