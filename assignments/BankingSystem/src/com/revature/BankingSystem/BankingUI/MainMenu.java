package com.revature.BankingSystem.BankingUI;

import com.revature.BankingSystem.BankClasses.User;

public class MainMenu extends UIElement {

	public MainMenu() {
		super();
	}

	public int mainMenu(User currUser) {
		System.out.println("\n1 - Manage Accounts" + "\n0 - Log Out" + "\n-1 - Exit\n");
		return getUIn().getInt(-1, 1);
	}
}
