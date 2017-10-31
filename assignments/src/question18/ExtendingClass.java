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
public class ExtendingClass extends AbstractParent {

	@Override
	public boolean hasUppercase(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) return true;
		}
		return false;
	}

	@Override
	public String getUppercase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void outputPlus10(String str) {
		int intValue = Integer.valueOf(str);
		System.out.println(intValue + 10);
	}

	
}
