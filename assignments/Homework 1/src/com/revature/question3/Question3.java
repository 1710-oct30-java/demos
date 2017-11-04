package com.revature.question3;

import java.util.Scanner;

public class Question3 {

	public void reverseString(String x) {

		int xCount = x.length();

		for (int i = (xCount - 1); i >= 0; --i)
			x = x + x.charAt(i);
		x = x.substring(xCount);

		System.out.println(x);
	}

	public static void main(String[] args) {

		String theString;
		Question3 reverseMyString = new Question3();
		Scanner userString = new Scanner(System.in);

		System.out.println("Please input a string you intend to reverse!");
		theString = userString.nextLine();
		System.out.println("The input string to be reverse is " + theString);
		reverseMyString.reverseString(theString);
		userString.close();
	}

}
