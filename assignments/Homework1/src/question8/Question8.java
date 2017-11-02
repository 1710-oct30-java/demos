package question8;

import java.util.ArrayList;

/*
 * Write a program that stores the following strings in an ArrayList and saves all the
 * palindromes in another ArrayList
 * "karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"
 */

public class Question8 {
	
	// function to check if a word is a palindrome
	public static boolean isPal(String word) {
		
		// convert string to array of it's characters
		char[] charArray = word.toCharArray();
		int first = 0;
		int end = charArray.length - 1;
		
		// while the letters we are checking in the array arent
		// in the same position
		while(end>first) {
			
			// if the characters arent the same, fail
			if(charArray[first] != charArray[end]) {
				return false;
			}
			// increment the first position and decrement the later position
			first++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		//create an arrayList to hold the initial list of words
		ArrayList<String> wordArray = new ArrayList<>();
		
		wordArray.add("karan");
		wordArray.add("madam");
		wordArray.add("tom");
		wordArray.add("civic");
		wordArray.add("radar");
		wordArray.add("sexes");
		wordArray.add("jimmy");
		wordArray.add("kayak");
		wordArray.add("john");
		wordArray.add("refer");
		wordArray.add("billy");
		wordArray.add("did");
		
		// create new arrayList to hold the palindromes
		ArrayList<String> palArray = new ArrayList<>();
		
		// iterate through the original list and add palindromes to new list
		for(String word: wordArray) {
			if(isPal(word)) {
				palArray.add(word);
			}
		}
		
		System.out.println(palArray.toString());
	}

}
