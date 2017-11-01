package com.revature.javacore.question18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter extends Convert
{

	// Check for uppercase characters in a string, and return 'true' or 'false' depending
	// if any are found.
	@Override
	public boolean hasUpperCase(String str)
	{
		// Regular expression used to match string
		String regex = "[A-Z]+";
		
		// Compile regular expression
		Pattern pattern = Pattern.compile(regex);
		
		// Match string with regular expression
		Matcher matcher = pattern.matcher(str);
		
		// Return true or false if string has an upperCase
		return matcher.find();
	}

	// Convert all of the lower case characters to uppercase in the input string, and
	// return the result.
	@Override
	public String toUpperCase(String str)
	{
		/*
		String result = "";
		
		// Iterate the entire string
		for(int i = 0; i < str.length(); i++)
		{
			// Change only the characters that are lowercase
			if(Character.isLowerCase(str.charAt(i)))
			{
				char ch = Character.toUpperCase(str.charAt(i));
				result += ch;
			}
			
			// Else append to string
			else
			{
				result += str.charAt(i);
			}
		}
		*/
		
		return str.toUpperCase();
	}

	// Convert the input string to integer and add 10, output the result in the console.
	@Override
	public void convertToIntAndAddTen(String str)
	{
		try
		{
			// Parses string input to an integer
			// Removes anything that is not a digit from the string
			int input = Integer.parseInt(str.replaceAll("[^\\d]+", ""));
			
			input += 10;
			
			System.out.println(input);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
	}

}
