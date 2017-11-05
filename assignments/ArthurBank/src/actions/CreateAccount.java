package actions;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import GUI.Home;
import objects.Account;

public class CreateAccount {

	public static void create(String userID) throws IOException {

		// Asks user what kind of account they want to make

		Account account = new Account(null, null, 0, null);
		Scanner in = new Scanner(System.in);
		System.out.println("What kind of account do you want to make?");
		System.out.println("1: Chequing");
		System.out.println("2: Savings");
		System.out.println("3: Cancel");

		String accounttype = in.nextLine();

		// Produces a random 6 digit id for the new account and updates the
		// accountList.txt via UpdateAccount class

		if (accounttype.equals("1")) {
			account.setType("Chequing");
			account.setUserID(userID);
			Random rng = new Random();
			String id = Integer.toString(100000 + rng.nextInt(900000));
			account.setaccID(id);

			Login.accountData.add(account);
			for (int i = 0; i < Login.accountData.size(); i++) {
				System.out.println(Login.accountData.get(i));
			}
			UpdateAccount.update();

		}

		else if (accounttype.equals("2")) {
			account.setType("Savings");
			account.setUserID(userID);
			Random rng = new Random();
			String id = Integer.toString(100000 + rng.nextInt(900000));
			account.setaccID(id);

			Login.accountData.add(account);
			for (int i = 0; i < Login.accountData.size(); i++) {
				System.out.println(Login.accountData.get(i));
			}

			UpdateAccount.update();

		}

		else if (accounttype.equals("3")) {
			Home.main(null);
		} else {
			System.out.println("Error, account type does not exist.");
		}

	}

}
