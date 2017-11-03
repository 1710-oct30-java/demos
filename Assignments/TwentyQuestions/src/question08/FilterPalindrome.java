package question08;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Question 8: Write a program that stores the following strings in an ArrayList
 * and saves palindromes in another ArrayList
 * 
 * "karan", "madam", "tom", "civic", "radar", "sexes",
			"jimmy", "kayak", "john", "refer", "billy", "did"
			
 * @author Mitch Goshorn
 *
 */
public class FilterPalindrome {

	private static String[] strArr = {"karan", "madam", "tom", "civic", "radar", "sexes",
			"jimmy", "kayak", "john", "refer", "billy", "did"};
	
	private static ArrayList<String> strings = new ArrayList<String>(Arrays.asList(strArr));
	/**
	 * Predicate for {@link filterPalindromes}
	 * Returns true when the string passed to the method is a palindrome
	 * @param str - input string
	 * @return true when str is a palidrome, false otherwise
	 */
	private static boolean isPalindrome(String str) {
		str = str.toLowerCase();
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - (i+1))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Filters an ArrayList of Strings for Palindromes, returning a list with only palindromes
	 * @param inputList - input ArrayList of Strings
	 * @return ArrayList with only palindromes of the input list
	 */
	public static ArrayList<String> filterPalindromes(ArrayList<String> inputList) {
		ArrayList<String> palindromes = new ArrayList<>();
		
		//Filter for predicate and add matching members to palindromes list
		inputList.stream()
				.filter(s -> isPalindrome(s))
				.forEach(s -> palindromes.add(s));
		
		//return list
		return palindromes;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> palindromes = filterPalindromes(strings);
		System.out.println(palindromes);
	}
	
}
