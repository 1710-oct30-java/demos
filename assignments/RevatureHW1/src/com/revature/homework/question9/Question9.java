package com.revature.homework.question9;
// comment more
import java.util.ArrayList;
import java.util.List;

// Print all prime nums from 1-100

public class Question9 {
public static void main(String[] args) {
	
	// Write 1-100
	List<Integer> nums = new ArrayList<>();
	for (int i=0; i<100; i++) {
		nums.add(i+1);
	}
	
	// if prime then sysout
	for (int i=1; i<100; i++) {
		if (isPrime(nums.get(i))) {
			System.out.println(nums.get(i));
		}
	}
	
}
	
	// checks if prime
	public static boolean isPrime(int n) {
		// check if num has any modulus's for any number between 2 and num 
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}
