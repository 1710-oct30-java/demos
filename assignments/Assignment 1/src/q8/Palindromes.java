package q8;

import java.util.ArrayList;

public class Palindromes {

	public static boolean isPalindrome(String s) {
		boolean palindrome = true;
		// 2 pointers, one for start of string, one for end
		// keep increment head pointer by 1, decrement tail pointer by 1 until they meet
		// if at any time the character does not match, it is not a palindrome
		for (int i = 0, j = s.length() - 1; i < s.length() / 2 && j >= s.length() / 2; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				palindrome = false;
			}
		}
		return palindrome;
	}

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();

		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("sexes");
		strings.add("jimmy");
		strings.add("kayak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");

		for (String s : strings) {
			if (isPalindrome(s) == true) {
				palindromes.add(s);
			}
		}

		for (String s : palindromes) {
			System.out.println(s);
		}

	}
}
