//Author: Micah West
//Date: 10/31/2017
//Purpose: Given a data file with specified delimiters for data, print out profile information
//		   for people described by the file. Solves Question 20 in the Revature Core Java homework.
//Included files: ProfileLauncher.java, Profile.java, InvalidProfileFormatException.java, data.txt
//Input: Mickey:Mouse:35:Arizona
//Output: Name: Mickey Mouse
//        Age: 35 years.
//        State: Arizona
//[Input and output trimmed for example purposes.]

package com.revature.corejava.Q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProfileLauncher {
	
	public static void main(String[] args) {
		
		File inFile = new File("data.txt");
		
		// This try was originally placed here to prevent errors related to the missing file,
		// but I decided to go the extra mile and sort of idiot-proof the program to some degree.
		
		// The scanner is defined here so it can properly be closed and prevent resource leakage.
		// This is mainly because Eclipse was nagging me about it.
		try (Scanner fileScanner = new Scanner(inFile)) {
			
			while(fileScanner.hasNext()) {
				
				String[] aryLine = fileScanner.nextLine().split(":");
				//System.out.println(Arrays.toString(aryLine));
				
				if(aryLine.length != 4) {
					
					throw new InvalidProfileFormatException();
				}
				
				// I could just place these array fields into the constructor for Person, but
				// I would like to be abundantly clear what happens with the age field as its
				// conversion from String to primitive int can cause an exception.
				String firstName = aryLine[0];
				String lastName = aryLine[1];
				// This is done explicitly and there is a catch below for the case of this value
				// not being an actual number.
				int age = Integer.parseInt(aryLine[2]);
				String state = aryLine[3];
				
				Profile printedPerson = new Profile(firstName, lastName, age, state);
				printedPerson.displayPerson();
				System.out.println("");
			}
			
		}
		// If the third field in a given record is not a number, throw an error.
		catch (NumberFormatException e) {
			
			System.out.println("Data within the file did not contain the correct format. Data field format:\n"
							 + "firstName:lastName:age:state");
			e.printStackTrace();
		}
		// If there are not enough fields within in any given record, throw an error.
		catch (InvalidProfileFormatException e) {
			
			System.out.println("Data within the file did not contain the correct number of fields per record.\n"
							 + "Please ensure there are exactly four data fields separated by colons per line.");
			e.printStackTrace();
		}
		// If the file isn't found, throw an error.
		catch (FileNotFoundException e) {
			
			System.out.println("File \"data.txt\" not found. Please ensure the file exists and try again.");
			e.printStackTrace();
		}
		// Literally any other error is caught here.
		catch (Exception e) {
			
			System.out.println("Processing of data file failed. Please see the stack trace for details.");
			e.printStackTrace();
		}
	}
}
