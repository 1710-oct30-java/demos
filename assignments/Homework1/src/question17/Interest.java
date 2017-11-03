package question17;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		double principle;
		double rate;
		double time;
		double interest;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principle");
		principle = sc.nextDouble();
		
		System.out.println("Enter the rate");
		rate = sc.nextDouble();
		
		System.out.println("Enter the time");
		time = sc.nextDouble();
		
		interest = principle * rate * time;
		System.out.println("the interest is: " + interest);
		
	}
}
