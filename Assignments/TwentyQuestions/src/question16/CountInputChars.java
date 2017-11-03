package question16;

/**
 * Write a program to display the number of characters for a string input. The string
 * should be entered as a command line argument using (String[] args).
 * 
 * @author Mitch Goshorn
 *
 */
public class CountInputChars {

	private static String noArgs = "No String argument provided.";
	private static String outputFormat = "Characters in '%s': %d%n";
	
	public static int count(String str) {
		return str.length();
	}
	
	public static void main(String[] args) {
		//Throw exception if user fails to supply arguments
		if(args.length == 0) throw new IllegalArgumentException(noArgs);
		
		for(String string : args) {
			System.out.printf(outputFormat, string, count(string));
		}
	
	}
}
