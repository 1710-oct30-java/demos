package com.revature.question5;

public class SubStringMeth {

			   public static void main(String[] args) {

			      String str = "This is week 1 of Revature";
			      String substr = "";
			      int index;
			      
			    
			      // prints the substring after index 5 till index 15
			      substr = str.substring(5, 15);
			      System.out.println("substring = " + substr);

			      // prints the substring after index 0 till index 7
			      substr = str.substring(0, 7);
			      System.out.println("substring = " + substr);
			   }
			
				
	}


