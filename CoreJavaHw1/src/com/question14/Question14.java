package com.question14;

import java.util.Calendar;

// Write a program that demonstrates the switch case. Implement the following functionalities in the cases...

public class Question14
{
	public static void main(String[] args)
	{
		myMethod(1);
		myMethod(2);
		myMethod(3);
	}
	
	static void myMethod(int i)
	{
		switch (i)
		{
			case 1:
				// Find the square root of a number using the Math class method
				System.out.println(Math.sqrt(144.0));
				break;
			case 2:
				// Display today's date
				Calendar today = Calendar.getInstance();
				today.set(Calendar.HOUR_OF_DAY, 0);
				System.out.println(today.getTime());
				break;
			case 3:
				// Split the string and store it into a string array
				String[] strArr = "I am learning Core Java".split(" ");
				for (String s : strArr)
					System.out.println(s);
				break;
			default:
				break;
		}
	}
}
