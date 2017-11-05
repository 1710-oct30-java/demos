package com.bank.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bank.accounts.User;

public class Management
{
	private String username;
	private String password;
	private Scanner input = new Scanner(System.in);
	private List<String> uInput;
	
//	Page to enter username password and return
//	regardless of login or registration
	public List<String> firstPage()
	{
		uInput = new ArrayList<>();
		
		System.out.println("   • Username is case insensitive");
		System.out.print("USERNAME:\t");
		username = input.nextLine().toLowerCase();
		System.out.print("PASSWORD:\t");
		password = input.nextLine();
		
		uInput.add(username);
		uInput.add(password);
		return uInput;
	}
	

//	public List<String> regPage()
//	{
//		uInput = new ArrayList<>();
//		System.out.println("REGISTRATION PAGE");
//		System.out.print("Username to use: ");
//		input.nextLine().toLowerCase();
//		System.out.print("Password: ");
//		input.nextLine();
//		
//		uInput.add(username);
//		uInput.add(password);
//		return uInput;
//		
//	}
	
	public void controlPage(User user)
	{
		System.out.println("Welcome "+ user.getName());
	}
	
	
	public boolean valUser(Map<String, User> userPass)
	{
		if (userPass.containsKey(this.username))
		{
			if (userPass.get(username).getPassword().equals(this.password))
				return true;
			else
				return false;
		} else
			return false;
	}
}
