package com.question08;

import java.util.ArrayList;
import java.util.List;

import com.question03.Question3;

/*	Write a program that stores the following strings in an ArrayList
  	and saves the palindromes in another ArrayList.
	"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak",
	"john", "refer", "billy", "did"
*/

public class Question8
{
	public static void main(String[] args)
	{
		List<String> wordList = new ArrayList<>();
		wordList.add("karan");
		wordList.add("madam");
		wordList.add("tom");
		wordList.add("civic");
		wordList.add("sexes");
		wordList.add("jimmy");
		wordList.add("kayak");
		wordList.add("john");
		wordList.add("refer");
		wordList.add("billy");
		wordList.add("did");
		
		List<String> palList = new ArrayList<>();
		
		// if it's a palindrome, add it to the new ArrayList
		for (String s : wordList)
		{
			if (isPal(s))
				palList.add(s);
		}
		
		System.out.println(palList.toString());
	}
	
	private static boolean isPal(String s)
	{
		// Reusing my string reversing method from question 3
		String backwards = Question3.revString(s);
		// palindromes will read the same backwards and forwards
		return s.equals(backwards);
	}
	
}
