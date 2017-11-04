package com.revature.question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question20 {

	public static void main(String[] args) {
		
		// Declare the file path
		File f = new File("C:/Desktop/Data.txt");
		
		try {
			
			// Create a new Scanner object
			Scanner scan = new Scanner(f);
			
			// Read input from the file until
			// there is no more input to read
			while (scan.hasNextLine()) {
				
				// Scan each line of input and
				// store it into a String. Then,
				// call the split() method on the
				// string with the colon : as a delimiter
				String info = scan.nextLine();
				String[] strArray = info.split(":");
				
				// Store the values into variables
				String firstName = strArray[0];
				String lastName = strArray[1];
				String age = strArray[2];
				String state = strArray[3];
				
					// Print out the values in the appropriate format
					System.out.println("Name: " + firstName + " " + lastName);
					System.out.println("Age: " + age + " years");
					System.out.println("State: " + state + " State\n");
				
			}
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
