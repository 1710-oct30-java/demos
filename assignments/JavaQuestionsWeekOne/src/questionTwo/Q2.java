package questionTwo;

public class Q2 {

	/*
	 * Write a program that displays the first 25 numbers in the Fibonacci sequence, starting with 0.
	 */
	
	public static void main(String[] args) {
		
		
		int first = 0;
		int second = 1;
		int current;
		
		System.out.println(first);
		System.out.println(second);
		
		for (int i = 0; i < 23; i++) {
			current = first + second;
			System.out.println(current);
			
			first = second;
			second = current;
		}
	}

}
