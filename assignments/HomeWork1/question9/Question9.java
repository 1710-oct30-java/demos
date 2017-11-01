package question9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console
 */
public class Question9{
	public static void main(String[] args) {
		List<Integer> numbers = (ArrayList<Integer>)IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
		sieveOfEratosthenes(numbers);
	}
	
	private static void sieveOfEratosthenes(List<Integer> numbers)
	{
		//For each number in the sieve.  If differentNumber % number == 0: delete differentNumber.
		//1 is not a prime number for some mathematical reason
		numbers.remove(0);
		int i = 0;
		while(i != numbers.size())
		{
			for(int j = i+1; j < numbers.size(); j++)
			{
				if(numbers.get(j) % numbers.get(i) == 0)
					numbers.remove(j);
			}
			i++;
		}
		numbers.stream().forEach(System.out::println);
	}

}
