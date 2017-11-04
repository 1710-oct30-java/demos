package com.revature.goshornm.bank;

import java.io.Serializable;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;

import org.apache.log4j.Logger;
import org.javamoney.moneta.Money;

import com.revature.goshornm.bank.transactions.Credit;
import com.revature.goshornm.bank.transactions.Transfer;
import com.revature.goshornm.bank.transactions.Withdrawal;

public class Account implements Serializable {

	private static final long serialVersionUID = -7785899516756658229L;
	private static Logger log = Logger.getRootLogger();
	private static final CurrencyUnit DEFAULT_USD = MonetaryCurrencies.getCurrency("USD");
	private static transient final String FILE_PREFIX = "Accounts\\";
	private static transient final String FILE_SUFFIX = ".txt";
	private long accountID;
	private Accounts accountType;
	private String accountName;
	private MonetaryAmount balance;
	private boolean closed;
	
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
		String format = "%-19s - Account Number: %19s %16s %22s";
		
		String money = Util.getCurrencyString(balance);
		//double money = balance.getNumber().doubleValueExact();
		
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


	public void withdraw(Withdrawal withdrawal) {
		balance = balance.subtract(withdrawal.getMonetaryAmount());
		serialize();
	}
	
	public void withdraw(Transfer transfer) {
		balance = balance.subtract(transfer.getAmount());
		serialize();
	}
	
	public void credit(Credit credit) {
		log.trace("Crediting account - initial balance: " + this.getBalance().getNumber() +
				", amount to credit: " + credit.getMonetaryAmount().getNumber());
		balance = balance.add(credit.getMonetaryAmount());
		log.trace("Subsequent balance: " + balance.getNumber());
		serialize();
	}
	
	public void credit(Transfer transfer) {
		balance = balance.add(transfer.getAmount());
		serialize();
	}
	
	public boolean canWithdrawAmount(MonetaryAmount amount) {
		
		if(closed) {
			log.error("User attempted to withdraw from a closed account.");
			return false;
		}
		
		//Amount is positive check
		if(amount.isLessThanOrEqualTo(Money.of(0, amount.getCurrency()))) {
			System.out.println("Unable to withdraw an amount of zero or less.\n");
			return false;
		}
		
		//Has sufficient balance check
		if(balance.isLessThan(amount)) {
			System.out.println("You have insufficient funds for this action.");
			log.info("Insufficient funds. Transaction cancelled.");
			log.trace("Requested: " + Util.getCurrencyString(amount) + ", balance was: " + Util.getCurrencyString(getBalance()));
			return false;
		}
		
		//Checks passed
		return true;
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
	
	/**
	 * Prints a receipt for a withdrawal
	 * @param withdrawal - Withdrawal object
	 */
	public void printReceipt(Withdrawal withdrawal) {
		
		System.out.println("/----------------------------------------------------------------------\\");
		System.out.println("|  Receipt of Withdrawal for amount:                                   |");
		System.out.printf ("|         %-25s                                    |%n", Util.getCurrencyString(withdrawal.getMonetaryAmount()));
		System.out.println("|                                                                      |");
		System.out.printf ("|   %20s         Account: %20s |%n", withdrawal.getDate(), accountID );
		System.out.println("\\----------------------------------------------------------------------/");
	}
	
	/**
	 * Prints a receipt for a deposit
	 * @param credit - credit object
	 */
	public void printReceipt(Credit credit) {
		System.out.println("/----------------------------------------------------------------------\\");
		System.out.println("|  Receipt of Credit in amount of  :                                   |");
		System.out.printf ("|         %-25s                                    |%n", Util.getCurrencyString(credit.getMonetaryAmount()));
		System.out.println("|                                                                      |");
		System.out.printf ("|   %20s         Account: %20s |%n", credit.getDate(), accountID );
		System.out.println("\\----------------------------------------------------------------------/");
	}
	
	public void printReceipt(Transfer transfer) {
		System.out.println("/----------------------------------------------------------------------\\");
		System.out.printf ("|   Receipt of Transfer                   %25s |%n", transfer.getDate());
		System.out.println("|----------------------------------------------------------------------|");
		System.out.println("|          FROM:                                                       |");
		System.out.printf ("|         Account: %20s                                |%n", transfer.getSource());
		System.out.println("|           TO:                                                        |");
		System.out.printf ("|         Account: %20s                                |%n", transfer.getTarget());
		System.out.println("|                                                                      |");
		System.out.printf ("|          Amount of transfer: %20s                    |%n", Util.getCurrencyString(transfer.getAmount()));
		System.out.println("\\----------------------------------------------------------------------/");
	}
		
	public void closeAccount() {
		this.closed = true;
	}
	
}
