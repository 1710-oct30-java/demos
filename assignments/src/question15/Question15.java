package question15;

public class Question15 {
	// Write a program that defines an interface having the
	// following methods: addition, subtraction, multiplication,
	// and division. Create a class that implements this interface
	// and provides appropriate functionality to carry out the
	// required operations. Hard code two operands in a test class
	// having a main method that calls the implementing class.
	public static void main(String[] args) {
		// Initialize my integers for testing.
		int a = 15;
		int b = 3;

		// Initialize Calculator class which implements the Calculations interface.
		Calculator c = new Calculator();

		// Uses the interface implemented in the Calculator class and outputs the
		// results
		System.out.println("A equals " + a + ".");
		System.out.println("B equals " + b + ".");
		System.out.println("A plus B is " + c.addition(a, b) + ".");
		System.out.println("A minus B is " + c.subtraction(a, b) + ".");
		System.out.println("A times B is " + c.multiplication(a, b) + ".");
		System.out.println("A divided by B is " + c.division(a, b) + ".");
	}
}