package question3;
/*
 * Reverse a string without using a temporary variable. Do not use reverse() in 
 * StringBuffer or the StringBuilder APIs.
 */
public class QuestionThree 
{
	public static void main(String[] args)
	{
		StringBuilder aString = new StringBuilder("Hello");
		
		System.out.println(aString);
		aString.append("olleH");
		
		aString.delete(0, 5);
		
		System.out.println(aString);			
	}
}
