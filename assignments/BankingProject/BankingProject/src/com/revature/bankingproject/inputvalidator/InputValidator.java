package com.revature.bankingproject.inputvalidator;

import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.revature.bankingproject.account.Account;
import com.revature.bankingproject.account.AccountView;

public class InputValidator {
	private static Logger log = Logger.getRootLogger();
	
	//Method for validating user input for the main page
	public static boolean mainPageValidInput(String input) {
		log.info("Validating Main Page Input");
		log.debug("User input is: " + input);
		if (input.length() > 1)
			return false;
		int inputNumber;
		try {
			inputNumber = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		if (inputNumber > 0 && inputNumber < 5) {
			log.debug(input + " deemed acceptable input for Main Page Input");
			return true;
		}
		return false;
	}
	//Method for validating user input for the landing page
	public static boolean validLandingInput(String input)
	{
		log.info("Validating Login Page Input");
		log.debug("User input is: " + input);
		if (input.length() > 1)
			return false;
		int inputNumber;
		try {
			inputNumber = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		if (inputNumber == 1 || inputNumber == 2 || inputNumber == 9) {
			log.debug(input + " deemed acceptable input for Login Page Input");
			return true;
		}
		return false;
	}
	//Method for validating user input for adding or withdrawing from an account
	public static String validateDollarAmount(String input)
	{
		log.info("Validating Dollar Amount");
		log.debug("User input is: " + input);
		if(input.matches("([1-9][0-9]*(\\.[0-9][0-9])?)"))
		{
			log.debug(input + " deemed an acceptable input for Dollar Amount");
			return input;
		}
		else
		{
			System.out.println("Invalid amount");
		}
		return null;
	}
	
	//check user input to ensure that only integers are being entered, unless checkForY then check for Y
	public static int validateAccountId(String input, boolean checkForY, List<Account> accounts)
	{
		log.info("Validating Account Id input");
		log.debug("User input : " + input + " Flag to check for Y/y : " + false);
		if(checkForY && (input.equals("y") || input.equals("Y")))
		{
			log.info("Viewing accounts and returning from validate Account ID");
			AccountView.viewAccounts(accounts, false);
			return -1;
		}
		else if(Stream.of(input.split("")).map(s -> s.charAt(0)).anyMatch(c -> !Character.isDigit(c)))
		{
			System.out.println("Invalid input!  Ensure you are only entering digits:");
			return -1;
		}
		log.debug(input + " deemed a valid input for Account ID");
		return Integer.parseInt(input);
	}
	
	// check user input for an a, an r or an enter
	public static String getAddOrRemove(String input)
	{
		log.info("Validating a, r, or nothing");
		log.debug("User input is " + input);
		if(input.length() == 0)
			return "back";
		else if(input.equals("a") || input.equals("r"))
		{
			log.debug("User input for getAddorRemove deemed valid");
			return input;
		}
		System.out.println("Invalid Input");
		return null;
	}
}
