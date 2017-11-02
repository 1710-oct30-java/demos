package question3;

/*
 * Q3. Reverse a string without using a temporary variable. Do Not use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class Question3 {

	public static void main(String[] args) {
		// If there is no input then we cannot proceed
		if (args.length < 1) {
			System.out.println("No string inputted");
			return;
		}
		String reversedString = myStringReverse(args[0]);
		System.out.println(reversedString);

	}

	// Since we can't use a temp variable we will use the only variable we have
	private static String myStringReverse(String stringToReverse) {
		// tack the reversed string onto the end of the original string
		for (int i = stringToReverse.length(); i > 0; i--) {
			stringToReverse += stringToReverse.charAt(i - 1);
		}
		// return only the reversed section of the string
		return stringToReverse.substring(stringToReverse.length() / 2);
	}
}
