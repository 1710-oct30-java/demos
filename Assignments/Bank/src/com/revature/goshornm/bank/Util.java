package com.revature.goshornm.bank;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.apache.log4j.Logger;
import org.javamoney.moneta.format.CurrencyStyle;

public interface Util {
	
	public static Scanner scanner = new Scanner(System.in);
	public static Logger log = Logger.getRootLogger();
	MonetaryAmountFormat usFormat = MonetaryFormats.getAmountFormat(Locale.US);
	
	static final MonetaryAmountFormat format = MonetaryFormats
			.getAmountFormat(AmountFormatQueryBuilder.of(Locale.US)
			.set(CurrencyStyle.SYMBOL).build());
	
	/**
	 * Prompts user to enter a String. This method should only be used
	 * when expected data is String data and does not need to be converted 
	 * to another type.
	 * 
	 * @param prompt - Prompt 1, followed by line break
	 * @param inlinePrompt - Prompt 2, inline with user input
	 * @return user input String
	 */
	public static String promptForString(String prompt, String inlinePrompt) {		
		System.out.println(prompt);
		System.out.print(inlinePrompt + " ");
		String string = scanner.nextLine().trim();
		
		return string;
	}
	
	public static String promptForString(String prompt) {
		return promptForString(prompt, "");
	}
	
	/**
	 * Prompts for a password using a default prompt.
	 * Defers to {@link #promptForPasswordAsHash(String)}
	 * @return byte hash of password
	 * @throws NoSuchAlgorithmException - thrown if SHA-256 algorithm not found
	 */
	public static byte[] promptForPasswordAsHash() throws NoSuchAlgorithmException {
		return promptForPasswordAsHash("Please enter your password: ");
	}
	
	/**
	 * Prompts for a password using a specified prompt.
	 * @return byte hash of password
	 * @throws NoSuchAlgorithmException - thrown if SHA-256 algorithm not found
	 */
	public static byte[] promptForPasswordAsHash(String str) throws NoSuchAlgorithmException {

		System.out.println(str);
		
		String input = scanner.nextLine().trim();
		System.out.println();
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(
		input.getBytes(StandardCharsets.UTF_8));
		
		return hash;
	}
	
	/**
	 * Simple prompt for yes or no response from the user.
	 * @return true if user responds yes, false otherwise
	 */
	public static boolean promptYesOrNot() {
		String inputError = "Please input either 1 or 2";
		
		System.out.println("\t 1. Yes");
		System.out.println("\t 2. No");
		
		while(true) {
			String input = scanner.nextLine().trim().toLowerCase();
			
			//In case someone enters yes or no
			if(input.contains("yes") && !input.contains("no")) return true;
			if(input.contains("no") && !input.contains("yes")) return false;
			
			try {
				int value = Integer.valueOf(input);
				
				//If input is not a 1 or a 2
				if(value != 1 && value != 2) {
					
					//Show error and loop again
					System.out.println(inputError);
					continue;
				}
				//return true if 1, false otherwise
				return value == 1;
				
			} catch(NumberFormatException e) {
				//Input did not include yes or no, and did not map to an integer
				System.out.println(inputError);
				continue;
			}
		}
	}
	
	/**
	 * Converts a MonetaryAmount to a US localized string representation
	 * @param amount - MonetaryAmount to convert to a string
	 * @return string representation of MonetaryAmount
	 */
	public static String getCurrencyString(MonetaryAmount amount) {
		if(format.getAmountFormatContext() == null) log.debug("Amount format context was null on attempt to convert ot string.");
		return format.format(amount);
	}
	
	/**
	 * Load an account and return account object by looking it up using the accountID
	 * as provided by a user.
	 * @return Account object or null if account is not found
	 */
	public static Account getAccountFromUserByID() {
		Long accID = null;
		while(accID == null) {
			String input = promptForString("", "");
			try {				
				accID = Long.valueOf(input);
				if(accID == 0) return null; // User cancelled
			} catch(NumberFormatException e) {
				System.out.println("Malformed account number. Please check input or enter 0 to cancel.");
				accID = null;
				continue;
			}
			
			if(!Account.exists(accID)) {
				System.out.println("Unable to access account with account number " + accID );
				System.out.println("Please check account number and try again or enter 0 to cancel.");
				accID = null;
				continue;
			}
		}
		return Account.load(accID);	
	}
	
}
