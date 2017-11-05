package GUI;

import java.io.IOException;
import java.util.Scanner;

public class DoMore {
	public static void main(String[] args) throws IOException {
		
		//prompts user if they would like to perform any more actions afterwards
		
		System.out.println("Would you like to perform another action?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		Scanner in = new Scanner(System.in);
		String choice = in.nextLine();
		if (choice.equals("1")) {
			ActionsPage.main(null);
		}
		else if (choice.equals("2")) {
			return;
		}
		else {
			System.out.println("Invalid Option");
		}
	}
}
