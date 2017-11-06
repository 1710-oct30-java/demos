package GUI;

import java.io.IOException;
import java.util.Scanner;

import actions.CreateAccount;
import actions.DeleteAccount;
import actions.LoadAccounts;
import actions.Login;
import actions.Transactions;
import objects.Account;

public class ActionsPage {

	public static void main(String[] args) throws IOException {

		// Handles sequence of events pertaining to the current logged in user
		// uses current instance of userdata to determine which accounts are associated
		// with the user. Asks user for withdraw/deposit amount and calls the
		// appropriate methods

		Scanner in = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Check Balance");
		System.out.println("4. Create Account");
		System.out.println("5. Delete Account");
		String choice = in.nextLine();

		if (choice.equals("1")) {
			
			if (LoadAccounts.acc.isEmpty()) {
				System.out.println("No accounts");
				ActionsPage.main(null);
			}
			
			Scanner withdrawsc = new Scanner(System.in);
			System.out.println("Which account would you like to withdraw from?");
			
			for (int i = 0; i < LoadAccounts.acc.size(); i++) {
				System.out.println(i + 1 + "." + " " + "Type: " + LoadAccounts.acc.get(i).getType() + " "
						+ LoadAccounts.acc.get(i).getaccID());
			}

			String accountchoice = LoadAccounts.acc.get(Integer.parseInt(withdrawsc.nextLine()) - 1).getaccID();

			System.out.println("How much would you like to withdraw?");
			double wamount = Double.parseDouble(withdrawsc.nextLine());

			Transactions.withdraw(accountchoice, wamount);
			DoMore.main(null);

		} else if (choice.equals("2")) {
			
			if (LoadAccounts.acc.isEmpty()) {
				System.out.println("No accounts");
				ActionsPage.main(null);
			}
			
			Scanner depsc = new Scanner(System.in);
			System.out.println("Which account would you like to deposit into?");
			for (int i = 0; i < LoadAccounts.acc.size(); i++) {
				System.out.println(i + 1 + "." + " " + "Type: " + LoadAccounts.acc.get(i).getType() + " "
						+ LoadAccounts.acc.get(i).getaccID());
			}

			String accountchoice = LoadAccounts.acc.get(Integer.parseInt(depsc.nextLine()) - 1).getaccID();

			System.out.println("How much would you like to deposit?");
			double damount = Double.parseDouble(depsc.nextLine());

			Transactions.deposit(accountchoice, damount);
			DoMore.main(null);

		} else if (choice.equals("3")) {
			
			if (LoadAccounts.acc.isEmpty()) {
				System.out.println("No accounts");
				ActionsPage.main(null);
			}
			
			Scanner bsc = new Scanner(System.in);
			System.out.println("Which account would you like to view balance of?");
			for (int i = 0; i < LoadAccounts.acc.size(); i++) {
				System.out.println(i + 1 + ". " + "Type: " + LoadAccounts.acc.get(i).getType() + " "
						+ LoadAccounts.acc.get(i).getaccID());
			}
			String accountchoice = bsc.nextLine();
			System.out.println(LoadAccounts.acc.get(Integer.parseInt(accountchoice)).getBalance());

			DoMore.main(null);

		} else if (choice.equals("4")) {
			CreateAccount.create(Login.user.getUserID());
			DoMore.main(null);

		} else if (choice.equals("5")){
			
			if (LoadAccounts.acc.isEmpty()) {
				System.out.println("No accounts");
				ActionsPage.main(null);
			}
			
			DeleteAccount.delete(Login.user.getUserID());
			DoMore.main(null);
		}
		
		
		else {
			System.out.println("Invalid Choice");
			ActionsPage.main(null);
		}
	}
}
