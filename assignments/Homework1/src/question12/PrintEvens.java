package question12;

public class PrintEvens {
	public static void main(String[] args) {
		int[] numbers = new int[100];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		
		for(int number : numbers) {
			if(number % 2 == 0) {
				System.out.println(number);
			}
		}
	}
	
}
