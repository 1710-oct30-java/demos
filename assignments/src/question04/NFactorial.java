package question04;

/**
 * Question 4: Write a program to compute N factorial.
 * 
 * @author Mitch Goshorn
 *
 */
public class NFactorial {
	
	/**
	 * Get's n'th factorial
	 * @param n - input value
	 * @return - n!
	 */
	public static long getFactorial(long n) {
		if(n == 0) return 1;
		long factorial = n * getFactorial(n-1);
		return factorial;
	}
	
	public static void main(String[] args) {
		System.out.println(getFactorial(10L));
	}
}
