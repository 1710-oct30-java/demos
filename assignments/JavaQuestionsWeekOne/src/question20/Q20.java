package question20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q20 {

	/*
	 * Create a notepad file called Data.txt and enter the following:
	 * Mickey:Mouse:35:Arizona 
	 * Hulk:Hogan:50:Virginia 
	 * Roger:Rabbit:22:California
	 * Wonder:Woman:18:Montana
	 * 
	 * Write a program that would read from the file and print it out to the screen
	 * in the following format: 
	 * Name: Mickey Mouse 
	 * Age: 35 years 
	 * State: Arizona State
	 */

	public static void main(String[] args) throws IOException {
		//Set up text file.
		FileWriter fw = new FileWriter("info.txt");		
		fw.write("Mickey:Mouse:35:Arizona \n");
		fw.write("Hulk:Hogan:50:Virginia \n");
		fw.write("Roger:Rabbit:22:California \n");
		fw.write("Wonder:Woman:18:Montana \n");
		fw.close();
		
		
	
		BufferedReader br = new BufferedReader(new FileReader("info.txt"));
		String line;
		
		//Iterate through each line. A single line contains the information for one entity.
		while ((line = br.readLine()) != null) {
			//The string is split up wit the ":" character.
			String[] values = line.split(":");
			System.out.println("Name: " + values[0] + " " + values[1]);
			System.out.println("Age: " + values[2] + " years");
			System.out.println("State: " + values[3] + " State");
			System.out.println();
		}
		
		br.close();
	}

}
