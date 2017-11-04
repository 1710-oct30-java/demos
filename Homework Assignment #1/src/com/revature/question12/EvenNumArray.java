package com.revature.question12;
//Robert Choboy
//Revature
//Write a program to store numbers 1 to 100 in an array. Print all the even numbers from the array. Use the Enhanced FOR loop for printing out the numbers. 


public class EvenNumArray {

	public static void main(String[] args) {
		
		//Establish the Size of the Array
		
        int size = 100;
        System.out.println("Printing the following even numbers between 1 and " + size);
       //Use a For Loop to print out the correct numbers of the array
        for(int i=1; i <= size; i++){
               
                // if the number is divisible by 2 then it is even. If there is a remainder then it is odd
        	    
                if( i % 2 == 0){
                        System.out.print(i + " ");
                }
        }
}

	}
	
		

