package com.revature.javacore.question13;

/*
	Display the triangle on the console as follows using any type of loop. Do NOT use
	a simple group of print statements to accomplish this.
	
	0				        0
	1 0			--->      1   0
	1 0 1			    1   0   1
	0 1 0 1			  0   1   0   1
 */
public class Question13 {

	static int[] array = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
	
	public static void main(String[] args) {
		
		int lineSpace = 8;
		String spacing = "";
		
		int p;
		for(int i = 0; i <= 3; i++)
		{
			
			int q = i+i;
			
//			if(i == 0)
//			{
//				spacing = "%" + (lineSpace + 1 + "s");
//				lineSpace -= 2;
//				System.out.printf(spacing, array[i] + "\n");
//			}
			
			if(i == 4)
			{
				for(p = i; p < q; p++)
				{
					System.out.println(p);
				}
			}
				
		}
	}
	
}
