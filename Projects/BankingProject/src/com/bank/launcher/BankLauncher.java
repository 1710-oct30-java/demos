package com.bank.launcher;

import java.util.Scanner;

import com.bank.auth.Login;
import com.bank.auth.PopData;

public class BankLauncher
{
	public static void main(String[] args)
	{
		PopData data = new PopData();
		Login login = new Login();
		String username,password;
		int choice = 0;
		
		System.out.println("LOGIN PAGE (username 0 to exit)");
		
		do
		{
		Scanner input = new Scanner(System.in);
		System.out.print("Username (case insensitive): ");
		username = input.nextLine().toLowerCase();
		if (username.equals("quit"))
		{
			data.logOut();
			System.out.println("GoodBye!");
			System.exit(0);
		}
		System.out.print("Password: ");
		password = input.nextLine();
		
		}while(!login.valUser(username, password,data.getUserpass()));
		
		
		System.out.println("ACCOUNT PAGE");
		
		//temp.put("randy", "1303");
		data.setUserpass("randy","1303");
		
		
		data.logOut();
		

		
	}
}
