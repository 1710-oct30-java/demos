package com.edel.banking.account;

import com.edel.banking.serialization.Serialize;
import com.edel.banking.user.User;

public class CheckingAccount extends Account
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1964804567757075963L;
	
	private static int ID = 1000;

	public CheckingAccount()
	{
		super();
	}

	// Create new checking account with user information and initial balance
	public CheckingAccount(User user, double balance)
	{
		super(ID, user, balance);
		super.setType(type());
		ID++;
	}

	public String type()
	{
		return AccountType.CHECKING;
	}

	@Override
	public String toString()
	{
		String result = "ID: " + super.getID() + super.toString() + "\nType: " + type() + "\n";
		return result;
	}

	@Override
	public void withdraw(int amount)
	{
		// Check that amount is greater than zero
		if (super.isAmountCorrect(amount))
		{
			// Check if amount is more than current balance
			if (amount > super.getBalance())
			{
				System.out.println("Not enough balance!\nCurrent Balance: $" + super.getBalance());
			}

			// Else withdraw amount
			else
			{
				super.setBalance(super.getBalance() - amount);
				Serialize.serializeAccounts();
			}
		}
	}
}
