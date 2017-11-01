package com.revature.BankingSystem.BankingUI;

import com.revature.BankingSystem.BankClasses.ClientUser;
import com.revature.BankingSystem.BankClasses.User;
import com.revature.BankingSystem.BankDataManagement.UserList;

public class MenuControl {

	private User currentUser;
	UserList userList;

	private AccountManager accMan;
	private UserLogin uLogin;
	private MainMenu mm;

	public MenuControl(UserList uList) {
		uLogin = new UserLogin();

		userList = uList;
		currentUser = uLogin.login(userList);
		accMan = new AccountManager((ClientUser) currentUser);
	}

	public void mainMenu() {

		mm = new MainMenu();
		int userInput = 0;
		do {
			userInput = mm.mainMenu(currentUser);
			if (userInput != -1) {
				switch (userInput) {
				case 0:
					currentUser = uLogin.login(userList);
					break;
				case 1:
					accMan.AccounManagment();
					break;
				default:
					break;
				}
			}
		} while (userInput != -1);
	}

}
