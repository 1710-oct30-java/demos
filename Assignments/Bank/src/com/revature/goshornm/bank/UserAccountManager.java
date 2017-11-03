package com.revature.goshornm.bank;

import java.util.HashSet;
import java.util.Set;

import com.revature.goshornm.bank.transactions.CashCredit;
import com.revature.goshornm.bank.transactions.CashWithdrawal;
import com.revature.goshornm.bank.transactions.Credit;
import com.revature.goshornm.bank.transactions.Withdrawal;

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
			case 2: makeWithdrawal(); break;	
			case 3: makeDeposit(); break;
			case 4: makeTransfer();
			case 5: displayAccounts(); break;
			case 6: accountsManager.createNewAccount(user); break;
			}			
		}
	}
	
	private void makeTransfer() {
		//select from account
		String noAccounts = "You need to create an account before you can make a deposit.";
		
		//If the user has no accounts associated with their profile, show message and return from deposit screen
		if(user.getAccounts().size() == 0) {
			System.out.println(noAccounts);
			System.out.println();
			return;
		}
		
		Account fromAccount;
		
		//If the user has multiple accounts, allow them to select the target account, otherwise use their only account
		if(user.getAccounts().size() > 1) {
			fromAccount = selectTargetAccount();
		} else {
			fromAccount = user.getAccounts().get(0);
		}
		
		Account toAccount = null;
		
		boolean internal = false;
		boolean cancel = false;
		
		if(user.getAccounts().size() > 1) {
			System.out.println("Are you transfering to one of your own accounts?");
			internal = Util.promptYesOrNot();
		}
		
		
		do {
			
			if(toAccount.equals(fromAccount)) {
				System.out.println("Account unable to transfer to itself.");
			}
			
			if(internal) {
				toAccount = selectTargetAccount(fromAccount);
			} else {
				toAccount = Util.getAccountFromUserByID();
			}
		} while(toAccount != null && (toAccount.equals(fromAccount)));
		
		
		
		
			//Is other user account?
				//if so provide account selection options
			//if not 
	}


	/**
	 * Method withdraws an amount of money.
	 */
	private void makeWithdrawal() {
		String noAccounts = "You need to create an account before you can make a deposit.";
		
		//If the user has no accounts associated with their profile, show message and return from deposit screen
		//TODO present user with option to create account
		
		if(user.getAccounts().size() == 0) {
			System.out.println(noAccounts);
			System.out.println();
			return;
		}
		
		Account targetAccount;
		
		//If the user has multiple accounts, allow them to select the target account, otherwise use their only account
		if(user.getAccounts().size() > 1) {
			targetAccount = selectTargetAccount();
		} else {
			targetAccount = user.getAccounts().get(0);
		}
		
		Withdrawal withdrawal = CashWithdrawal.createWithdrawal(user, targetAccount);
		if(withdrawal == null) return;
		targetAccount.withdraw(withdrawal);
		targetAccount.printReceipt(withdrawal);
		
	}

	/**
	 * Method displays options available at the UserAccount level
	 * @return number of options in this option set
	 */
	@Override
	public int displayOptions() {
		
		
		String explain = "Account options :";
		String[] options = {
				"\t1. Modify User Details ",
				"\t2. Withdraw",
				"\t3. Deposit",
				"\t4. Transfer",
				"\t4. View Accounts",
				"\t5. Create New Account",
				"\t0. Log out"
		};
		
		System.out.println(explain);
		for(String option: options) {
			System.out.println(option);
		}
		
		return options.length-1;
	}
	

	private void displayAccounts() {
		
		System.out.println		  ("/-------------------------------------------------------------------------------------------------------\\");
		String noAccountsMessage = "|          There are no banking associated with your user account.                                      |" ;
		String format =            "| %2d. %70s |%n";
		int i = 1;
		
		if(user.getAccounts() == null || user.getAccounts().size() == 0) {
			System.out.println(noAccountsMessage);
			return;
		}
		
		System.out.println        ("|      Accounts:                                                                                        |");
		System.out.println        ("|- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -|");
		
		for(Account account : user.getAccounts()) {
			System.out.printf(format, i, account);
			i++;
		}
		System.out.println		  ("\\-------------------------------------------------------------------------------------------------------/");
		System.out.println();
	}
	
	private void displayAccounts(Account... unavailableAccounts) {
		
		//Setup unavailable set
		Set<Account> unavailable = new HashSet<>();
		for(Account account : unavailableAccounts) {
			unavailable.add(account);
		}
		
		System.out.println		  ("/-------------------------------------------------------------------------------------------------------\\");
		String noAccountsMessage = "|          There are no banking associated with your user account.                                      |" ;
		String format =            "| %2s. %70s |%n";
		int i = 1;
		
		if(user.getAccounts() == null || user.getAccounts().size() == 0) {
			System.out.println(noAccountsMessage);
			return;
		}
		
		System.out.println        ("|      Accounts:                                                                                        |");
		System.out.println        ("|- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -|");
		
		for(Account account : user.getAccounts()) {
			boolean unselectable = unavailable.contains(account);
			System.out.printf(format, unselectable ? "XX" : String.valueOf(i), account);
			i++;
		}
		System.out.println		  ("\\-------------------------------------------------------------------------------------------------------/");
		System.out.println();
	
	}
	
	
	private StringBuilder getAccountsStringBuilder() {
		StringBuilder strB = new StringBuilder("");
		String format = "\t\t%d. %s%n";
		for(int i = 1; i <= user.getAccounts().size(); i++) {
			strB.append(String.format(format, i, user.getAccounts().get(i-1).getAccountName()));
		}
		return strB;
	}

	private void makeDeposit() {
		String noAccounts = "You need to create an account before you can make a deposit.";
		
		//If the user has no accounts associated with their profile, show message and return from deposit screen
		//TODO present user with option to create account
		
		if(user.getAccounts().size() == 0) {
			System.out.println(noAccounts);
			System.out.println();
			return;
		}
		
		Account targetAccount;
		
		//If the user has multiple accounts, allow them to select the target account, otherwise use their only account
		if(user.getAccounts().size() > 1) {
			targetAccount = selectTargetAccount();
		} else {
			targetAccount = user.getAccounts().get(0);
		}
	
		Credit credit = CashCredit.createCredit(user, targetAccount);
		
		//Return if unable to create credit
		if(credit == null) return;
		
		targetAccount.credit(credit);
		targetAccount.printReceipt(credit);
	}
	
	private Account selectTargetAccount() {
		displayAccounts();
		System.out.println("Please select a target account: \n");
		StringBuilder strB = getAccountsStringBuilder();
		int selection = getInput(user.getAccounts().size(), strB.toString());
		return user.getAccounts().get(selection-1);
	}
	

	private Account selectTargetAccount(Account... unavailableAccounts) {
		displayAccounts(unavailableAccounts);
		System.out.println("Please select a target account: \n");
		StringBuilder strB = getAccountsStringBuilder();
		int selection = getInput(user.getAccounts().size(), strB.toString());
		return user.getAccounts().get(selection-1);
	}



}
