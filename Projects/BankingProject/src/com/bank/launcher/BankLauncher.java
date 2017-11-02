package com.bank.launcher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bank.auth.PopData;

public class BankLauncher
{
	public static void main(String[] args)
	{
		PopData data = new PopData();
		
		Map<String, String> temp = new HashMap<>();
		
		
		System.out.println("LOGIN PAGE");
		Scanner input = new Scanner(System.in);
		System.out.print("Username (case insensitive): ");
		String username = input.nextLine().toLowerCase();
		System.out.print("Password: ");
		String password = input.nextLine();
		
		if(data.valUser(username, password))
		{
			System.out.println("LOGGED IN");
		}
		else
		{
			System.out.println("INVALID");
		}
		//temp.put("randy", "1303");
		data.setUserpass("randy","1303");
		
		
		data.logOut();
		

		
	}
}
