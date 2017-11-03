package question16;

public class Q16 {

	// Write a program to display the number of characters for a string input. The
	// string should be entered as a command line argument using (String[] args).

	public static void main(String[] args) {
		for (String string : args) {
			System.out.println("The String \"" + string + "\" is " + string.length() + " characters long.");
		}
	}

}
