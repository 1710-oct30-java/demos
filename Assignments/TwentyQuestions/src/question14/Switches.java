package question14;

import java.util.Date;

/**
 * Question 14: Write a program that demonstrates the switch case. Implement the
 * following functionalities in the cases:
 * 
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today's date.
 * Case 3: Split the following string and store it in a string array.
 * 		"I am learning Core Java"
 * 
 * @author Mitch Goshorn
 *
 */
public class Switches {

	public static void main(String[] args) {
		int switchedValue = 3;
		
		//value for case 1
		int number = 36;
		
		switch(switchedValue) {
		//Case 1: Find the square root of a number using the Math class method.
		case 1: 
			System.out.println(Math.sqrt(number));
			break;
		case 2:
			//Case 2: Display today's date.
			//Create date object (Defaults to current date and time)
			Date date = new Date();
			System.out.println(date);
			break;
		case 3:
			/* Case 3: Split the following string and store it in a string array.
			 * 		"I am learning Core Java" */
			String toSplit = "I am learning Core Java";
			String[] strArr = toSplit.split(" ");
			for(String string : strArr) {
				System.out.println(string);
			}
		}
	}
}
