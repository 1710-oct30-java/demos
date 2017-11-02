package question18;

import java.util.Scanner;

/*
 * inherits three abstract methods from a superclass that executes these:
 * check if uppercase in a string, return bool
 * convert all lower case characters to uppercase in input string and return
 * convert the input string to integer and add 10, return to console
 */
public class Question18 extends Question18Super {
	
	// checks to see if a character is uppercase, then returns true immediately
	@Override
	public boolean checkUpper(String word) {
		System.out.println("The word is: " + word);
		for(int i = 0; i < word.length(); i++) {
			char myChar = word.charAt(i);
			boolean hasUpper = Character.isUpperCase(myChar);
			if(hasUpper) {
				return true;
			}
		}
		return false;
	}

	// converts all characters to lowercase
	@Override
	public String convertLower(String word) {
		String newStr = word.toUpperCase();
		System.out.println(newStr);
		return newStr;
	}

	// method handles if string is actually integer or if user inputs something else
	@Override
	public int addToInt(String num) {
		if(num.matches("^\\d+(\\.\\d+)?")) {
			int number = Integer.parseInt(num);
			return number + 10;
		}
		else {
			return -9999;
		}
	}

	public static void main(String[] args) {
		
		Question18 tester = new Question18();
		
		Scanner sc = new Scanner(System.in);
		
		// test method 1
		System.out.println("Test checkUpper method: ");
		System.out.println("Please enter a word, with or without uppercase");
		String test1 = sc.nextLine();
		System.out.println("Has uppercase: " + tester.checkUpper(test1));
	
		// test method 2
		System.out.println("Test convertLower method: ");
		System.out.println("Please enter a word to convert all lowercase to uppercase");
		String test2 = sc.nextLine();
		System.out.println("Uppercase version of word: " + tester.convertLower(test2));
		
		// test method 3
		System.out.println("Test addToInt method: ");
		System.out.println("Enter a number to add to 10: ");
		String test3 = sc.nextLine();
		if(!test3.equals("-9999")) {
			System.out.println("Not a number please enter a number: ");
			test3 = sc.nextLine();
		}
		System.out.println("Total is: " + tester.addToInt(test3));
	}
}
