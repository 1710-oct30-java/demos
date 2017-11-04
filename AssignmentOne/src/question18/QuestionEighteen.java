package question18;
/*
 * Write a program having a concrete subclass that inherits three
 * abstract methods from a superclass. Provide the following three
 * implementations in the superclass:
 * 1. Check for uppercase characters in a string, and return 'true' 
 * or 'false' depending if any are found.
 * 2. Convert all of the lower case characters to uppercase in the 
 * input string, and return the result.
 * 3. Convert the input string to integer and add 10, output the result
 * to the console.
 * Create an appropriate class having a main method to test the above setup.
 */
abstract class MySuperClass
{
	abstract boolean checkUpper(String a);
	abstract String returnUpper(String b);
	abstract int stringToInt(String c);
}
class MySubClass<Array> extends MySuperClass
{

	@Override
	boolean checkUpper(String a) {
		char[] arr = a.toCharArray();
		for (int i = 0; i<arr.length; i++)
		{
			char ch = arr[i];
			if (Character.isUpperCase(ch))
			{
				return true;
			}
		}
		return false;
	}

		@Override
		String returnUpper(String a) {
			char[] arr = a.toCharArray();
			char[] newArr = new char[arr.length];
			for (int i = 0; i<arr.length; i++)
			{
				char ch = arr[i];
				for (int j = 0; j<arr.length; j++)
				{ 
				char chNew = Character.toUpperCase(ch);
				chNew = newArr[j];
				}
			}
			String b = new String(newArr);
			return b;
		}

		@Override
		int stringToInt(String a) throws NumberFormatException{
			int result = Integer.valueOf(a);
			return result+10;
		}
		
	}