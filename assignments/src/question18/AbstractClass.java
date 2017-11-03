package question18;

public abstract class AbstractClass {
	// Check for uppercase characters in a string, and return
	// 'true' or 'false' depending if any are found.
	abstract boolean checkForUpper(String s);
	
	// Convert all of the lower case characters to uppercase
	// in the input string and return the result.
	abstract String toUpper(String s);
	
	// Convert the input string to integer and add 10, output the
	// result to the console.
	abstract void addTen(String s);
}