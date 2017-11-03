package com.edel.banking.account;

import java.util.ArrayList;
import java.util.List;

import com.edel.banking.user.User;

/*
	Account
	int id
	User owner
	double balance
	String type
*/

public abstract class Account
{
	// Fields
	private int ID;
	private double balance;
	private User owner;
	
	public abstract String type();
	public abstract int idGenerator();
	
	public static List<Account> accountList = new ArrayList<Account>();
	
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
	
	public static void closeAccount(Account acc)
	{
		accountList.remove(acc);
	}
	
	public static void openAccount(Account acc)
	{
		accountList.add(acc);
	}
	
	public static void displayAccounts()
	{
		for(Account acc:accountList)
		{
			System.out.println(acc);
		}
	}
	
	@Override
	public String toString()
	{
		return "ID: " + ID + "\nOwner: " + getOwner().getName() + "\nBalance: $" + getBalance();
	}
	
}
