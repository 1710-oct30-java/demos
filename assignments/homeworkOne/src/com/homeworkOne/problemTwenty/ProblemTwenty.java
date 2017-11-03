package com.homeworkOne.problemTwenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProblemTwenty {
//Read in from a file and display in specified format
	public static void main(String[] args) throws IOException {
		//Open file
		FileReader in = new FileReader("Data.txt");
		BufferedReader br = new BufferedReader(in); 
		//Init variables
		String people; 
		String[] person;
		//Read from file
		while((people = br.readLine()) != null) {
			//Format and print
			person = people.split(":");
			System.out.println("Name: "+ person[0] + " " + person[1]);
			System.out.println("Age: " + person[2] + " years");
			System.out.println("State: " + person[3] + " State\n");
				
		} 
		in.close(); 
		} 
	}
