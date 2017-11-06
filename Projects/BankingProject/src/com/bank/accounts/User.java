package com.bank.accounts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable
{
	private String name;
	private String password;

	Map<Integer, Account> accList = new HashMap<>();

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
	public Map<Integer, Account> getAccList()
	{
		return accList;
	}
	public void addAccList(int id, Account acc)
	{
		accList.put(id, acc);
	}

}
