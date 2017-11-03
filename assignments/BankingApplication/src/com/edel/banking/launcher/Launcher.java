package com.edel.banking.launcher;

import com.edel.banking.account.Account;
import com.edel.banking.account.CheckingAccount;
import com.edel.banking.user.User;

// Launcher class to test and run the application

/*
	TO DO:
	1) Users can log in
	2) Users can create/close bank accounts
	3) Users can deposit and withdraw
	4) Users/bank accounts will be serialized to a text file
 */

public class Launcher
{
	public static void main(String[] args)
	{
		User batman = new User("Bruce", "Wayne", "batman@gmail.com", "password");
		User spiderman = new User("Peter", "Parker", "spiderman@gmail.com", "spiderman");
		User flash = new User("Barry", "Allen", "flash@gmail.com", "flash");
		User daredevil = new User("Matthew", "Murdock", "daredevil@gmail.com", "daredevil");
		User arrow = new User("Oliver", "Queen", "arrow@gmail.com", "arrow");
		
		Account acc1 = new CheckingAccount(batman);
		Account acc2 = new CheckingAccount(daredevil);
		
		Account.openAccount(acc1);
		Account.openAccount(acc2);
		
		Account.displayAccounts();
	}
}
