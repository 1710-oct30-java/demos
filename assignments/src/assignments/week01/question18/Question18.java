package assignments.week01.question18;

public class Question18 
{
	public static void main(String[] args) {
		StringWrapper wrapper = new StringWrapper();
		
		String[] tests = {
			"ThisHasUpperCaseLetters",
			"thisdoesnothaveuppercaseletters",
			"25"
		};
		
		/*
		 * loop through the test strings and
		 * test each function of the string wrapper
		 */
		for(String test: tests) {
			System.out.println( String.format("Testing string [%s]", test ) );
			System.out.println( String.format("has upper case letters: %b", wrapper.hasUppercaseLetters( test ) ) );
			System.out.println( String.format("with lowercase converted to upper: %s", wrapper.toUpper( test ) ) );
			System.out.println( String.format("converted to integer wtih 10 added: %d", wrapper.displayValuePlusTen( test ) ) );
			System.out.println("\n\n");
		}
		
	}
}
