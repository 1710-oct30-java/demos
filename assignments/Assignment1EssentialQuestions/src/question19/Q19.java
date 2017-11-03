package question19;

import java.util.ArrayList;

/***
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 * Add all the even numbers up and display the result. Add all the odd numbers
 * up and display the result. Remove the prime numbers from the ArrayList and
 * print out the remaining ArrayList.
 *
 */
public class Q19 {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			al.add(i + 1);
		}
		System.out.println(al);

		int evenSum = 0;
		int oddSum = 0;

		for (int i = 0; i < al.size(); i++) {
			if (al.get(i) % 2 == 0) {
				evenSum = evenSum + al.get(i);
			} else {
				oddSum = oddSum + al.get(i);
			}
		}

		System.out.println("Sum of even numbers is :" + evenSum);
		System.out.println("Sum of odd numbers is :" + oddSum);

	}

	public static boolean isPrime(int num) {

		return false;
	}

}
