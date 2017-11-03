package question2;

//Write a program that displays the first 25 numbers of the Fibonacci Sequence starting from 0

public class Fibonacci {
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int sum;
		
		System.out.println(a);
		System.out.println(b);
		for(int i = 0; i < 23; i++) {
			sum = a + b;
			System.out.println(sum);
			a = b;
			b = sum;
		}
		
	}
}
