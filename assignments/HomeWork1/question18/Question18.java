package question18;

/*
 * Write a program having a concrete subclass that inherits three abstract methods
 * form a superclass.  Provide the following three implementations in the subclass
 * corresponding to the abstract methods in the superclass:
 * 1. Check for uppercase characters in a string, and return 'true' or 'false' depending on if any are found.
 * 2. Convert all of the lower case characters to uppercase in the input string, and return the result.
 * 3. Convert the input string to integer and add 10, output the result to the console;
 */
public class Question18 extends Question18Abstract{

	@Override
	public boolean checkForUpperCase(String str) {
		//check each char in the string. if one char is uppercase then return true;
		for(char c : str.toCharArray())
		{
			if(Character.isUpperCase(c))
				return true;
		}
		return false;
	}

	@Override
	public String makeThatUpperCase(String s) {
		//return the string in its uppercase glory
		return s.toUpperCase();
	}

	@Override
	public void convertString(String s) {
		//parse the string
		int parsed = Integer.parseInt(s);
		//print out parsed string incemented by 10
		System.out.println(parsed + 10);
	}
	public static void main(String[] args) {
		Question18 test = new Question18();
		
		//Debug's to make sure this works
		System.out.println(test.checkForUpperCase("i am sneakily Hiding that h"));
		System.out.println(test.makeThatUpperCase("i was once a poor lowercase string"));
		test.convertString("10");
	}
}
//This is my abstract class
abstract class Question18Abstract{
	public abstract boolean checkForUpperCase(String s);
	public abstract String makeThatUpperCase(String s);
	public abstract void convertString(String s);
}
