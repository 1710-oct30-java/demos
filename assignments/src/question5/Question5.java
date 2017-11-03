package question5;

public class Question5 {
	// Write a substring method that accepts a string str and an index idx
	// and returns the substring contained between 0 and idx-1 inclusive.
	// Do NOT use any of the existing substring methods in the String,
	// StringBuilder or StringBuffer APIs.
	public static void main(String[] args) {
		// Initialize variable of starting string.
		String str = "Hai frens!";

		// Initial variable for index.
		int idx = 9;

		// Call the subString method and print the result to console.
		System.out.println(subString(str, idx));
	}

	// This method returns a substring of String str from index 0 to idx-1,
	// inclusive.
	public static String subString(String str, int idx) {
		String output = "";

		for (int x = 0; x <= idx; x++) {
			output = output + str.charAt(x);
		}
		return output;
	}
}