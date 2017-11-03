package question18;

/**
 * Tests implementation of {@link AbstractParent} & {@link ExtendingClass}
 * 
 * Question 18: Write a program having a concrete subclass that inherits three abstract methods
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
public class TestingClass {
	
	public static void main(String[] args){
		ExtendingClass extendingClass = new ExtendingClass();
		
		/*
		 * Testing values
		 */
		String hasUpperCase = 	"abcdefghijKlmnop";
		String hasntUpperCase = "abcdefghijklmnop";
		
		String toUpper = "this string should be uppercase";
		
		String intable = "350";
		
		int resultPlus10 = 360;
		
		/*
		 * Test output
		 */
		System.out.println("'"+hasUpperCase+"' has upper case: " + (extendingClass.hasUppercase(hasUpperCase) == true));
		System.out.println("'"+hasntUpperCase+"' has upper case: " + (extendingClass.hasUppercase(hasntUpperCase) == true));
	
		System.out.printf("'%s' to upper case -> '%s'%n", toUpper, extendingClass.getUppercase(toUpper));
		
		//Method is output only, so calling to test output
		System.out.println("Testing output for outputPlus10 - should be " + resultPlus10 + ":");
		extendingClass.outputPlus10(intable);
	}
}
