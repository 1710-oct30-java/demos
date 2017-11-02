package question5;

/*
 * Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.
 * Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs
 */
public class Question5 {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Not enough arguements");
			return;
		}
		// Grab the inputed string
		String str = args[0];
		// Grab the inputed integer
		int idx = Integer.parseInt(args[1]);
		System.out.println("you want to cut: " + str + " to length: " + idx);
		// Chop down the string and return into substring
		String substring = mySubstring(str, idx);
		System.out.println("The result is: " + substring);

	}

	private static String mySubstring(String str, int idx) {
		// Change the string into an array so we can get the substring
		char[] charArray = str.toCharArray();
		String returnstring = "";
		// just copy what's necessary
		for (int i = 0; i < idx; i++) {
			returnstring += charArray[i];
		}
		return returnstring;
	}
}
