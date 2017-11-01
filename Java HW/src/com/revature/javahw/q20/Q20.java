// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 20

package com.revature.javahw.q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Q20. Create a notepad file called Data.txt and enter the following:
//			Mickey:Mouse:35:Arizona
//			Hulk:Hogan:50:Virginia
//			Roger:Rabbit:22:California
//			Wonder:Woman:18:Montana
//
//		Write a program that would read from the file and print
// 		out to the screen in the following format:
//			Name: Mickey Mouse
//			Age: 35 years
//			State: Arizona State

public class Q20 {
	
	public static void main(String[] args) {
		List<BasicInfo> characters = new ArrayList<BasicInfo>();
		
		try {
			Scanner input = new Scanner(new File("Data.txt"));
			
			while(input.hasNextLine()) {
				BasicInfo character = new BasicInfo();;
				String line = input.nextLine();
				character.setName(line.split(":")[0]+ " " +line.split(":")[1]);
				character.setAge(Integer.parseInt((line.split(":")[2])));
				character.setState(line.split(":")[3]);
				characters.add(character);
				System.out.println(character.toString());
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException e) {
			e.printStackTrace();
		}
	}

}
