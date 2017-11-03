package question05;

/**
 * 
 * Question 5: Write a substring method that accepts a string str and an integer idx and 
 * returns the substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
 * substring methods in the String, StringBuilder, or StringBuffer APIs.
 * 
 * 
 * @author Mitch Goshorn
 *
 */
public class Substring {

	/**
	 * Returns a substring with indices between 0 (inclusive) and a passed integer (Exclusive)
	 * @param str - input string
	 * @param index - final index (exclusive)
	 * @return substring
	 */
	public static String substring(String str, int index) {
		String newString = "";
		
		//Adds each character from index 0 until index
		for(int i = 0; i < str.length() && i < index; i++) {
			newString += str.charAt(i);
		}
		
		return newString;
	}
	
	public static void main(String[] args) {
		String test0 = "test string";
		String test1 = "One more test string";
		String test2 = "too short test";
		
		System.out.println(substring(test0, 3));
		System.out.println(substring(test1, 12));
		System.out.println(substring(test2, 32));
	}
	
}
