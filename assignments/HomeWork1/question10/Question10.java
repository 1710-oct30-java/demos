package question10;

/*
 * Q10. Find the minimum of two numbers using ternary operators
 */
public class Question10 {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("There are not enough arguements");
			return;
		}
		// Get the numbers
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);
		// Find the minimum of the numbers
		int minimum = findMin(first, second);
		System.out.println("the smaller of " + first + " and " + second + " is " + minimum);
	}

	private static int findMin(int first, int second) {
		return (first < second ? first : second);
	}

}
