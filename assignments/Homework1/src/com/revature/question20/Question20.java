package com.revature.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Create a notepad file called Data.txt
 * Enter following:
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to the screen in the format
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 * 
 * 
 */
public class Question20 {

	public static void main(String[] args) {

		String fr = "Data.txt";
		String line = null;

		try {
			
			FileReader fileReader = new FileReader("C:\\Users\\iaust\\eclipse-workspace\\Homework1\\src\\com\\revature\\question20\\Data.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				
				String[] newString = line.split(":");
				System.out.println("Name: " + newString[0] + " " + newString[1]);
				System.out.println("Age: " + newString[2] + " years");
				System.out.println("State: " + newString[3] + " State");
				
				

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
