package com.revature.goshornm.bank.transactions;

import java.util.Date;

import javax.money.MonetaryAmount;

public abstract class Credit {
	protected String type = "";
	protected Long target;
	protected Long source;
	protected MonetaryAmount monetaryAmount;
	protected Date date = new Date();
	
	//public abstract MonetaryAmount createCredit(User user, Account targetAccount);

	public MonetaryAmount getMonetaryAmount() {
		return monetaryAmount;
	}

	public void setMonetaryAmount(MonetaryAmount monetaryAmount) {
		this.monetaryAmount = monetaryAmount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Date getDate() {
		return date;
	}
}
