/*
 * Question 8
 * Write a program that stores the following strings in an ArrayList and saves all the palindromes into another ArrayLis.t
 * "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question8;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSplit {
	public static ArrayList<String> initArrayList(String... strings) {
	    ArrayList<String> list = new ArrayList<String>();
	    
	    for (String i : strings) {
	        list.add(i);
	    }
	    return list;
	} //This method is kind of cool. I didn't like having a bunch of line item list.add() methods just to populate an array list.
	  //It will allow you to set an arraylist equal to this method on a single line list of strings to be loaded into an ArrayList.
	  //My intent here was to try and model array initialization with valuse: int[] myArray = new int[]{1, 2, 3, 4, 5};
	
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
		List<String> possiblePalindromeList = new ArrayList<String>();
		List<String> palindromeList = new ArrayList<String>();
		possiblePalindromeList = initArrayList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did");
		System.out.println("The list of strings: " + possiblePalindromeList.toString());

		for (String word : possiblePalindromeList) {
			if (checkForPalindrome(word)) {
				palindromeList.add(word);
			}
		}
		System.out.println("Contains these palindromes: " + palindromeList.toString());
	}
}