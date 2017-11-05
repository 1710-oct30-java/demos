package com.bank.accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable
{
	private String name;
	private String password;
	
	List<Integer> accID = new ArrayList<>();
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public List<Integer> getAccID()
	{
		return accID;
	}
	public void setAccID(List<Integer> accID)
	{
		this.accID = accID;
	}
	
	
}
