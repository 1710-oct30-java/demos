package question5;

import java.util.Scanner;

/***
 * Write a substring method that accepts a string str and an integer idx and
 * returns the substring contained between 0 and idx-1 inclusive.
 */
public class Q5 {

	public static void main(String[] args) {

		System.out.println("Please enter some text");

		Scanner scan = new Scanner(System.in);

		String userString = scan.nextLine();

		System.out.println("Enter the index to where you want to shorten the String to");

		int userIdx = scan.nextInt();

		System.out.println(subStringMeth(userString, userIdx));

	}

	public  static String subStringMeth(String str, int idx) {
		
		String newStr= str.substring(0, idx);
		
		return newStr;
		
		
	}

}
