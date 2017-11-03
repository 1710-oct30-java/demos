package question16;

public class Question16 {
	// Write a program to display the number of characters for a
	// string input. The string should be entered as a command
	// line argument using (String[] args).
	public static void main(String[] args) {
		// Initialize empty String for output.
		String output = "";

		// Takes all the arguments in args and adds them to output.
		// If multiple args are input, it will separate them by a
		// space.
		for (String s : args) {
			output = output + " " + s;
		}

		// Trims spaces off the end of the output string.
		output.trim();

		// Outputs the length of the output string.
		System.out.println("The length of the string \'" + output + "\' is " + output.length() + ".");
	}
}