package question2;

/*
 * Kyle Settles
 * Write a program to display the first 25 Fibonacci numbers beginning at 0
 */

public class Question2 {

	public static int fibonacci(int n) {
		
		// base case 1
		if(n == 0) {
			return 0;
		}
		
		// base case 2
		else if(n == 1) {
			return 1;
		}
		
		// recursive call
		else {
			return fibonacci(n-1) + fibonacci(n-2) ;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(25));
	}
}