package question02;

/**
 * Question 2: Write a program to display the first 25 Fibonacci numbers beginning with 0.
 * 
 * @author Mitch Goshorn
 *
 */
public class Fibonacci {
	private static final int FIRST = 0;
	private static final int SECOND = 1;
	
	/**
	 * Question 2: Write a program to display the first 25 Fibonacci numbers beginning at 0.
	 * @param fibonacci
	 */
	public static void fibonacci(int fibonacci) {
		int secondPrevious = FIRST;
		int firstPrevious = SECOND;
		
		int current = 0;
		
		for(int i = 1; i <= fibonacci; i++) {
			System.out.println(current);
			
			//Calculate next Fibonacci number
			current = secondPrevious + firstPrevious;
			
			//Assign new previous values
			secondPrevious = firstPrevious;
			firstPrevious = current;
		}
	}
	
	public static void main(String[] args)  {
		fibonacci(25);
	}
}
