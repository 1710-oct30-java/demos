/*
 * Question 20
 * By: Brice Petty
 * Write a program that would read the file and print it out to the console:
 * Credit To:
 */

package com.revature.question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtFileReader {
	public static void main(String[] args) {
		Scanner fileScanner = new Scanner(System.in);
		File file = new File("Data.txt");
		
		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		fileScanner.useDelimiter(":|\r");
		
		try {
			while (fileScanner.hasNextLine()) {
				String name = fileScanner.next();
				name += " " + fileScanner.next();
				String age = fileScanner.next();
				String state = fileScanner.next();
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("State: " + state + " State\n");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}