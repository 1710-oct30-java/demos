package com.revature.goshornm.bank.transactions;

import java.util.Date;

import javax.money.MonetaryAmount;

import com.revature.goshornm.bank.Account;
import com.revature.goshornm.bank.User;
import com.revature.goshornm.bank.Util;

public class Transfer {
	String type = "TRANSFER";
	long source;
	long target;
	Date date = new Date();
	MonetaryAmount amount;
	
	public static Transfer createTransfer(User user, Account source, Account target) {
		MonetaryAmount amount = null;
		
		do {
			String input = Util.promptForString("How much will you be transfering from your account?\n\t",
					source.getBalance().getCurrency().getCurrencyCode());
			
		} while(true); //TODO change condition
		
		
		
		
		
		
		
		
		//TODO remove this
		return null;
		
	}
	
}
