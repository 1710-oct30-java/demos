package com.revature.goshornm.bank;

import java.util.Scanner;

/**
 * Implementing classes are interfaceable through branching dialogue options.
 * Support is provided through methods to display options and get input.
 * @author Mitch Goshorn
 *
 */
public interface Branchable {
	
	
	/**
	 * Gets an integer input from the user between the range of 1 and max
	 * @param max - maximum option value 
	 * @return users selected option
	 */
	default int getInput(int max) {
		String inputError = "Please input an integer corresponding to your desired option or ? to redisplay options.";
		
		Scanner scanner = Util.scanner;

		while(true) {
			String input = scanner.nextLine().trim();			
			if(input.contains("?")) {
				displayOptions();
				continue;
			}
			try {
				int value = Integer.valueOf(input);
				if(value > max) {
					System.out.println("Selection out of range.");
				}
				return value;
			} catch(NumberFormatException e) {
				System.out.println(inputError);
				continue;
			}
		}
	}
	
	default int getInput(int max, String str) {
		String inputError = "Please input an integer corresponding to your desired option or ? to redisplay options.";
		
		Scanner scanner = Util.scanner;

		while(true) {
			String input = scanner.nextLine().trim();			
			if(input.contains("?")) {
				System.out.println(str);
				continue;
			}
			try {
				int value = Integer.valueOf(input);
				if(value > max || value <= 0) {
					System.out.println("Selection out of range.");
					continue;
				}
				return value;
			} catch(NumberFormatException e) {
				System.out.println(inputError);
				continue;
			}
		}
	}
	
	/**
	 * Displays branching option choices for this view and returns the 
	 * maximum option value, which is needed for the {@link #getInput(int)} method
	 * @return total options provided
	 */
	int displayOptions();
}
