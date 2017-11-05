package com.revature.question14;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class Question14 {
	public static void main(String[] args) {

		Scanner intScanner = new Scanner(System.in);
		System.out.println("Please enter an integer case number to check! (1, 2 or 3): ");
		int caseInt = intScanner.nextInt();

		switch (caseInt) {
		case 1:
			double squareRoot = Math.sqrt(9999999);
			System.out.println("Square Root of 9999999: " + squareRoot);
			break;

		case 2:
			Date outputDate = Calendar.getInstance().getTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println(dateFormat.format(outputDate));
			break;

		case 3:
			String inputString = "I am learning core java";
			String inputSplit[] = inputString.split(" ");
			System.out.println(inputString + "is now: " + Arrays.toString(inputSplit));
			break;
		}
		intScanner.close();
	}
}
