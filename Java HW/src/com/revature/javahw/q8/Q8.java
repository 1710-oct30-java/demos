// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 8

package com.revature.javahw.q8;

import java.util.ArrayList;
import java.util.Arrays;

// Q8. Write a program that stores the following strings in an ArrayList
//     and saves all the palindromes in another ArrayList.

public class Q8 {
	public static void main(String[] args) {
		ArrayList<String> dictionary = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//used just to get the reverse function
		StringBuilder testSubject;
		
		for (int i = 0; i < dictionary.size(); i++) {
			testSubject = new StringBuilder(dictionary.get(i));
			
			//compares the original string to the newly reversed string
			if(dictionary.get(i).equals((testSubject.reverse().toString()))) {
				palindromes.add(testSubject.reverse().toString());
			}
		}
		
		System.out.println("Original dictionary: " + dictionary);
		System.out.println("Palindromes: " + palindromes);
	}
}
