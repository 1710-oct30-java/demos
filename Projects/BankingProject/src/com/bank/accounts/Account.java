package com.bank.accounts;

public class Account
{
	private int accID;
	private String owner;
	private double accBal;
	private String type;
	public Account()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accID, String owner, double accBal, String type)
	{
		super();
		this.accID = accID;
		this.owner = owner;
		this.accBal = accBal;
		this.type = type;
	}

	public void deposit(double amount)
	{
		accBal = accBal + amount;
	}

	public boolean withdraw(double amount)
	{
		if (amount > accBal)
			return false;
		else
			accBal = accBal - amount;
		return true;
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
	public double getAccBal()
	{
		return accBal;
	}
	public void setAccBal(double accBal)
	{
		this.accBal = accBal;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}

}
