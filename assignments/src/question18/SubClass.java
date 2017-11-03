package question18;

public class SubClass extends AbstractClass {

	// Check for uppercase characters in a string, and return
	// 'true' or 'false' depending if any are found.
	@Override
	boolean checkForUpper(String s) {
		for(char c : s.toCharArray())
		{
			if(Character.isUpperCase(c))
			{
				return true;
			}
		}
		return false;
	}

	// Convert all of the lower case characters to uppercase
	// in the input string and return the result.
	@Override
	String toUpper(String s) {
		return s.toUpperCase();
	}

	// Convert the input string to integer and add 10, output the
	// result to the console.
	@Override
	void addTen(String s) {
		int i = Integer.parseInt(s);
		System.out.println(i+10);	
	}
}