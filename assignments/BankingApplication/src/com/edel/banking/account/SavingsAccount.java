package com.edel.banking.account;

import com.edel.banking.serialization.Serialize;
import com.edel.banking.user.User;

public class SavingsAccount extends Account
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4707208291558953304L;
	
	private static int ID = 2000;

	public SavingsAccount()
	{
		super();
	}

	// Create new savings account with user information and initial balance
	public SavingsAccount(User user, double balance)
	{
		super(ID, user, balance);
		super.setType(type());
		ID++;
	}

	public String type()
	{
		return AccountType.SAVINGS;
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
			
			// Check that user does not withdraw more than $500 a month
			else if(amount > 500)
			{
				System.out.println("You cannot withdraw more than $500 in a month!");
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
