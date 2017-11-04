package question9;
/*
 * Create an ArrayList which stores numbers from 1 to 100
 * and prints out all the prime numbers to the console.
 */
import java.util.ArrayList;
import java.util.List;

public class QuestionNine 
{
	public static void main(String[] args) 
	{		
	List<Integer> arrList = new ArrayList<Integer>(100);
	
	for (int i = 0; i<100; i++)
	{
		arrList.add(i, i+1);
		printPrimes(arrList.get(i));
	}
	}
	public static void printPrimes(int n)
	{
		if (n%2==0)
		{
			return;
		}
		for (int i = 3; i*i<=n; i+=2)
		{
			if (n%i==0)
			{
				return;
			}
		}
		System.out.print(n+" ");
	}
}