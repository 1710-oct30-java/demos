package com.edel.banking.account;

import java.util.Random;

import com.edel.banking.user.User;

public class SavingsAccount extends Account
{
	public SavingsAccount(User user)
	{
		super.setOwner(user);
	}
	
	@Override
	public String type()
	{
		return "Savings";
	}
	
	// Generate ID from range 20000-29999
	// ID that start with the number 2 are a SavingsACcount type
	@Override
	public int idGenerator()
	{
		Random rand = new Random();

		//29999 is the maximum and the 20000 is our minimum
		int  n = rand.nextInt(29999) + 20000;
		
		return n;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "\nType: " + type() + "\n";
	}
}
