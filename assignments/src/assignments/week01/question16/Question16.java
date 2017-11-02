package assignments.week01.question16;

public class Question16 
{
	public static void main(String[] args) {
		
		/*
		 * loop through the string arguments and display
		 * then number of characters in each argument
		 */
		for(String s: args) {
			System.out.println( String.format("[%s] has %d characters", s, s.length() ) );
		}
		
	}
	
}
