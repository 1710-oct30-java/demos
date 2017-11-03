package question20;

import java.io.BufferedReader;
import java.io.FileReader;

public class Question20 {
	// Create a notepad file called Data.txt and enter the
	// following:
	//
	// Mickey:Mouse:35:Arizona
	// Hulk:Hogan:50:Virginia
	// Roger:Rabbit:22:California
	// Wonder:Woman:18:Montana
	//
	// Write a program that would read from the file and print it
	// out to the screen in the following format.
	//
	// Name: Mickey Mouse
	// Age: 35 years
	// State: Arizona State
	public static void main(String[] args) {
		String filename = "Data.txt";
		String line = null;
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
                String[] output = line.split(":");
                System.out.println("Name: " + output[0] + " " + output[1]);
                System.out.println("Age: " + output[2] + " years");
                System.out.println("State: " + output[3] + "state");
			}
			br.close();
		}
		catch (Exception e) {
			System.out.println("Bad stuff happened when reading from the file. Sorry, bro.");
		}
	}
}