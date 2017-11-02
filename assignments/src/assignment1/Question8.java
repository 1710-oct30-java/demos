package assignment1;

import java.util.ArrayList;

public class Question8
{
	// Write a program that stores the following strings in an ArrayList and saves all
	// the palindromes in another ArrayList.
	
	// "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",
	// "refer", "billy", "did"
	public static void main(String[] args)
	{
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
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
		
		System.out.println("The initial word list is " + words.toString() + ".");
		
		for(String s : words)
		{
			if(isPalindrome(s))
			{
				palindromes.add(s);
			}
		}
		
		System.out.println("The list of palindromes are " + palindromes.toString() + ".");
	}
	
	
	private static boolean isPalindrome(String s)
	{
		int l = s.length();
		
		for (int i = 0; i < (l/2); ++i)
		{
			if (s.charAt(i) != s.charAt(l - i - 1))
			{
				return false;
			}
		}
		return true;
	}
}