package question8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Palindromes {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		Collections.addAll(words, "karan", "madam", "tom", "civic", "radar", "sexes", 
						   "jimmy", "kayak", "john", "refer", "billy", "did");
		
		ArrayList<String> palindromes = new ArrayList<>();
		
		for(String word : words) {
			StringBuilder potentialPalindrome = new StringBuilder(word);
			if(word.equals(potentialPalindrome.reverse().toString())) {
				Collections.addAll(palindromes, word);
			}
			
		}
		
		for(String palindrome : palindromes) {
			System.out.println(palindrome);
		}
	}
	
	
}
