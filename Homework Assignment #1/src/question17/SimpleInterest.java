package question17;
import java.util.Scanner;

public class SimpleInterest {
	//write a program to calculate interest based off of principal, rate, and time 
	public static void main(String args[]) 
    {
        float p, r, t;
        	
			Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the Principal: ");
        	p = scan.nextFloat();
        System.out.print("Interest Rate: ");
        	r = scan.nextFloat();
        System.out.print("Time period: ");
        	t = scan.nextFloat();
        float simple;
        	simple = (r * t * p);
        System.out.print("The Interest is : " + simple);
    }
}

	


