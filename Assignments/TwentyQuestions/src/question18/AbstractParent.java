package question18;

/**
 * Write a program having a concrete subclass that inherits three abstract methods
 * from a superclass. Provide the following three implementations in the subclass
 * corresponding to the abstract methods in the superclass:
 * 
 * 1) Check for uppercase characters in a string, and return 'true' or 'false'
 * 		depending if any are found.
 * 2) Convert all the lower case characters to uppercase in the input string,
 * 		and return the result.
 * 3) Convert the input string to integer and add 10, output the result to the console.
 * 
 * Create an appropriate class having a main method to test the above setup.
 * 
 * @author Mitch Goshorn
 *
 */
public abstract class AbstractParent {

	/**
	 * 1) Check for uppercase characters in a string, and return 'true' or 'false'
	 * 		depending if any are found.
	 * 
	 * @param str - input str
	 * @return true if has uppercase characters, false otherwise
	 */
	public abstract boolean hasUppercase(String str);
	
	/**
	 * 2) Convert all the lower case characters to uppercase in the input string,
	 * 		and return the result.
	 * @param str - input string
	 * @return str converted to uppercase
	 */
	public abstract String getUppercase(String str);
	
	/**
	 * 3) Convert the input string to integer and add 10, output the result to the console.
	 * @param str - input string
	 */
	public abstract void outputPlus10(String str);
	
}
