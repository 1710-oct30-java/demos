package com.revature.javacore.question20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/*
	Create a notepad file called Data.txt and enter the following:

	Mickey:Mouse:35:Arizona
	Hulk:Hogan:50:Virginia
	Roger:Rabit:22:California
	Wonder:Woman:18:Montana
	
	Write a program that would read from the file and print it out to the screen in the
	following format: 
	
	Name: Mickey Mouse
	Age: 35 years
	State: Arizona State
 */

public class Question20
{
	
	private static String fileName = "src/com/revature/javacore/question20/Data.txt";
	private static File file = new File(fileName);
	
	private static List<Person> list = new ArrayList<Person>();
	
	public static void main(String[] args)
	{
		createFile();
		readFile();
		displayList();
	}

	
	// Method creates file it doesn't exist and writes data to the file
	// It writes the data once, upon creation of file
	public static void createFile()
	{
		FileOutputStream fos;
		BufferedWriter bw;
		
		String data = "Mickey:Mouse:35:Arizona\n" + 
					  "Hulk:Hogan:50:Virginia\n" + 
					  "Roger:Rabit:22:California\n" + 
					  "Wonder:Woman:18:Montana\n";
		
		try
		{
			// Create file if it doesn't exist and write data to file
			if (!file.exists())
			{
				// Create file
				fos = new FileOutputStream(file);
				fos.close();
				
				// Write data to file
				bw = new BufferedWriter(new FileWriter(fileName));
				bw.write(data);
				bw.close();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	// Methods read the file and creates a new person based on the file data
	public static void readFile()
	{
		BufferedReader bw;
		
		try
		{
			bw = new BufferedReader(new FileReader(file));
			
			String line = "";
			String result = "";
			
			// Read data from text file to string result
			while( (line = bw.readLine()) != null)
			{
				result += line + ":";
			}
			
			// Split result string into an array of strings
			String[] arr = result.split(":");
			
			// Loop through array to get data and create a person
			// Then add person to the list
			// Increment loop by 4 as each person has 4 fields of information
			for(int i = 0; i < arr.length; i += 4)
			{
				Person p = new Person(arr[i], arr[i+1], Integer.parseInt(arr[i+2]), arr[i+3]);
				list.add(p);
			}
			
			bw.close();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Displays the list in correct format
	public static void displayList()
	{
		for(Person p:list)
		{
			System.out.println(p);
		}
	}
}
