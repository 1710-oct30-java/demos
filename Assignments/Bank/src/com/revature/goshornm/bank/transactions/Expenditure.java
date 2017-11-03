package com.revature.goshornm.bank.transactions;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

public class Expenditure extends Transaction {

	public Expenditure(int paymentFrom, int paymentTo, int transactionOrigin, CurrencyUnit currencyUnit,
			MonetaryAmount amount) {
		super(paymentFrom, paymentTo, transactionOrigin, currencyUnit, amount);
		// TODO Auto-generated constructor stub
	}

}
