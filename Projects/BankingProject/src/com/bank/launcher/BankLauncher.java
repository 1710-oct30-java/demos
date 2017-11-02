package com.bank.launcher;

import java.util.Scanner;

import com.bank.auth.Registration;

public class BankLauncher
{
	public static void main(String[] args)
	{
		
		
		System.out.println("REGISTRATION PAGE");
		Scanner input = new Scanner(System.in);
		System.out.print("Username: ");
		String username = input.nextLine();
		System.out.print("Password: ");
		String password = input.nextLine();
		
		Registration reg = new Registration(username,password);
		
		System.out.println(reg);
	}
}
