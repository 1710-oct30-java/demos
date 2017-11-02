package assignment1;

public class Question3
{
	// Reverse a string without using a temporary variable. Do not use reverse() in the StringBuffer or StringBuider APIs.
	public static void main(String[] args)
	{
		// Initialize and print starting string to console.
		String str = "!dlrow olleH";
		System.out.println(str);
		
		// Reverse the string by moving the first character to the end until all character have been moved. The state of the
		// string is output to the console at each step.
		for(int x = 0; x < str.length()-1; x++)
		{
			str = str.substring(1, str.length() - x) + str.substring(0, 1) + str.substring(str.length() - x, str.length());
			System.out.println(str);
		}
	}
}