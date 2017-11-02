package question19;

import java.util.ArrayList;
import java.util.Iterator;
import question9.Question9;

/*
 * Create an ArrayList and insert integers 1 through 10. Display the
 * ArrayList. Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. Remove the
 * prime numbers from the ArrayList and print out the remaining 
 * ArrayList.
 */
public class Question19 {

	public static void main(String[] args) {

		// create and insert integers 1-10
		ArrayList<Integer> intList = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			intList.add(i);
		}
		
		// display the arrayList
		System.out.println(intList.toString());
		
		// add up all even and odd values
		int even = 0;
		int odd = 0;
		for(int num: intList) {
			if(num%2 == 0) {
				even += num;
			}
			else {
				odd+= num;
			}
		}
		
		// display those values
		System.out.println("Sum of even numbers: " + even);
		System.out.println("Sum of odd numbers: " + odd);
		
		// must use iterator because removing values would mess with loops
		Iterator<Integer> iter = intList.iterator();
		
		while(iter.hasNext()) {
			int num = iter.next();
			if(Question9.checkPrime(num)) {
				iter.remove();
			}
		}
		
		// display new array
		System.out.println(intList.toString());
	}

}
