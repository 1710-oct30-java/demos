package question16;

/*
 * Write a program to display the number of characters for a string input. The string should
 * be entered as a command line argument using (String[] args).
 */
public class Question16 {

	public static void main(String[] args) {
		
		// iterates through commmand line arguments
		for(String arg: args) {
			
			// splits the strings that are given
			String[] strArray = arg.split("");
			
			// prints the size
			System.out.println("The size of the word is: " + strArray.length);
		}
	}

}
