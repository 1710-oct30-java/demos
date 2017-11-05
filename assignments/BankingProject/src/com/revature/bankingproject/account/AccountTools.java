package com.revature.bankingproject.account;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankingproject.tools.InputValidator;

public class AccountTools {
	private static Logger log = Logger.getRootLogger();

	//Used to get Account ID
	public static int getAccountId(List<Account> accounts, boolean checkForViewAccounts,Scanner scan)
	{
		String input = scan.nextLine();
		if(input.length() == 0)
			return -2;
		//Check the user input and if there are any characters that are not digits then fail and rerun method
		return InputValidator.validateAccountId(input,checkForViewAccounts, accounts);
	}
	
	//Method to increase or decrease the amount of money in an account
	public static void alterAmountInAccount(Account account, String[] signAndAmount)
	{
		log.debug("Current amount in account: " + account.getBalance());
		double amount = Double.parseDouble(signAndAmount[1]);
		
		switch(signAndAmount[0])
		{
		case ("+"):
			log.debug("Increasing amount in account");
			account.setBalance(account.getBalance() + amount);
			break;
		case("-"):
			log.debug("Decreasing amount in account");
			if(account.getBalance() < amount)
			{
				System.out.println("You cannot withdraw more than what's in your account");
				return;
			}
			else
			{
				account.setBalance(account.getBalance() - amount);
			}
			break;
		default:
			break;
		}
		log.debug("Amount in account: " + account.getBalance());
		
	}
}
