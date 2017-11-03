package com.revature.question20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * Create a notepad file called Data.txt and enter the following
 * 
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to the
 * screen in the following format
 * Name: Mickey Mouse
 * Age: 35 years
 * State:Arizona State
 */
public class Question20 {

	public static void main(String[] args) {

		// create a bufferReader to read from the data file
		Scanner data;
		try {
			data = new Scanner(new File("Data.txt"));
			while (data.hasNext()) {
				String line = data.nextLine();
				String[] info = line.split(":");
				System.out.println("Name: " + info[0] + " "+ info[1]);
				System.out.println("Age: " + info[2]);
				System.out.println("State: " + info[3]);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		
	}

}
