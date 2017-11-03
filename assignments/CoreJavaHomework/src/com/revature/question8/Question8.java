package com.revature.question8;

import java.util.ArrayList;

/*
 * Write a program that stores the following strings
 * in an ArrayList and saves all the palindromes in another 
 * ArrayList. 
 * 
 * "karan", madam, tom, civic, radar, sexes, jimmy, kayak, john, 
 * refer, billy, did
 */
public class Question8 {
	
	public static void main(String[] args) {
		//ArrayList to save all the strings
		ArrayList<String> strings = new ArrayList<>();
		//add all of the strings to the list
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
		
		//Create an array list to save all of the palindromes from the other list
		ArrayList<String> palindromes = new ArrayList<>();
		
		//go through the original list and check if the elements in the list are palindromes
		//if the element is a palindrome add it to the palindromes list
		
		for(int i = 0; i < strings.size(); i++) {
			if(palindrome(strings.get(i))) {
				palindromes.add(strings.get(i));
			}
		}
		
		System.out.println(palindromes.toString());
		
	}
	
	//a word is a palindrome if it reads the same backwards as forwards
	public static boolean palindrome(String str) {
		//if the string is of length 0 or 1 return true
		if(str.length() <= 1) {
			return true;
		}else {
			//compare the first and last character of the string if they are the same
			//compare the rest of the string characters 
			if(str.charAt(0) == str.charAt(str.length() - 1)) {
				return palindrome(str.substring(1, str.length() - 1));
			}
		}
		
		return false;
	}

}
