package question18;

public class Q18 {

	/*
	 * Write a program having a concrete subclass that inherits three abstract
	 * methods from a superclass. Provide the following three implementations in the
	 * subclass corresponding to the abstract methods in the superclass. 
	 * 1.Check for uppercase characters in a string, and return 'true' or 'false' depending if
	 * any are found. 
	 * 2.Convert all of the lower case characters to uppercase in the input string, and return the result. 
	 * 3.Convert the input string to integer and add 10, output the result to the console. 
	 */

	public static void main(String[] args) {
		Subclass sub = new Subclass();
		System.out.println(sub.checkForUppercase("Hello"));
		System.out.println(sub.checkForUppercase("hello"));
		System.out.println(sub.convertToUpper("Hello"));
		System.out.println(sub.addTenToString("12"));

	}

}
