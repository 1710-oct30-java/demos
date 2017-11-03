package question10;

/**
 * Question 10: Find the minimum of two numbers using ternary operators.
 * @author Mitch Goshorn
 *
 */
public class TernaryMin {

	/**
	 * Return the lesser value using a ternary operation
	 * @param x - first input value
	 * @param y - second input value
	 * @return minimum value
	 */
	public static int minTernary(int x, int y) {
		return x > y ? y : x;
	}
	
	public static void main(String[] args) {
		int x = 5;
		int y = 7;
		
		System.out.println("Min value: " + minTernary(x, y));
		
	}
	
}
