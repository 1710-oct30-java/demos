package com.revature.goshornm.bank.transactions;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

import com.revature.goshornm.bank.User;

public class Deposit extends Transaction {

	public Deposit(int paymentFrom, int paymentTo, int transactionOrigin, CurrencyUnit currencyUnit,
			MonetaryAmount amount) {
		super(paymentFrom, paymentTo, transactionOrigin, currencyUnit, amount);

	}

	
}
