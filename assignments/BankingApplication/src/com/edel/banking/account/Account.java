package com.edel.banking.account;

import java.io.Serializable;

import com.edel.banking.serialization.Deserialize;
import com.edel.banking.serialization.Serialize;
import com.edel.banking.user.User;

// This class contains account information for all account

public abstract class Account implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5268186163122348835L;
	
	// Fields
	private int ID = 1000;
	private double balance;
	private User owner;
	private String type;

	public abstract void withdraw(int amount);

	// Constructors
	public Account()
	{
		
	}

	// Create new account with balance
	public Account(int ID, User owner, double balance)
	{
		this.ID = ID;
		this.owner = owner;
		this.balance = balance;
	}

	// Methods
	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public User getOwner()
	{
		return owner;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
	public void deposit(int amount)
	{
		// Deposit only positive amount
		if(isAmountCorrect(amount))
		{
			balance += amount;
			Serialize.serializeAccounts();
		}
	}
	
	// Check that amount is greater than zero
	public boolean isAmountCorrect(int amount)
	{
		if(amount > 0)
		{
			return true;
		}		
		
		return false;
	}

	@Override
	public String toString()
	{
		return "\nOwner: " + getOwner().getName() + "\nBalance: $" + getBalance();
	}

}
