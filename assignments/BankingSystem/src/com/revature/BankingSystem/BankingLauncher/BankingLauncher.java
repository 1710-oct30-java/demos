package com.revature.BankingSystem.BankingLauncher;

import com.revature.BankingSystem.BankDataManagement.UserFile;
import com.revature.BankingSystem.BankDataManagement.UserList;

import com.revature.BankingSystem.BankingUI.MenuControl;

public class BankingLauncher {
	static UserList userList;

	public static void main(String[] args) {
		//master admin: root
		//password : password
		userList = UserFile.loadUserList();

		MenuControl menuControl = new MenuControl(userList);
		menuControl.mainMenu();
		UserFile.saveUserList(userList);
	}

}
