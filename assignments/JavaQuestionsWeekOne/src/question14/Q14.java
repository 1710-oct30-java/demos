package question14;

import java.time.LocalDate;

public class Q14 {

	/*
	 * Write a program that demonstrates the switch case. Implement the following
	 * functionalities in the cases: Case 1: Find the square root of a number using
	 * the Math class method. Case 2: Display today's date. Case 3: Split the
	 * following string and store it in a string array. "I am learning Core Java"
	 */

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {

			switch (i) {
			case 0:
				double num = 12.54;
				num = Math.sqrt(num);
				System.out.println(num);
				break;
			case 1:
				System.out.println("Today's date: " + LocalDate.now());
				break;
			case 2:
				String str = "I am learning Core Java";
				// Split the array from the "i" character.
				String[] strArray = str.split("i");
				System.out.println(strArray[0]);
				System.out.println(strArray[1]);
				break;
			default:
				break;
			}
		}
	}

}
