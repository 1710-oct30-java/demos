package question03;

public class Q3 {

	/*
	 * Reverse a string without using a temporary variable. Do NOT use reverse().
	 */

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Reverse");
		System.out.println(str);

		// We will continue to swap chars with their opposite, thus only needing to loop
		// until the midpoint of the string.
		for (int i = 0; i < str.length() / 2; i++) {
			//Insert the last untouched char at the farthest untouched point from the beginning of the string.
			//Then, delete the char that was "moved."
			str.insert(i, str.charAt(str.length() - 1 - i));
			str.deleteCharAt(str.length() - i - 1);
			
			//Insert the first untouched char at the farthest untouched point at the end. Then, delete the char.
			str.insert(str.length() - i, str.charAt(i + 1));
			str.deleteCharAt(i + 1);
		}

		System.out.println(str);
	}

}
