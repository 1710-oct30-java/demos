package com.question03;

// Q3. Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class Question3
{
	public static void main(String[] args)
	{
		String backwards = revString("Hello, my name is Chris.");
		System.out.println(backwards);
	}
	
	public static String revString(String str)
	{
		String newStr = "";
		
		// Parse the string in reverse order
		for (int i = str.length() - 1; i >= 0; i--)
			newStr += str.charAt(i); // Append char by char to the new string
			
		return newStr;
	}
}
