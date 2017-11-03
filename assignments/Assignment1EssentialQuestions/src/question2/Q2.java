package question2;

/***
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class Q2 {

	public static void main(String[] args) {

		int[] fib = new int[25];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < fib.length; i++) {

			fib[i] = fib[i - 1] + fib[i - 2];
		}

		for (int i = 1; i <= fib.length; i++) {
			System.out.println(i + ": " + fib[i - 1]);
		}

	}

}
