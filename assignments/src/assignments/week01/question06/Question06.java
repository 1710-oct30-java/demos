package assignments.week01.question06;

public class Question06 {
	public static void main(String[] args) {
		
		/*
		 * test integer
		 */
		int data = 10891;
		
		if ( isEven( data ) ) {
			System.out.println( data + " is even");
		} else {
			System.out.println( data + " is odd");
		}
	}
	
	/**
	 * return true if an integer is even
	 * without using the modulus operator
	 * 
	 * @param int value
	 * 
	 * @return boolean
	 */
	public static boolean isEven(int value )
	{
		String val = Integer.toString(value, 2); // convert integer to it's binary value and store as a string
		int strLen = val.length();
		
		/*
		 * number was even if the last character of the string
		 * of its binary representation is 0
		 */
		return ( val.charAt( strLen - 1) == '0' );
	}
}
