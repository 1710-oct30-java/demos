package com.revature.bankingproject.account;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankingproject.inputvalidator.InputValidator;
import com.revature.bankingproject.user.User;

public class AccountCreateOrDestroy implements AccountCreateOrDestroyInterface {
	private static Logger log = Logger.getRootLogger();
	@Override
	//Primary Vew for Create or Destroy
	public void createOrDestroy(User self, Scanner scan) {
		log.info("User has entered create or destory");
		String input = null;
		do
		{
			System.out.println("Would you like too add (a) or remove (r) an account");
			System.out.println("Enter nothing to return to previous page");
			input = InputValidator.getAddOrRemove(scan.nextLine());
			if(input != null && input.equals("back"))
			{
				log.info("User returning to previous page");
				return;
			}
		}while(input == null);
		switch(input)
		{
		case("a"):
			addAccount(self.getAccounts(),self, scan);
			break;
		case("r"):
			removeAccount(self.getAccounts(), scan);
			break;
		}

	}
	//Primary method for adding an account
	public void addAccount(List<Account> accounts, User self, Scanner scan)
	{
		log.info("In addAccount");
		String type = getAccountType(scan);
		String amount = null;
		do
		{
			System.out.println("All accounts require money in them.  How much would you like to add to this account?");
			amount = InputValidator.validateDollarAmount(scan.nextLine());
		}while(amount == null);
		log.debug("Creating " + type + " account for: " + self.getEmail() + " with amount: " + amount);
		accounts.add(new Account(Account.userIdCount++, self, Double.parseDouble(amount), type));
		System.out.println("Account created! Thank you for your time");
		
	}
	//Method for Displaying and Returning the type of account
	private String getAccountType(Scanner scan)
	{
		log.info("Getting Account Type");
		String input = "";
		do
		{
			System.out.println("Which type of account would you like to open?");
			System.out.println("1: Savings Account");
			System.out.println("2: Checkings Account");
			input = scan.nextLine();
		}while(!input.equals("1") &&  !input.equals("2"));
		if(input.equals("1"))
			return "Savings Accounts";
		return "Checkings Account";
	}
	//Method for removing an account
	public void removeAccount(List<Account> accounts, Scanner scan)
	{
		log.info("Removing Account");
		System.out.println("Please Enter your Account ID");
		int accountId = AccountTools.getAccountId(accounts, false, scan);
		log.debug("Account ID is: " + accountId);
		boolean accountFlag = true;
		for(int i = 0; i < accounts.size(); i++)
		{
			if(accounts.get(i).getId() == accountId)
			{
				if(accounts.get(i).getBalance() > 0)
				{
					log.info("user account has money, unable to delete");
					accountFlag = clearAccount(accounts,accounts.get(i), scan);
				}
				if(accountFlag)
				{
					log.info("Removing user account");
					accounts.remove(accounts.get(i));
					return;
				}
				log.info("User did not delete account");
				return;
			}
		}
		System.out.println("I'm sorry we were unable to find an account with that ID");
	}
	//Method called if account still has money in it.  Used to clear the account
	private boolean clearAccount(List<Account> accounts, Account account, Scanner scan)
	{
		log.info("User in clearAccount");
		String input = "";
		System.out.println("This account currently has a balance of : " + account.getBalance());
		System.out.println("It is against our policy to remove accounts that contain money");
		do {
			System.out.println("Would you like to Withdraw (w) or Transfer (t) from this account? Please enter (c) to cancel");
			input = scan.nextLine();
		}while(!input.equals("w") && ! input.equals("t") && !input.equals("c"));
		switch(input)
		{
			//honestly have case w and case t in brackets so I can reuse signAndAmount
			case ("w"):
			{
				log.info("User attempting to withdraw from account");
				String[] signAndAmount = {"-", Double.toString(account.getBalance())};
				AccountTools.alterAmountInAccount(account, signAndAmount);
			}
				break;
			case ("t"):
			{
				log.info("User attempting to transfer from account");
				if(accounts.size() < 2)
				{
					System.out.println("I'm sorry but you have no other accounts to transfer to");
					return false;
				}
				Account accountToTransferTo = transferFromAccount(accounts, account, scan);
				String[] signAndAmount = {"+", Double.toString(account.getBalance())};
				AccountTools.alterAmountInAccount(accountToTransferTo, signAndAmount);
				signAndAmount[0] = "-";
				AccountTools.alterAmountInAccount(account, signAndAmount);
			}
				break;
			case ("c"):
				log.info("User cancelled clearing account");
				return false;
		}
		return true;
	}
	//Method for moving money from one account to another
	private Account transferFromAccount(List<Account> accounts, Account account, Scanner scan)
	{
		log.info("User in transferFromAccount");
		int accountId = -1;
		boolean correctId = false;
		do
		{
			do
			{
				System.out.println("Which account would you like to transfer to? Enter (y) to view your accounts");
				accountId = AccountTools.getAccountId(accounts, true, scan);
			}while(accountId == -1);
			for(int i = 0; i < accounts.size(); i++)
			{
				if(accounts.get(i).getId() == accountId)
				{
					log.debug("Returning user's account");
					return accounts.get(i);
				}
			}
			if(!correctId)
			{
				System.out.println("I'm sorry that is not your Account.");
			}
		}while(!correctId);
		return null;
	}
}
