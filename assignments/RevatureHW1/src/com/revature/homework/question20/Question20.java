package com.revature.homework.question20;

import java.io.BufferedReader;
import java.io.FileReader;
// Read data from a notepad file to console and format it
public class Question20 {
	public static void main(String[] args) throws Exception {
		
	try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
		   
		
		String line = null;
		// reads by line ands splits into a String array on colons
		   while ((line = br.readLine()) != null) {
		       String[] strArr = line.split(":");
		       System.out.println("Name: "+ strArr[0] +" "+strArr[1]);
		       System.out.println("Age: "+strArr[2]+" years");
		       System.out.println("State: "+strArr[3]+" State");
		   }
		}
	}
}
