package com.question08;

import java.util.ArrayList;
import java.util.List;
/*
 * stores palindromes in another arrayList
 */
public class Question8
{
	public static void main(String[] args)
	{
		String[] names = {"karan", "madam", "tom", "civic", "radar", "sexes",
				"jimmy", "kayak", "john", "refer", "billy", "did"};
		List<String> words = new ArrayList<String>();
		List<String> pals = new ArrayList<String>();

		// add array into array list
		for (int i = 0; i < names.length; i++)
		{
			words.add(names[i]);
		}
		
		//loop through each word
		for (String word : words)
		{
			//loop through first part of the string and compare to the second part
			for (int i = 0; i < word.length() / 2; i++)
			{
				if (word.charAt(i) != word.charAt(word.length()-i-1))
				{
					break;
				}
				if (i == (word.length()/2) -1)
					pals.add(word);
			}
		}
		
		for (String word : pals)
		{
			System.out.println(word);
		}
	}
}
