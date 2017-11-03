package com.revature.goshornm.bank;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.javamoney.moneta.spi.MonetaryConfig;

public class UserAccountManager implements Branchable{

	User user;
	AccountsManager accountsManager;
	public UserAccountManager(User user) {
		this.user = user;
		this.accountsManager = new AccountsManager(user);
	}

	public void entry() {
		//TODO idea - Auto logout after no activity for 30 seconds?
		//Create ticking thread with counter reset when user acts
		
		boolean logout = false;

		accountsManager.displayAccountsSummary();
		
		while(!logout) {
			int options = displayOptions();
			int selection = getInput(options);
			
			switch(selection) {
			case 0: logout = true; break;
			case 1: //TODO userAccountOptions();
			case 2: displayAccounts(); break;
			case 3: accountsManager.createNewAccount(user); break;
			}
			
			
		}
		
	}

	private void displayAccounts() {

		Logger LOG = Logger.getLogger("org.javamoney.moneta.DefaultMonetaryContextFactory");
		LOG.setLevel(Level.OFF);
		String noAccountsMessage = "There are no banking associated with your user account.";
		String format = "\t\t%d. %s%n";
		int i = 1;
		System.out.println();

		if(user.getAccounts() == null || user.getAccounts().size() == 0) {
			System.out.println(noAccountsMessage);
			return;
		}
		
		System.out.println("\tAccounts:");
		for(Account account : user.getAccounts()) {
			System.out.printf(format, i, account);
			i++;
		}
		System.out.println();
	}

	@Override
	public int displayOptions() {
		
		
		String explain = "Account options :";
		String[] options = {
				"\t1. Manage User Details ",
				"\t2. View Accounts",
				"\t3. Create New Account",
				"\t0. Log out"
		};
		
		System.out.println(explain);
		for(String option: options) {
			System.out.println(option);
		}
		
		return options.length-1;
	}
	
	

}
