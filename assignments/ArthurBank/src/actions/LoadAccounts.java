package actions;

import java.io.IOException;
import java.util.ArrayList;

import GUI.ActionsPage;
import objects.Account;

public class LoadAccounts {

	public static ArrayList<Account> acc = new ArrayList<Account>();

	public static void main(String[] args) throws IOException {
		
		// Loads the accounts in accountList.txt that the user owns into the current
		// instance of banking

		if (Login.accountData.size() != 0) {
			for (Account a : Login.accountData) {
				if (a.getUserID().equals(Login.user.getUserID())) {
					acc.add(a);
				}
			}

		} else {
			System.out.println("No Accounts");
			CreateAccount.create(Login.user.getUserID());
			ActionsPage.main(null);
		}
	}
}
