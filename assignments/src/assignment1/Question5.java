package assignment1;

public class Question5
{
	// Write a substring method that accepts a string str and an index idx
	// and returns the substring contained between 0 and idx-1 inclusive.
	// Do NOT use any of the existing substring methods in the String,
	// StringBuilder or StringBuffer APIs.
	public static void main(String[] args)
	{
		System.out.println(subString("Hai frens!", 9));
	}
	
	public static String subString(String str, int idx)
	{
		String output = "";
		
		for(int x = 0; x <= idx; x++)
		{
			output = output + str.charAt(x);
		}
		return output;
	}
}