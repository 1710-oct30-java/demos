package question6;
/*
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class Question6 {

	public static void main(String[] args) {
		
		if(args.length < 1)
		{
			System.out.println("No INPUT!");
			return;
		}
		int number = Integer.parseInt(args[0]);
		boolean isEven = evenChecker(number);
		System.out.println(number + " is even? " + isEven);
		
	}
	
	private static boolean evenChecker(int number)
	{
		//due to integers chopping off fractions we can tell if a number is even by checking if
		//the number divided by two and then multiplied by two is equal to the number
		return number == (number/2) * 2;
	}
}
