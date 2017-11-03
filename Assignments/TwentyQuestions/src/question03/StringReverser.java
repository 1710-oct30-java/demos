package question03;

import java.util.stream.IntStream;

/**
 * Question 3: Reverse a string without using a temporary variable.
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 * 
 * @author Mitch Goshorn
 *
 */
public class StringReverser {
	
	/**
	 * Takes in a String in opposite order
	 * @param str - input string
	 * @return reverse of input string
	 */
	public static String reverse(String str) {
		/*for(int i = 0; i < str.length() / 2; i++) {
			str = swap(str, i, str.length() - (i+1));
		}*/
		
		char mychar = 'f';
		int charRep = mychar;
		String myString = String.valueOf(mychar);
		String stringFromInt = String.valueOf((char)charRep);
		
		System.out.println(myString);
		System.out.println(stringFromInt);
		//CHALLENGE: USE stream ~ .reduce()
		//EXTRA CHALLENGE: Make it 'better'
		
		return IntStream.range(0, str.length())
				.map(i -> (0) - i + (str.length()) - 1)
				.map(i -> str.charAt(i))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		        .toString();
		
		
		
		/* using .reduce */
//		return str.chars()
//				.map(i -> String.valueOf((char)i))
//				.reduce((acc, i) -> {
//						return acc = i + acc;
//				}).toString();
	}
	
	/**
	 * In place swap modified to be used on two indices in a String
	 * @param str - input string
	 * @param indexOne - first index value
	 * @param indexTwo - second index value
	 * @return string with values at two index positions swapped
	 * @deprecated - Refactored out of {@link reverse(String)}
	 */
	public static String swap(String str, int indexOne, int indexTwo) {
		str = str.substring(0, indexOne)   +  
				(char)(str.charAt(indexOne) + str.charAt(indexTwo))   +   
				str.substring(indexOne+1);		
		
		str = str.substring(0, indexTwo)   +   
				(char)(str.charAt(indexOne) - str.charAt(indexTwo))
				+ str.substring(str.length() - (indexOne));
		
		str = str.substring(0, indexOne)   +  
				(char)(str.charAt(indexOne) - str.charAt(indexTwo))   +   
				str.substring(indexOne+1);	
		return str;
	}
	
	public static void main(String[] args) {
	
		String stringA = "cats";
		String stringB = "password";
		String stringC = "abcdefghi";
		
		System.out.println(reverse(stringA));
		System.out.println(reverse(stringB));
		System.out.println(reverse(stringC));
	}
}