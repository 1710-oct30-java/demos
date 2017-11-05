package com.revature.bankingproject.account;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankingproject.tools.InputValidator;

public class AccountDepositOrWithdraw implements AccountDepositOrWithdrawInterface {

	private static Logger log = Logger.getRootLogger();

	@Override
	// Primary view for handling deposits or Withdrawals
	public void depositOrWithdraw(List<Account> accounts, Scanner scan) {
		log.info("User in deposit or withdraw");
		int accountId = -1;
		do {
			System.out.println("Which account would you like to withdraw/deposit from? Enter y to see your accounts");
			System.out.println("Enter nothing to return to previous page");
			accountId = AccountTools.getAccountId(accounts, true, scan);
			if (accountId == -2)
				return;
		} while (accountId < 0);
		log.debug("Account given is: " + accountId);
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getId() == accountId) {
				log.info("Account found");
				handleMoney(accounts.get(i), scan);
				return;
			}
		}
		System.out.println("I'm sorry that is not your Account. Please try again Later");
	}

	// View to move money into or out of an account
	public static void handleMoney(Account account, Scanner scan) {
		String sign = null;
		double amount = 0;
		do {
			System.out.println("To withdraw from this account please enter a minus before the amount (i.e.) -10.49");
			System.out.println("To deposit to this account please enter a plus before the amount (i.e.) +10.49");
			String input = scan.nextLine();
			log.debug("user input is " + input);
			log.debug("input.charAt(0): " + input.charAt(0));
			if (input.substring(0, 1).equals("+") || input.substring(0, 1).equals("-")) {
				log.debug("input.substring(1) is : " + input.substring(1));
				String result = InputValidator.validateDollarAmount(input.substring(1));
				if (result != null) {
					sign = input.substring(0, 1);
					amount = Double.parseDouble(result);
				}
			}

		} while (sign == null);
		String[] signAndAmount = { sign, Double.toString(amount) };
		AccountTools.alterAmountInAccount(account, signAndAmount);
		log.debug(account.getBalance());
	}

}
