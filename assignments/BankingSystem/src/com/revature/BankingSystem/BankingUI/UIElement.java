package com.revature.BankingSystem.BankingUI;

public class UIElement {
	private static UserInput uIn;

	public UIElement() {
		uIn = new UserInput();
	}

	public UserInput getUIn() {
		return uIn;
	}
}
