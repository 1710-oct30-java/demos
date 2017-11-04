package question2;
/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0 
 */
public class QuestionTwo 
{
	public static void main(String[] args)
	{
		int firstNumber=0;
		int secondNumber=1;
		int sum = 0;
		int count = 25;
		
		//print the first two numbers 0 and 1
		System.out.println(firstNumber);
		System.out.println(secondNumber);
		
		//begin fibonacci sequence starting at 2 since 0 and 1 have already been printed
		for(int i=2; i<count; ++i)
		{
			sum = firstNumber+secondNumber;
			System.out.println(sum);
			firstNumber=secondNumber;
			secondNumber=sum;
		}
			
	}
}
