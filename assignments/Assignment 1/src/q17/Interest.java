package q17;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		// ask for principal interest
		System.out.println("Enter Principal Interest: ");
		Scanner sc = new Scanner(System.in);
		double P = Double.parseDouble(sc.nextLine());

		// ask for rate of interest
		System.out.println("Enter Rate of Interest: ");
		double R = Double.parseDouble(sc.nextLine());

		// ask for time
		System.out.println("Enter Time: ");
		double T = Double.parseDouble(sc.nextLine());

		// calculate interest
		double I = P * R * T;
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Total Interest is: " + df.format(I) + "$");
		sc.close();
	}

}
