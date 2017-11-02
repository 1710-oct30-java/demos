package com.revature.scopes;

public class Scopes {

	
	public static int classLevel = 5;
	
	public int instanceLevel = 20;
	
	public int myMethod(int i) {
		System.out.println("i is method scoped" + i);
		i++;
		System.out.println("i in method is now " + i);
		
		{
			// j is block scoped
			int j = 10;
		}
		return i;
	} 
}
