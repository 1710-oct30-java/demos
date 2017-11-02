package question8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList
 * "karan","madam","torn","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"
 */
public class Question8 {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("karan", "madam", "torn", "civic", "radar", "sexes", "jimmy", "kayak",
				"john", "refer", "billy", "did");

		System.out.println("We will now proceed through the list of: ");
		input.stream().forEach(System.out::println);
		System.out.println("and return only the palindromes.");
		List<String> output = palindrome(input);
		System.out.println("The returned list is: ");
		output.stream().forEach(System.out::println);
	}

	private static List<String> palindrome(List<String> list) {
		// Return the list that only contains palindromes
		return list.stream().filter(i -> isPalindrome(i)).collect(Collectors.toList());
	}

	private static boolean isPalindrome(String s) {
		// check first and last characters
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			// if the characters are the same then proceed
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
				// otherwise then it's not a palindrome
			} else {
				return false;
			}

		}
		return true;
	}

}
