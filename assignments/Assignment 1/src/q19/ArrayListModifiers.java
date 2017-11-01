package q19;

import java.util.ArrayList;

import q9.PrimeNumbers;

public class ArrayListModifiers {
	public static void main(String[] args) {
		int odd = 0;
		int even = 0;
		// add numbers to arraylist, if even sum them, if odd sum them
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				al.add(i);
				even += i;
			} else
				al.add(i);
			odd += i;
		}
		
		//reuse method from question 9 to detect prime, remove if it is

		for (int i = al.size() - 1; i > 0; i--) {
			if (PrimeNumbers.Prime(i + 1)) {
				al.remove(i);
			}
		}
		
		//remove 2
		
		al.remove(1);

		System.out.println("even sum: " + even);
		System.out.println("odd sum: " + odd);

		System.out.println("array without prime: ");
		for (int i : al) {
			System.out.print(i + " ");
		}

	}
}
