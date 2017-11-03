package question13;

public class Question13 {
	// Display the triangle on the console as follows using
	// any type of loop. Do NOT use a simple group of print
	// statements to accomplish this.
	//
	// 0
	// 1 0
	// 1 0 1
	// 0 1 0 1
	public static void main(String[] args) {
		// Initialize starting state of output.
		String output = "";

		// Initialize array of 0s and 1s to be inserted.
		String[] inserts = { "0", "1", "1", "0" };

		// Inserts the 0s and 1s into the list depending on
		// whether the index is even or odd.
		for (int x = 0; x < 4; x++) {
			if (x % 2 == 0) {
				output = output + inserts[x];
			} else {
				output = inserts[x] + output;
			}
			System.out.println(output);
		}
	}
}