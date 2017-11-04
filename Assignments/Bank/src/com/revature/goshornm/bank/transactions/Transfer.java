package com.revature.goshornm.bank.transactions;

import java.math.BigDecimal;
import java.util.Date;

import javax.money.MonetaryAmount;

import org.apache.log4j.Logger;
import org.javamoney.moneta.Money;

import com.revature.goshornm.bank.Account;
import com.revature.goshornm.bank.User;
import com.revature.goshornm.bank.Util;

public class Transfer {
	private static Logger log = Logger.getRootLogger();

	private String type = "TRANSFER";
	private long source;
	private long target;
	private Date date = new Date();
	private MonetaryAmount amount;
	
	public Transfer(String type, long source, long target, MonetaryAmount amount) {
		this.type = type;
		this.source = source;
		this.target = target;
		this.date = new Date();
		this.amount = amount;
		
	}
	
	public static Logger getLog() {
		return log;
	}


	public String getType() {
		return type;
	}


	public long getSource() {
		return source;
	}


	public long getTarget() {
		return target;
	}


	public Date getDate() {
		return date;
	}


	public MonetaryAmount getAmount() {
		return amount;
	}
	
	/**
	 * Creates a new Transfer object with no monteray amount predefined.
	 * Defers to {@link #createTransfer(User, Account, Account, MonetaryAmount) after amount is determined
	 * @param user - User initiating transfer
	 * @param source - Source account of the user
	 * @param target - Target account to which funds will be sent
	 * @return - Transfer object or null if there is an error
	 */
	public static Transfer createTransfer(User user, Account source, Account target) {
		MonetaryAmount amount = null;
		
		do {
			String input = Util.promptForString("How much will you be transfering from your account?\n\t",
					source.getBalance().getCurrency().getCurrencyCode());
			
			//Get input and convert to MonetaryAmount
			try {
				amount = Money.of(new BigDecimal(input), source.getBalance().getCurrency());
			} catch(NumberFormatException exception) {
				System.out.println("Input amount did not match any known format.");
			}
			
			//Check to make sure the source account can withdraw this amount for the transfer
			if(!source.canWithdrawAmount(amount)) {
				log.info("Transfer cancelled due to insufficient funds.");
				return null;
			}
			
		} while(amount == null);
		
		return createTransfer(user, source, target, amount);
		
	}
	
	/**
	 * Creates a new Transfer object with a predefined monetary amount
	 * @param user - User initiating the transfer
	 * @param source - Source account of user from which funds will be withdrawn
	 * @param target - Account to which funds will be credited
	 * @param amount - Amount of the transfer
	 * @return
	 */
	public static Transfer createTransfer(User user, Account source, Account target, MonetaryAmount amount) {
		if(!source.canWithdrawAmount(amount)) {
			log.info("Transfer cancelled due to insufficient funds.");
			return null;
		}
		Transfer transfer = new Transfer("TRANSFER", source.getAccountID(), target.getAccountID(), amount);
		
		return transfer;	
	}
	
}
