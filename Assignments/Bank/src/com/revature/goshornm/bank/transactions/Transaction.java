package com.revature.goshornm.bank.transactions;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

/**
 * Abstract class describes basic properties of a transaction and provides
 * accessors to these properties
 * 
 * 
 * @author Mitch Goshorn
 *
 */
public abstract class Transaction {
	private int paymentFrom;
	private int paymentTo;
	private int transactionOrigin;
	private CurrencyUnit currencyUnit;
	
	public Transaction(int paymentFrom, int paymentTo, int transactionOrigin, CurrencyUnit currencyUnit,
			MonetaryAmount amount) {
		super();
		this.paymentFrom = paymentFrom;
		this.paymentTo = paymentTo;
		this.transactionOrigin = transactionOrigin;
		this.currencyUnit = currencyUnit;
		this.amount = amount;
	}
	
	public int getPaymentFrom() {
		return paymentFrom;
	}
	public int getPaymentTo() {
		return paymentTo;
	}
	public int getTransactionOrigin() {
		return transactionOrigin;
	}
	public CurrencyUnit getCurrencyUnit() {
		return currencyUnit;
	}
	public MonetaryAmount getAmount() {
		return amount;
	}
	private MonetaryAmount amount;
	
	
}
