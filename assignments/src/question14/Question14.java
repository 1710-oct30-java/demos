package question14;

import java.time.LocalDateTime;

public class Question14 {
	// Write a program that demonstrates the switch case.
	// Implement the following functionalities in the cases:
	// Case 1: Find the square root of a number using the Math
	// class method.
	// Case 2: Display today's date.
	// Case 3: Split the following string and store it in a
	// string array.
	// "I am learning Core Java"
	public static void main(String[] args) {
		int choice = 3;
		switch (choice) {
		case 1:
			int num = 9;
			System.out.println("The square root of " + num + " is " + Math.sqrt(num) + ".");
			break;
		case 2:
			System.out.println("Today's date is " + LocalDateTime.now());
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] ary = str.split("\\s+");
			for (String s : ary) {
				System.out.println(s);
			}
			break;
		}
	}
}