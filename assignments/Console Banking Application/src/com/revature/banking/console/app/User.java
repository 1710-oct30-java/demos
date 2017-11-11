package com.revature.banking.console.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	private static final long serialVersionUID = 7435228404314918754L;
	private String userName;
	private String userPassword;
	private List<BitcoinWallet> userAccounts;

	public User(String username, String password) {
		this.userName = username;
		this.userPassword = password;
		this.userAccounts = new ArrayList<BitcoinWallet>();
	}

	public String getAccountDetails() {
		StringBuffer buffer = new StringBuffer("");

		for (int i = 0; i < userAccounts.size(); i++) {
			BitcoinWallet wallet = userAccounts.get(i);
			buffer.append("[" + (i + 1));
			buffer.append("] " + wallet.getWalletType() + " | $ " + wallet.getWalletBalance() + "\n");
		}
		
		return buffer.toString();
	}

	public boolean testPassword(String inputPassword) {
		return userPassword.equals(inputPassword);
	}

	public int numAccounts() {
		return userAccounts.size();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<BitcoinWallet> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<BitcoinWallet> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", userAccounts=" + userAccounts + "]";
	}
}