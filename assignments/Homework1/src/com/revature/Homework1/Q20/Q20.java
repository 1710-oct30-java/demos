package com.revature.Homework1.Q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20 {
	//read a data file and print out stuff
	public static void main(String[] args) {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("Data.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (reader != null) {
			while (reader.hasNextLine()) {
				String[] input = reader.nextLine().split(":");
				System.out.println("\nName: " + input[0]+ " " + input[1]);
				System.out.println("Age: " + input[2]+ " Years");
				System.out.println("State: " + input[3]+ " State");
			}
		}

	}

}
