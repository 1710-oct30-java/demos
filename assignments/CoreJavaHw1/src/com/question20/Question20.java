package com.question20;

import java.io.File;
import java.util.Scanner;

// Q20. Write a program that would read from the file and print it out to the screen in the following format...

public class Question20
{
	public static void main(String[] args)
	{
		try
		{
			Scanner scnr = new Scanner(System.in);
			File file = new File("Data.txt");
			scnr = new Scanner(file);
			
			// Match colon or carriage return
			scnr.useDelimiter(":|\r");
			
			// Scan file and print values
			while (scnr.hasNextLine())
			{
				String name = scnr.next();
				name += " " + scnr.next();
				String age = scnr.next();
				String state = scnr.next();
				
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("State: " + state + " State\n");
			}
			scnr.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
