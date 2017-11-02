package question4;

/*
 * Kyle Settles
 * Write a program to compute N factorial.
 */

public class Question4 {
	
	// perform the factorial operation
	public static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		else {
			return n *factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(10));
	}
}