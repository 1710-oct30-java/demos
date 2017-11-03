package com.revature.goshornm.bank;

import java.util.stream.Collectors;

import javax.money.CurrencyUnit;
import javax.money.MonetaryCurrencies;
import javax.money.UnknownCurrencyException;

public class CurrencyOptions implements Branchable {
	private static final CurrencyUnit DEFAULT_USD = MonetaryCurrencies.getCurrency("USD");
	
	public CurrencyUnit promptForChangeCurrencyFromDefault() {
		String noMatch = "Input did not match any currency. Please input selection again.";
		
		System.out.println("Would you like to set this account to use the default currency?"
				+ "\n\t Default Currency: USD");
		
		if(Util.promptYesOrNot()) return DEFAULT_USD;
		
		String[] currencies = listCurrencies();
		
		while(true) {
			String response = Util.promptForString("Please enter the desired currency code.").toUpperCase();
			
			CurrencyUnit currency = getCurrencyTypeAsIndex(response, currencies);
			if(currency != null) return currency;
			currency = getCurrencyTypeAsString(response);
			if(currency != null) return currency;

			System.out.println(noMatch);
			
		}
	}
	
	public CurrencyUnit getCurrencyTypeAsIndex(String input, String[] currencyTypes) {
		Integer value;
		//Catch input not formatted as integer
		try {
			value = Integer.valueOf(input);
		} catch(NumberFormatException e) {
			return null;
		}
		
		//Catch Integer input out of range
		if(value > currencyTypes.length+1 || value < 1) return null;
		Util.log.trace("User Selected currency: " + MonetaryCurrencies.getCurrency(currencyTypes[value-1]));
		//offset as we output as index+1
		return MonetaryCurrencies.getCurrency(currencyTypes[value-1]);
	}
	
	public CurrencyUnit getCurrencyTypeAsString(String input) {
		try {
			Util.log.trace("User Selected currency: " + MonetaryCurrencies.getCurrency(input));
			return MonetaryCurrencies.getCurrency(input);
		} catch(UnknownCurrencyException exception) {
			return null;
		}
	}
	
	@Override
	public int displayOptions() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static String[] listCurrencies() {
		String[] currencyTypes = MonetaryCurrencies.getCurrencies("")
				.stream()
				.map(u -> u.getCurrencyCode())
				.sorted()
				.collect(Collectors.toList())
				.toArray(new String[0]);
			
			for(int i = 1; i <= currencyTypes.length; i++) {
				System.out.printf("%3d. %s     ", i, currencyTypes[i-1]);
				if(i%8== 0) System.out.println();
			}
			System.out.println();
			return currencyTypes;
	}
}
