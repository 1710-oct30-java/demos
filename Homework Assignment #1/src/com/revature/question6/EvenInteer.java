package com.revature.question6;
  import java.util.Scanner;
//Robert Choboy
  //Date: 11/1/17
  //Revature
import java.util.scanner;

public class EvenInteer {
	    //Do NOT use modulus operator (%)
	public static void main (String[] args) {
		//In binary form, odd numbers end with the number "1", even numbers end with the number "0"
		//Check to see if the number ends with 0 or 1.
		
		  System.out.println("Enter a number: ");
	        Scanner scan =new Scanner(System.in);

	        int num= scan.nextInt();
	        int usernum=num;
	        while (num>0) 
	        {   
	            num=num-2;
	        }       
	        if(num==0)
	        {
	            System.out.println(usernum +" Is An Even Number");
	        }
	        else
	        {
	            System.out.println(usernum +" Is AN Odd Number");
	        }

	    }
	
	 }

	



