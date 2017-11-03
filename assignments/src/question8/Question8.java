package question8;

import java.util.ArrayList;

public class Question8 {
	// Write a program that stores the following strings in an ArrayList and saves
	// all
	// the palindromes in another ArrayList.

	// "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",
	// "refer", "billy", "did"
	public static void main(String[] args) {
		// Create an ArrayList and add the initial set of words to it.
		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");

		// Create an ArrayList for containing the words determined to be palindromes.
		ArrayList<String> palindromes = new ArrayList<String>();

		// Print the initial list of words to the console.
		System.out.println("The initial word list is " + words.toString() + ".");

		// Loop through the initial word list and call the isPalindrome method on each
		// word. If isPalindrome returns true for a word, it adds it to the palindromes
		// ArrayList.
		for (String s : words) {
			if (isPalindrome(s)) {
				palindromes.add(s);
			}
		}

		// Print the final list of palindromes to the console.
		System.out.println("The list of palindromes are " + palindromes.toString() + ".");
	}

	// Determines if String s is a palindrome by looping through each character and
	// comparing
	// it to the character on the opposite end. If a mismatch is found, returns
	// false. Otherwise,
	// returns true.
	//
	// This example was taken from URL
	// https://stackoverflow.com/questions/8444710/java-way-to-check-if-a-string-is-palindrome
	// because why reinvent the wheel, right?
	private static boolean isPalindrome(String s) {
		int l = s.length();

		for (int i = 0; i < (l / 2); ++i) {
			if (s.charAt(i) != s.charAt(l - i - 1)) {
				return false;
			}
		}
		return true;
	}
}