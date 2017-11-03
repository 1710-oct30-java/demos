package com.revature.goshornm.bank;

import java.util.List;
import java.util.Random;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

public class AccountsManager {
	private User user;

	public AccountsManager(User user) {
		super();
		this.user = user;
	}
	
	/**
	 * Outputs a brief account summary.
	 */
	public void displayAccountsSummary() {
		List<Account> accounts = user.getAccounts();
		

		
		if(accounts == null || accounts.size() == 0) {
			System.out.println("/----------------------------------------------------------------------\\");
			System.out.println("|                                                                      |");
			System.out.println("|  You have not created any accounts.                                  |");
			System.out.println("|                                                                      |");
			System.out.println("\\----------------------------------------------------------------------/");
			return;
		}

		//TODO assign a primary currency to user account settings and use that
		//Alternative, find a better way to summarize accounts
		CurrencyUnit primaryCurrency = Money.from(accounts.get(0).getBalance()).getCurrency();
		
	    MonetaryAmount checkingTotalMoney = accounts.parallelStream()
			.filter(a -> a.getAccountType() == Accounts.CHECKING)
			.map(a -> a.getBalance())
			.reduce((acc, o) -> acc.add(o))
			.get();
	
		MonetaryAmount totalAvailableMoney = accounts.parallelStream()
			.filter(a -> Money.from(a.getBalance()).getCurrency() == primaryCurrency)
			.map(a -> a.getBalance())
			.reduce((acc, o) -> acc.add(o))
			.get();
		
		String totalString = Util.getCurrencyString(totalAvailableMoney);
		String checkingString = Util.getCurrencyString(checkingTotalMoney);
		
		System.out.println("/----------------------------------------------------------------------\\");
		System.out.println("|                      Accounts Summary                                |");
		System.out.printf ("|  Checking Total Available:                    %22s |%n", checkingString);
		System.out.printf ("|  Total Available Across accounts:             %22s |%n", totalString);
		System.out.println("|                                                                      |");
		System.out.println("\\----------------------------------------------------------------------/");

	}

	public void createNewAccount(User user) {
		String accountNamePrompt = "Please enter a name for this account.";
		CurrencyOptions currencyOptions = new CurrencyOptions();
		
		//Initial type
		Accounts type = Accounts.CHECKING;
		//Prompt to replace type
		type = type.promptForAccountType();
		
		//User canceled so return
		if(type == null) return;
		
		
		//Prompt for account name
		String accountName = Util.promptForString(accountNamePrompt);
		
		//If the user enters no name, use the name of the type
		if(accountName.length() == 0) type.name();
		
		long accountID = generateNewAccountID();
		
		//Prompt for change of currency type
		CurrencyUnit currency = currencyOptions.promptForChangeCurrencyFromDefault();
		
		Account account = new Account(accountID, accountName, type, currency);
		
		user.addAccount(account);
		
		//Prompt for initial deposit
			//Cash
			//Transfer from other owned account
		
		//serialize accounts
		
	}
	
	/**
	 * Generates an unused random account ID
	 * Internally leading 0s are included
	 * @return - Generated account ID
	 */
	public static long generateNewAccountID() {
		Random random = new Random(System.nanoTime());
		Long num = null;
		do {
			num = Math.abs(random.nextLong());
		} while(num == null || Account.exists(num));
		return num;
	}
	
	
	
	

	
}
