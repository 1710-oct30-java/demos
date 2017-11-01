package com.question20;

/*
 * reading text from file and print formatted output
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question20
{
	public static void main(String[] args) throws IOException
	{
		FileReader iFile = new FileReader("C:\\Users\\randy\\Desktop\\demos\\assignments\\Assignment1\\src\\com\\question20\\info.txt");
		BufferedReader reader = new BufferedReader(iFile);
		String line;
		
		while((line = reader.readLine()) != null)
		{
			String[] info = line.split(":");
			System.out.println("Name: "+ info[0] + " " + info[1]);
			System.out.println("Age: "+ info[2]);
			System.out.println("State: "+ info[3]);
			System.out.println();
		}
		
		
		iFile.close();
	}
}
