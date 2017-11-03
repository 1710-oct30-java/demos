package question4;

public class Question4 {
	// Write a program to compute n factorial.
	public static void main(String[] args) {
		// Initialize value n.
		int n = 5;

		// Initialize variable for storing our factorial computation.
		int factorial = 1;

		// Calculate factorial of variable n.
		for (int x = n; x > 0; x--) {
			factorial = factorial * n;
		}

		// Output answer to console.
		System.out.println("The factorial of " + n + " is " + factorial + ".");
	}
}