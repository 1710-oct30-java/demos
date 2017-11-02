package com.revature.javacore.question8;

import java.util.ArrayList;

/*
 	Write a program that stores the following strings in an ArrayList and saves all the 
	palindromes in another ArrayList.
	"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", 
	"refer", "billy", "did"
 */

public class Question8 {

	private static String[] array = {
				"karan", "madam", "tom", "civic", "radar", "sexes",
				"jimmy", "kayak", "john", "refer", "billy", "did"
			};
	
	private static ArrayList<String> list = new ArrayList<>();
	private static ArrayList<String> palindromelist = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		// Add strings to ArrayList
		addToList(array);
		
		// Print out original ArrayList
		System.out.print("List: ");
		displayList(list);
		
		// Print out palindrome ArrayList
		System.out.print("Palindrome List: ");
		displayList(palindromelist);
	}
	
	// Method adds all words from array to ArrayList and adds palindrome words to PalindromeArrayList
	public static void addToList(String[] array)
	{
		// Iterate original array of string words
		for(String word:array)
		{
			// Add words to ArrayList
			list.add(word);
			
			// Check if word is palindrome, then add to the palindrome ArrayList
			if(isPalindrome(word))
			{
				palindromelist.add(word);
			}
		}
	}
	
	// Method displays the words in the ArrayList given
	public static void displayList(ArrayList<String> list)
	{
		int counter = 0;
		
		for(String word:list)
		{
			// Don't print comma on last word
			if(counter == list.size()-1)
			{
				System.out.print(word);
				counter++;
			}
			else
			{
				System.out.print(word + ", ");
				counter++;
			}
		}
		System.out.println();
	}
	
	// Method returns true or false if string is a palindrome
	public static boolean isPalindrome(String s)
	{
		// Middle index of string
		int middle = s.length() / 2;
		
		// Assign begin and end strings to compare
		String begin = s.substring(0, middle);
		String end = s.substring(middle+1, s.length());
		
		// Reverse end string to match begin string
		StringBuilder sb = new StringBuilder(end);
		end = sb.reverse().toString();
		
		// If both strings are equal, the string is a palindrome
		if(begin.equals(end))
		{
			return true;
		}
		
		return false;
	}

}
