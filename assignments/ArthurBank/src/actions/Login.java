package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import GUI.ActionsPage;
import GUI.Home;
import objects.Account;
import objects.User;

public class Login {

	private static boolean accountCheck;
	private static boolean passwordCheck;
	public static ArrayList<Account> accountData;
	public static User user;

	public static void login(ArrayList<User> ul) throws IOException {
		
		// accountcheck validates user account to account data
		// passwordcheck validates user password to account data
		// userdata is an array that contains all user objects
		// user determines which user is currently using the system

		// prompts user to enter login id and password, checks if username exists and if
		// password is correct

		Parser p = new Parser();
		accountData = p.ParseAccount();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Login Information");
		System.out.println("Account ID: ");

		// for (User u : ul) {
		// System.out.println(u.toString());
		// }

		String username = in.nextLine();

		for (User u : ul) {
			// System.out.println(ul.size());
			// System.out.println(u.getUsername().toString());
			if (username.equals(u.getUsername())) {
				accountCheck = true;
				user = u;
			}
		}

		if (accountCheck == false) {

			System.out.println("username does not exist");
			login(ul);

		}

		// System.out.println(accountCheck);
		if (accountCheck == true) {
			System.out.println("Enter Password: ");
			String password = in.nextLine();
			if (password.equals(user.getPassword())) {
				passwordCheck = true;

			} else {
				System.out.println("password is incorrect.");

				Home.main(null);
			}
		}

		if (passwordCheck == true) {
			System.out.println("Successfully logged in");
			LoadAccounts.main(null);
			ActionsPage.main(null);
		}
	}
}
