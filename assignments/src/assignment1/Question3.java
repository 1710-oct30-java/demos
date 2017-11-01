package assignment1;

public class Question3
{
	// Reverse a string without using a temporary variable. Do not use reverse() in the StringBuffer or StringBuider APIs.
	public static void main(String[] args)
	{
		String str = "!dlrow olleH";
		System.out.println(str);
		
		for(int x = 0; x < str.length(); x++)
		{
			str = str.substring(1, str.length() - x) + str.substring(0, 1) + str.substring(str.length() - x, str.length());
		}
		
		System.out.println(str);
	}
}