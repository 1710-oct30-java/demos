package question13;

/**
 * Question 13: Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this.
 * 
 * Note: Second line seems to alternate the logical pattern. I'm assuming this was
 * accidental?
 * 
 * @author Mitch Goshorn
 *
 */
public class PrintTriangle {

	/**
	 * Prints a triangle given a specified depth
	 * @param depth - input depth
	 */
	public static void printTriangle(int depth) {
		for(int i = 0; i <= depth; i++) {
			printLine(i);
		}
	}
	
	/**
	 * Prints single line of triangle, given a y location
	 * Helper method to {@link printTriangle(int)}
	 * @param y
	 */
	private static void printLine(int y) {
		for(int x = 0; x < y; x++) {
			System.out.printf("%d ", zeroOrOne(x, y));
		}
		System.out.println();
	}
	
	/**
	 * Determines whether a value should be 0 or 1 given an x and y value
	 * @param x 
	 * @param y
	 * @return 0 or 1 for the xy location
	 */
	public static int zeroOrOne(int x, int y) {
		return x % 2 == 0 ^ y % 2 == 0 ? 0 : 1;
	}
	
	public static void main(String[] args) {
		printTriangle(4);
	}
	
}
