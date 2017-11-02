package questionEight;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8 {

	// Write a program that stores all of the following strings in an ArrayList and
	// saves all the
	// palindromes in another ArrayList.

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar",
				"sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));

		ArrayList<String> palindromes = new ArrayList<String>();

		// Iterate through the strings, checking for palindromes.
		for (String string : strings) {
			if (palindromeCheck(string))
				palindromes.add(string);
		}

		// Print the results.
		for (String string : palindromes) {
			System.out.println(string);
		}

	}

	public static boolean palindromeCheck(String string) {
		/*
		 * The StringBuilder class is used for the reverse() method. Since
		 * StringBuilders can't be compared, it is converted back into a String.
		 */

		String reversed = new StringBuilder(string).reverse().toString();

		if (string.equals(reversed))
			return true;
		else
			return false;
	}

}
