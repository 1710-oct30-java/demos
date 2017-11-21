//Author: Micah West
//Date: 11/01/2017
//Purpose: Place a set of strings into an ArrayList, then put all the palindromes in a different ArrayList
//		   Solution to Question 8.
//Included files: ArrayListLauncher.java
//Input: none
//Output: The list of strings: [karan, madam, tom, civic, radar, sexes, jimmy, kayak, john, refer, billy, did]
//		  Contains these palindromes: [madam, civic, radar, sexes, kayak, refer, did]

package com.revature.corejava.Q08;

import java.util.ArrayList;
import java.util.List;

public class PalindromeList {
	
	public static void main(String[] args) {
		
		List<String> stringList = new ArrayList<String>();
		List<String> palindromeList = new ArrayList<String>();
		
		stringList.add("karan");
		stringList.add("madam");
		stringList.add("tom");
		stringList.add("civic");
		stringList.add("radar");
		stringList.add("sexes");
		stringList.add("jimmy");
		stringList.add("kayak");
		stringList.add("john");
		stringList.add("refer");
		stringList.add("billy");
		stringList.add("did");
		
		System.out.println("The list of strings: " + stringList.toString());
		
		for(String ele: stringList) {
			
			if(isPalindrome(ele))
			{
				palindromeList.add(ele);
			}
		}
		
		System.out.println("Contains these palindromes: " + palindromeList.toString());
	}
	
	public static boolean isPalindrome(String input) {
		
		int middleIndex = input.length() / 2;
		
		for(int i = 0; i <= middleIndex; i++) {
			
			if(input.charAt(i) != input.charAt(input.length()-1-i)) {
				
				return false;
			}
		}
		
		return true;
	}
	
}
