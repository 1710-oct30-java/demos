package com.revature.goshornm.bank.transactions;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

import org.apache.log4j.Logger;
import org.javamoney.moneta.Money;

import com.revature.goshornm.bank.Account;
import com.revature.goshornm.bank.User;
import com.revature.goshornm.bank.Util;

public class CashWithdrawal extends Withdrawal {

	static Logger log = Logger.getRootLogger();
	
	public CashWithdrawal(long targetAccount, MonetaryAmount amount) {
		type = "CASH";
		target = targetAccount;
		source = null;
		monetaryAmount = amount;
	}
	
	public static Withdrawal createWithdrawal(User user, Account targetAccount) {		
		MonetaryAmount amount = null;
		do{
			String input = Util.promptForString("How much will you be withdrawing from your account?\n\t", 
					targetAccount.getBalance().getCurrency().getCurrencyCode());
			
			try {
				amount = Money.of(new BigDecimal(input), targetAccount.getBalance().getCurrency());
			} catch(NumberFormatException exception) {
				System.out.println("Input amount did not match any known format.");
			}
		
			log.trace("Requesting cash withdrawal of " + amount.getNumber());
			
			if(!targetAccount.canWithdrawAmount(amount)) {
				return null;
			}
			
		} while(amount == null);
		
		
		
		Withdrawal newWithdrawal = new CashWithdrawal(targetAccount.getAccountID(), amount);
		log.trace("Withdrawal created.");

		return newWithdrawal;
	}

}
