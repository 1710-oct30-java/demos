package question12;
import java.util.stream.IntStream;
/*
 * Write a program to store number from 1 to 100 in an array. Print out all the even numbers from the array.  Use the enhanced FOR loop for printing out the numbers;
 */
public class Question12 {
	public static void main(String[] args) {
		//create an array from 1 to 100
		int array[] = IntStream.rangeClosed(1, 100).toArray();
		System.out.println("We will now print out the even numbers for this array");
		//create a stream from the array.  Remove all odd numbers. print out the remaining numbers
		IntStream.of(array).filter(i-> (i % 2 == 0)).forEach(System.out::println);
	}
}
