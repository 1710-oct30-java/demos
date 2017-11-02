package com.revature.BankingSystem.BankingUI;

public class UIElement {
	private static UserInput uIn;
	/*
	 * base of user interfaces. all have user input.
	 */
	public UIElement() {
		uIn = new UserInput();
	}

	public UserInput getUIn() {
		return uIn;
	}
}
