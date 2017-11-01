package q2;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 25;
		int n1 = 0;
		int n2 = 1;
		int n3;
		System.out.print(n1 + " " + n2 + " ");

		// definition of a fibonacci, sum of previous 2 numbers
		for (int i = 0; i < n - 2; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(n3 + " ");
		}
	}
}
