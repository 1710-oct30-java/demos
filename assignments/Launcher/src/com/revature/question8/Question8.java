package com.revature.question8;

import java.util.ArrayList;

public class Question8 {
	
	public static String reverse(String s) {
	
	// convert the string to a character arrays
	char[] cArray = s.toCharArray();
	int startIndex = 0;
	int endIndex = cArray.length-1;
	char temp;
	
	// reverse the string
	while (startIndex < endIndex) {
		temp = cArray[startIndex];
		cArray[startIndex] = cArray[endIndex];
		cArray[endIndex] = temp;
		startIndex++;
		endIndex--;
	}
	return new String(cArray);
	}
	
	
	public static void main(String[] args) {
		
		// Create the regular ArrayList and the
		// palindrome ArrayList
		ArrayList<String> myList = new ArrayList<String>();
		ArrayList<String> palindList = new ArrayList<String>();
		
		myList.add("karan");
		myList.add("madam");
		myList.add("tom");
		myList.add("civic");
		myList.add("radar");
		myList.add("sexes");
		myList.add("jimmy");
		myList.add("kayak");
		myList.add("john");
		myList.add("refer");
		myList.add("billy");
		myList.add("did");
		
		// add a reversed version of the string
		// from the original ArrayList to the
		// palindrome ArrayList
		for (int i = 0; i < 12;i++) {
			palindList.add(reverse((myList.get(i))));
		}
		
		// priint out the two ArrayLists
		System.out.println(myList);
		System.out.println(palindList);
	}
}
