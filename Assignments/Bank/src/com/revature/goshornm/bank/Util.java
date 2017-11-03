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
	
	public static String promptForString(String prompt, String string2) {		
		System.out.println(prompt);
		System.out.print(string2 + " ");
		String string = scanner.nextLine().trim();
		
		return string;
	}
	
	public static String promptForString(String prompt) {
		return promptForString(prompt, "");
	}
	
	public static byte[] promptForPasswordAsHash() throws NoSuchAlgorithmException {
		String prompt = "Please enter your password: ";
		System.out.println(prompt);
		
		String input = scanner.nextLine().trim();
		System.out.println();
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(
		input.getBytes(StandardCharsets.UTF_8));
		
		return hash;
	}
	
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
	
	public static String getCurrencyString(MonetaryAmount amount) {
		if(format.getAmountFormatContext() == null) System.out.println("It's nulllllllll");
		return format.format(amount);
	}
	
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
