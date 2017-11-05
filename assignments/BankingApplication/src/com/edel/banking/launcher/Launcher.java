package com.edel.banking.launcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.edel.banking.account.Account;
import com.edel.banking.account.AccountType;
import com.edel.banking.account.CheckingAccount;
import com.edel.banking.account.SavingsAccount;
import com.edel.banking.application.Application;
import com.edel.banking.application.OpenAccount;
import com.edel.banking.bank.Bank;
import com.edel.banking.login.Login;
import com.edel.banking.serialization.Deserialize;
import com.edel.banking.serialization.Serialize;
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
		/*
		Bank bank = new Bank();
		
		// Initial test values
		User batman = new User("Bruce", "Wayne", "batman@gmail.com", "batman");
		User spiderman = new User("Peter", "Parker", "spiderman@gmail.com", "spiderman");
		User flash = new User("Barry", "Allen", "flash@gmail.com", "flash");
		User daredevil = new User("Matthew", "Murdock", "daredevil@gmail.com", "daredevil");
		User arrow = new User("Oliver", "Queen", "arrow@gmail.com", "arrow");
		
		Account acc1 = new CheckingAccount(flash, 50000);
		bank.openAccount(acc1);
		
		Account acc2 = new SavingsAccount(flash, 300000);
		bank.openAccount(acc2);
		
		Account acc3 = new CheckingAccount(arrow, 2000);
		bank.openAccount(acc3);
		
		Account acc4 = new CheckingAccount(daredevil, 1000);
		bank.openAccount(acc4);
		
		Account acc5 = new CheckingAccount(spiderman, 50);
		bank.openAccount(acc5);
		
		Account acc6 = new SavingsAccount(batman, 2000000);
		bank.openAccount(acc6);
		
		Account acc7 = new CheckingAccount(batman, 125000);
		bank.openAccount(acc7);
		*/
		//Serialize accounts and users
		//Serialize.serializeAccounts();
		//Serialize.serializeUsers();
		
		// Start application
		Application.start();
	}
}
