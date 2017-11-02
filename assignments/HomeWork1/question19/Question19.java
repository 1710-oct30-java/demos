package question19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
 * the even numbers up and display the result. Add all the odd numbers up and display the
 * result.  Remove the prime numbers from the ArrayList and print out the remaining
 * ArrayList.
 */
public class Question19 {

	public static void main(String[] args) {
		// Make an "ArrayList" from an int stream. Need boxed to convert the IntStream
		// into a Stream so I can collect as a List
		List<Integer> myList = (ArrayList<Integer>) IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		// Convert the "ArrayList" to a stream. Remove all odds. Convert stream to an
		// IntStream. Sum the IntStream
		int sumOfEvens = myList.stream().filter(s -> s % 2 == 0).mapToInt(s -> s).sum();
		System.out.println("The sum of all the even numbers from 1->10 inclusive is: " + sumOfEvens);
		// Convert the "ArrayList" to a stream. Remove all evens. Convert the stream to
		// an IntStream. sum the IntStream
		int sumOfOdds = myList.stream().filter(s -> s % 2 != 0).mapToInt(s -> s).sum();
		System.out.println("The sum of all the odd numbers from 1->10 inclusive is: " + sumOfOdds);
		// Remove primes from the "ArrayList" by copying code from question 9
		myList = removePrimes(myList);
		System.out.println("Here are all the prime numbers from the list");
		// Convert the list to a stream for easy printing
		myList.stream().forEach(System.out::println);

	}

	private static ArrayList<Integer> removePrimes(List<Integer> list) {
		// For each number in the sieve. If differentNumber % number: delete
		// differentNumber.
		// 1 is not a prime number for some mathematical reason
		list.remove(0);
		int i = 0;
		while (i != list.size()) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) % list.get(i) == 0)
					list.remove(j);
			}
			i++;
		}
		return (ArrayList<Integer>) list;
	}

}
