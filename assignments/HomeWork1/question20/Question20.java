package question20;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Q20.  Create a notepad file called Data.txt and enter the following:
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to the screen in the
 * following format:
 * 
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 */
public class Question20 {

	public static void main(String[] args) {
		//Get the absolute path to the file... I know this won't work on another computer unless it's set up identical
		Path data = Paths.get("C:\\Users\\TheOwner\\eclipse-workspaceJava\\HomeWork1\\src\\question20\\Data.txt");
		//try to read from the file
		try(BufferedReader reader = Files.newBufferedReader(data))
		{
			//line is our holder
			String line;
			//while there is stuff to read
			while((line = reader.readLine()) != null)
			{
				//split the line on the colons
				String[] parsed = line.split(":");
				//print out the line in the requested format
				PrintParsed(parsed);
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void PrintParsed(String[] parsed)
	{
		//Hard coded parsing
		System.out.println("Name: " + parsed[0] + " " + parsed[1]);
		System.out.println("Age: " + parsed[2] + " years");
		System.out.println("State: " + parsed[3] + " State");
	}
}
