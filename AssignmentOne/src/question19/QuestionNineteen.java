package question19;
/*
 * Create an ArrayList and insert integers 1 through 10. Display the 
 * ArrayList. Add all the even numbers up and display the result. Add 
 * all the odd numbers up and display the result. Remove the prime numbers
 * from the ArrayList and print out the remaining ArrayList.
 */
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

public class QuestionNineteen 
{
	public static void main(String[] args) {
		List<Integer> intList= new ArrayList<>();
		int evenSum = 0;
		int oddSum = 0;
		
		//Logger log = Logger.getRootLogger();
		
		//fills arraylist with numbers 1 through 10
		for (int i = 0; i<10;i++)
		{
			intList.add(i+1);
		}
		//prints arraylist
		System.out.println(intList);
		//adds all even numbers into evenSum
		for (int i = 0; i<10; i++)
		{
			if (intList.get(i)%2 == 0)
			{
				evenSum += intList.get(i);
			}
		}
		//prints sum of all evens from 1 to 10
		System.out.println("The sum of all evens 1 through 10 is: "+evenSum);
		// adds all odd numbers in the array into oddSum
		for (int i = 0; i<10; i++)
		{	
			if (intList.get(i) == 1)
			{
				oddSum += intList.get(i);
			}
			else if (intList.get(i) % 2 != 0)
			{
				oddSum += intList.get(i);
			}
		}
		//prints sum of all odds 1 to 10
		System.out.println("The sum of all odds 1 through 10 is: "+oddSum);
		
		//removes all primes from the arraylist
		for (int i=0; i<intList.size(); i++)
		{
			if (isPrime(intList.get(i)))
			{
				intList.remove(i);
//				log.trace("Trace");
				i--;
			}
		}
		//prints list without primes
		System.out.println("List without primes: "+intList);
	}
	public static boolean isPrime(int num)
	{
		for (int i = 2; i<num; i++)
		{
			if (num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
