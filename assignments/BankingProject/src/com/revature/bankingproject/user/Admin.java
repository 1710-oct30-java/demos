package com.revature.bankingproject.user;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.revature.bankingproject.account.AccountView;
import com.revature.bankingproject.tools.EncryptionHandler;
import com.revature.bankingproject.tools.UserTools;

public class Admin {
	private User self;

	public Admin(List<User> users) {
		this.self = new User(0, "Admin", EncryptionHandler.Encrypt("123"), " ");
		self.setFlagged();
		users.add(self);
		
	}

	public static void viewAllAccounts(List<User> users, Scanner scan) {
		for (User user : users) {
			if(UserTools.isAdmin(user)) continue;
			System.out.println("Viewing " + user.getEmail() + "'s Accounts");
			AccountView.viewAccounts(user.getAccounts(), true);
		}
	}
	//DEPRICATED
	/*public static int modifyAmountInUserAccount(List<User> users, Scanner scan) {
		int accountId;
		boolean invalidAccount = true;
		do {
			System.out.println("Which account would you like to modify?");
			String input = scan.nextLine();
			try {
				accountId = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("The admin makes no mistakes.  You are not the admin");
				return 4;
			}
			final int streamAccountId = accountId;
			for (User user : users) {
				if (user.getAccounts().stream().anyMatch(i -> i.getId() == streamAccountId)) {
					invalidAccount = false;
					break;
				}
			}
		} while (invalidAccount);
		final int streamAccountId = accountId;
		Optional<Account> accountToModify = users.stream().map(i -> i.getAccounts()).flatMap(Collection::stream)
				.filter(j -> j.getId() == streamAccountId).findFirst();
		AccountDepositOrWithdraw.handleMoney(accountToModify.get(), scan);
		return 1;
	}*/

	public static int deFlagUsers(List<User> users, Scanner scan)
	{
		List<User> flaggedUsers = users.stream().filter(i -> i.getFlagged() == true).collect(Collectors.toList());
		if(flaggedUsers.size() == 0)
		{
			System.out.println("There are currently no flagged Users");
			return 1;
		}
		for(User user: flaggedUsers)
		{
			System.out.println("Would you like to unFlag " + user.getEmail() + " (y/n)");
			String input = scan.nextLine();
			switch(input)
			{
			case("y"):
				user.setFlagged();
				break;
			case("n"):
				break;
			default:
				System.out.println("Admin makes no mistakes!");
				return 4;
			}
		}
		return 1;
	}
	public static int removeUser(List<User> users, Scanner scan) {
		while (true) {
			users.stream().map(i -> i.getEmail()).forEach(System.out::println);
			System.out.println("Which user would you like to remove:");
			String input = scan.nextLine();
			if (input.length() == 0)
				return 0;
			for (User user : users) {
				if (user.getEmail().equals(input)) {
					users.remove(user);
					return 0;
				}
			}

		}
	}
}
