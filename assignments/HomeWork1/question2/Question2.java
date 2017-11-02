package question2;

/*
 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0
 */
public class Question2 {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 1;
		// count is number of repetition through, however minus 2 because we will print
		// the first 2 in the main statement
		int count = 25 - 2;
		System.out.println("This will print out the first 25 Fibonacci numbers");
		// Hack to print out the first 2 numbers
		System.out.println("0\n1");
		fibbonacci(num1, num2, count);
		System.out.println("Fib Complete");
	}

	private static void fibbonacci(int num1, int num2, int count) {
		// if we are done with our program then exit
		if (count == 0)
			return;
		// temp is the new fibonacci number
		int temp = num1 + num2;
		System.out.println(temp);
		num1 = num2;
		num2 = temp;
		// run fibonacci again with the new numbers
		fibbonacci(num1, num2, --count);
	}
}
