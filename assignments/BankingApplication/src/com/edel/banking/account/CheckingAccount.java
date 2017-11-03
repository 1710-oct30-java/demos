package com.edel.banking.account;

import java.util.Random;

import com.edel.banking.user.User;

public class CheckingAccount extends Account
{
	
	public CheckingAccount(User user)
	{
		super.setOwner(user);
		super.setID(idGenerator());
	}

	@Override
	public String type()
	{
		return "Checking";
	}
	
	// Generate ID from range 10000-19999
	// ID that start with the number 1 are a CheckingACcount type
	@Override
	public int idGenerator()
	{
		Random rand = new Random();

		//19999 is the maximum and the 10000 is our minimum
		int  n = rand.nextInt(19999) + 10000;
		
		return n;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "\nType: " + type() + "\n";
	}
	
}
