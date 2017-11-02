package assignments.week01.question03;

public class Question03 {

	public static void main(String[] args) 
	{
		/*
		 * generate inital data string
		 */
		String data = "abcdefghijklmnopqrstuvwxyz";
		
		System.out.println( "before reverse: " + data);
		System.out.println( "after reverse: " + reverseString( data ) );
	}
	
	/**
	 * reverse a string without using a temporary variable,
	 * or using the reverse API of StringBuilder or StringBuffer
	 * 
	 * @param String input
	 * @return String
	 */
	public static String reverseString(String input)
	{
		/*
		 * adding each character in a string to the end of the string
		 * but adding the characters in reverse order, starting with the
		 * last character and traversing down to the first
		 */
		for( int i = input.length(); i > 0; i-- ) {
			input += input.charAt(i - 1);
			
//			System.out.println(input);
		}
		
		/*
		 * return the second half of the string,
		 * which is the half containing the reversed
		 * characters of the first half
		 */
		return input.substring( ( input.length() / 2) );
	}
}
