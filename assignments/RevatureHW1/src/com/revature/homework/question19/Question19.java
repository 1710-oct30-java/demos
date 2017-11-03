package com.revature.homework.question19;

import java.util.ArrayList;
import java.util.List;
// Create an array list with nums 1-10
// Display the list
// Sum the even nums
// Sum the odd nums
// Sum all non-primes
public class Question19 {
public static void main(String[] args) {
	List<Integer> ints = new ArrayList<>();
	
	// add nums to list and print
	for (int i = 0; i<10; i++){
		ints.add(i+1);
	}
	System.out.println(ints.toString());
	
	// sum the even nums
	int sumEven=0;
	for(int j=1; j<=10; j=j+2){
		sumEven = sumEven + ints.get(j);
	}
	System.out.println("The sum of the even numbers is " +sumEven);
	
	// sum the odd nums
	int sumOdd=0;
	for(int k=0; k<10; k=k+2) {
		sumOdd = sumOdd +ints.get(k);
	}
	System.out.println("The sum of the odd numbers is "+sumOdd);
	
	
	// sum the list excluding primes (2, 3, 5, 7)
	int sumX=0;
	for (int l = 0; l<10; l++){
		if (!(ints.get(l)==2 || ints.get(l) == 3 || ints.get(l) == 5 || ints.get(l) == 7)) {
			sumX = sumX +ints.get(l);
		} 
	}
	System.out.println("The sum excluding primes is "+sumX);
	
	
	}

	
}
