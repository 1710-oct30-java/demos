package com.revature.goshornm.bank.transactions;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

import org.apache.log4j.Logger;
import org.javamoney.moneta.Money;

import com.revature.goshornm.bank.Util;
import com.revature.goshornm.bank.account.Account;
import com.revature.goshornm.bank.user.User;

public class CashCredit extends Credit {

	static Logger log = Logger.getRootLogger();
	
	public CashCredit(long targetAccount, MonetaryAmount amount) {
		type = "CASH";
		target = targetAccount;
		source = null;
		monetaryAmount = amount;
	}
	
	public static Credit createCredit(User user, Account targetAccount) {		
		MonetaryAmount amount = null;
		do{
			String input = Util.promptForString("How much will you be depositing to your account?\n\t", 
					targetAccount.getBalance().getCurrency().getCurrencyCode());
			
			try {
				amount = Money.of(new BigDecimal(input), targetAccount.getBalance().getCurrency());
			} catch(NumberFormatException exception) {
				System.out.println("Input amount did not match any known format.");
			}
			
		} while(amount == null);
		
		log.trace("Requesting cash credit of " + amount.getNumber());
		
		//Ensure requested credit is of a positive amount
		if(amount.isLessThanOrEqualTo(Money.of(0, amount.getCurrency()))) {
			log.trace("Credits must be of a positive amount.");
			System.out.println("Unable to deposit an amount of zero or less.\n");
			return null;
		}
		
		Credit newCredit = new CashCredit(targetAccount.getAccountID(), amount);
		log.trace("Credit created.");
		return newCredit;
	}

}
