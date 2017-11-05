package com.bank.accounts;

import java.io.Serializable;

public class Account implements Serializable
{
	private int accID;
	private String owner;
	private double balance = 0;;
	
	public Account(int id, String accOwner)
	{
		accID = id;
		owner = accOwner;
	}
	public Account(int id, String accOwner, double accBalance)
	{
		accID = id;
		owner = accOwner;
		balance = accBalance;
	}
	
	
	public int getAccID()
	{
		return accID;
	}
	public void setAccID(int accID)
	{
		this.accID = accID;
	}
	public String getOwner()
	{
		return owner;
	}
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	
	
}
