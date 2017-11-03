package com.revature.goshornm.bank;

import java.io.Serializable;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;

import org.javamoney.moneta.Money;

public class Account implements Serializable {
	private static final CurrencyUnit DEFAULT_USD = MonetaryCurrencies.getCurrency("USD");
	private static transient final String FILE_PREFIX = "Accounts\\";
	private static transient final String FILE_SUFFIX = ".txt";
	private long accountID;
	private Accounts accountType;
	private String accountName;
	private MonetaryAmount balance;
	
	/**
	 * Create new object specifying an initial balance.
	 * @param user - user object
	 * @param accountID - Internal account ID
	 * @param accountName - Customer specified account name
	 * @param accountType - Type of account
	 * @param initialBalance - Object representation of initial balance
	 */
	public Account(long accountID, String accountName, Accounts accountType, CurrencyUnit currencyType) {
		this.accountID = accountID;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balance = Money.of(0, currencyType);
	}
	
	public void deposit(User user) {
		String transferUnavailable = "(No other accounts available)";
		
		
	}
	
	public String toString() {
		String format = "%-20s - Account Number: %s %15s %8.2f";
		double money = balance.getNumber().doubleValueExact();
		
		return String.format(format, accountName, accountID, "["+accountType+"]", money);
	}
	
	public static CurrencyUnit getUsd() {
		//TODO don't do this
		return null;
	}

	public long getAccountIDForUser() {
		return Long.valueOf(accountID);
	}

	public Accounts getAccountType() {
		return accountType;
	}
	
	public long getAccountID() {
		return accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public MonetaryAmount getBalance() {
		return balance;
	}


	private MonetaryAmount withdraw(MonetaryAmount withdrawalAmount) {
		//TODO
		return withdrawalAmount;
		
		
	}
	
	
	private boolean canWithdrawAmount(MonetaryAmount amount) {
		return balance.isGreaterThanOrEqualTo(amount);
	}
	
	private MonetaryAmount withdrawAmount(MonetaryAmount amount) {
		balance.subtract(amount);
		return amount;
	}
//	
//	private MonetaryAmount quickWithdrawal() {
//		//MonetaryAmount quickWithdrawalAmount = MonetaryAmounts.getDefaultAmountFactory()
//		//		.setNumber(40).setCurrency("USD").create();
//		
//		//MonetaryAmount withdrawnAmount = withdraw(quickWithdrawalAmount);
//		//return withdrawnAmount;
//	}

	public static Account load(long accountID) {
		Account account = deserialize(accountID);
		return account;		
	}
	
	public static Account deserialize(long accountID) {
		String address = FILE_PREFIX + accountID + FILE_SUFFIX;
		
		Serializer<Account> serializer = new Serializer<>();
		Account account = serializer.readObject(address);
		return account;
	}
	
	public boolean serialize() {
		String address = FILE_PREFIX + accountID + FILE_SUFFIX;
		
		Serializer<Account> serializer = new Serializer<>();
		return serializer.writeObject(this, address);
	}
	


	/**
	 * Test whether an Account object exists with the given ID
	 * @param accID - Id to test
	 * @return true if account exists, false otherwise
	 */
	public static boolean exists(long accID) {
		String address = FILE_PREFIX + accID + FILE_SUFFIX;
		Serializer<Account> serializer = new Serializer<>();
		return serializer.objectExists(address);
	}
	
}
