package questionThree;

public class Q3 {

	/*
	 * Reverse a string without using a temporary variable. Do NOT use reverse().
	 */

	public static void main(String[] args) {
		String str = new String("Reverse");
		System.out.println(str);

		for (int i = 0; i < str.length(); i++) {

			// Place the ending segment at the front, and the front segment at the end.
			// Ignore any portion that has already been moved.
			str = str.substring(str.length() - 1 - i, str.length() - i) 
					+ str.substring(i + 1)
					+ str.substring(i, i + 1);
			System.out.println(str);
		}
	}

}
