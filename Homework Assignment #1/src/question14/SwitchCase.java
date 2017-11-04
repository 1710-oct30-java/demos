package question14;
//Robert Choboy
//Write a program that demonstrates the switch case. Implement the following functionalities in the class:
//Case 1: Find the square root 
//Case 2: Display Today's date
//Case 3: Split the following string and store it in an array: "I am learning core Java"

		
		import java.util.Date;
		import java.util.Scanner;
		import java.util.Calendar;
		
		public class SwitchCase {
			
			public static void CaseMethod(int a)
			{
				try( Scanner scan = new Scanner(System.in) )
				{
					switch(a)
					{
						case 1:                 
							System.out.println("Enter any positive number: ");
							double num = scan.nextDouble();
							System.out.println("The square root of " + num + " is: " + Math.sqrt(num));
							break;
						case 2:
							Date today = Calendar.getInstance().getTime();
							System.out.println("Today's date is: " + today);
							break;
						case 3:
							String st = "I am Learning core java";
							String[] arry = st.split("\\s");
							for(String s: arry)
								System.out.println(s);
							break;
					}
				  } 
				}		
			public static void main(String[] args)
			{	
				CaseMethod(1);
				System.out.println();
				CaseMethod(2);
				System.out.println();
				CaseMethod(3);	
			}
		}
	
		 