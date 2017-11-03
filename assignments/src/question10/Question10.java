package question10;

public class Question10
{
	// Find the minimum of two numbers using ternary operators.
	public static void main(String[] args)
	{
		// Initialize two integer values for comparison.
		int a = 100;
		int b = 20;
		
		// Compare the two numbers and output to the console which one is smaller.
		System.out.println("Comparing the integers " + a + " and " + b + ".");
		int small = (a < b) ? a : b;
		System.out.println(small + " is the smaller integer.");
	}
}