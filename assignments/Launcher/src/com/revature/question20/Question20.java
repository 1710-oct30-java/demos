package com.revature.question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question20 {

	public static void main(String[] args) {
		File f = new File("C:/Users/TSAProdigy/Desktop/Data.txt");
		
		try {
			Scanner scan = new Scanner(f);
			while (scan.hasNextLine()) {
				String info = scan.nextLine();
				String[] strArray = info.split(":");
				
				String firstName = strArray[0];
				String lastName = strArray[1];
				String age = strArray[2];
				String state = strArray[3];
				
					System.out.println("Name: " + firstName + " " + lastName);
					System.out.println("Age: " + age + " years");
					System.out.println("State: " + state + " State\n");
				
			}
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
