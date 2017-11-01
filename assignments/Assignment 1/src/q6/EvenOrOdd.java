package q6;

public class EvenOrOdd {
	public static void main(String[] args) {
		double n = 9;
		// keep subtracting n by 2, if n becomes negative, it is odd, otherwise even
		while (n > 0) { 
			n -= 2;
			if (n == 0) {
				System.out.println("even");
			} else if (n < 0) {
				System.out.println("odd");
			}
		}
	}
}
