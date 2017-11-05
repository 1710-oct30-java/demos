package com.revature.question8;

import java.util.List;
import java.util.ArrayList;

public class Question8 {

	public static boolean checkForPalindrome(String inputString) {

		int midPoint = inputString.length() / 2;
		for (int i = 0; i <= midPoint; i++) {
			if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		List<String> regularList = new ArrayList<String>();
		List<String> palindromeList = new ArrayList<String>();

		regularList.add("karan");
		regularList.add("madam");
		regularList.add("tom");
		regularList.add("civic");
		regularList.add("radar");
		regularList.add("sexes");
		regularList.add("jimmy");
		regularList.add("kayak");
		regularList.add("john");
		regularList.add("refer");
		regularList.add("billy");
		regularList.add("did");

		System.out.println("The list of strings: " + regularList.toString());

		for (String word : regularList) {
			if (checkForPalindrome(word)) {
				palindromeList.add(word);
			}
		}

		System.out.println("Contains these palindromes: " + palindromeList.toString());
	}
}
