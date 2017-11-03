package com.revature.homework.question8;

import java.util.ArrayList;
import java.util.List;

// store strings in an array and those that are palindromes in a second array
public class Question8 {
public static void main(String[] args) {
	List<String> words = new ArrayList<>();
	List<String> palindromes = new ArrayList<>();
	
	// adds words to list
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
	
	for(int i=0; i<words.size(); i++) {
		if (isPalindrome(words.get(i))) {
			palindromes.add(words.get(i));
		}
	}
	
	System.out.println("List of words "+words.toString());
	System.out.println("List of palindromes "+palindromes.toString());

	
}
// checks if reverse is the same as the initial string (palindrome)
	public static boolean isPalindrome(String str) {
		String reverseStr = new StringBuilder(str).reverse().toString();
		if (str.equals(reverseStr)) return true;
		else return false;
	}

}
