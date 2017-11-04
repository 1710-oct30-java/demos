package com.revature.question13;
//Revature

//Display the triangle on the console as follows using any type of loop. Do NOT use a simple group of print statements to accomplish this
//0
//1 0
//1 0 1 
//0 1 0 1 

public class TriangleDisplay {
	 
	public static void main(String[] args) {
		
	
			for(int a=1;a<=4;a++){
				
				for(int b=1;b<=a;b++){
					System.out.print(((a+b)%2)+" ");
				}
				System.out.print("\n");
			}
		}
	
		
	}
	

