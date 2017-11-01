package q9;

public class PrimeNumbers {

	public static boolean Prime(int n) {
		boolean isPrime = true;
		double m = Math.ceil(Math.sqrt(n));
		for (double i = 2; i <= m; i++) {
			if ((n / i) % 1 == 0) {
				isPrime = false;
			}
		}
		return isPrime;

	}

	public static void main(String[] args) {
		for (int i = 2; i <= 100; i++) {
			if (i == 2) {
				System.out.println(i);
			} else if (Prime(i) == true) {
				System.out.println(i);
			}
		}
	}

}
