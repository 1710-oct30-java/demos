package q12;

public class EvenNumbers {
	public static void main(String[] args) {
		int[] Numbers = new int[100];

		for (int i = 0; i < Numbers.length; i++) {
			Numbers[i] = i + 1;
		}

		for (int i : Numbers) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}
}
