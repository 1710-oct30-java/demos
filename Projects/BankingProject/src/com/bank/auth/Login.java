package com.bank.auth;

import java.util.Map;

public class Login
{
	
	public boolean valUser(String username, String password, Map<String, String> userPass)
	{
		if (userPass.containsKey(username))
		{
			if (userPass.get(username).equals(password))
				return true;
			else
				return false;
		} else
			return false;
	}
}
