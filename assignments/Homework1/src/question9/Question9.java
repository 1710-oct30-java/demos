package question9;
import java.util.ArrayList;

/*
 * Kyle Settles
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime 
 * numbers to the console
 */
public class Question9 {
	
	// function used to determine if a number is prime
	public static boolean checkPrime(int n) {
		
		// checks all values to see if anything divides evenly
		for(int i = 2; i < n; i++) {
			
			// if something divides evenly it is not prime
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		// create arrayList to hold values 1 - 100
		ArrayList<Integer> myAList = new ArrayList<Integer>(100);
		
		// fill arrayList with values 1 - 100
		for(int i = 0; i < 100; i++) {
			myAList.add(i);
		}
		
		// check each value of the array to see if it is prime
		// exclude 0 and 1
		for(int i = 0; i < myAList.size(); i++) {
			if(i >=2) {
				if(checkPrime(i)) {
					System.out.println(i);
				}
			}
		}
	}
}
