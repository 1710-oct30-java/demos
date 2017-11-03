package com.revature.question14;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * Write a program that demonstrates the switch case
 * Implement functionalities:
 * Case 1: Find square root of a number using the Math class method
 * Case 2: Display today's date
 * Case 3: Split "I am learning Core Java" string and store it in a String array
 */

public class Question14 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter case 1 2 or 3: ");
		int caseNum = scanner.nextInt();

		switch(caseNum) {
		case 1 :
			double sq = Math.sqrt(69);
			System.out.println("The square root of 69 is: " + sq);
			break;
		case 2 :
			Date date = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
			System.out.println(sdf.format(date));
			break;
		case 3 :
			String s = "I am learning Core Java";
			String[] s2 = s.split(" ");
			List<String> sList = new ArrayList<String>();
			for (String split : s2) {
				sList.add(split);		
			}
			System.out.println(sList);
			break;
			
		}

	}

}
