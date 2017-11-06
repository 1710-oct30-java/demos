package actions;

import java.io.IOException;
import java.util.Scanner;

import objects.Account;

public class DeleteAccount {
	
	//Deletes account that user chooses based on account ID
	
	public static void delete(String userID) throws IOException {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Which account would you like to delete?");
		
		for (int i = 0; i < LoadAccounts.acc.size(); i++) {
			System.out.println(i+1 + ". " + Login.accountData.get(i).getaccID());
		}
		String choice = in.nextLine();
		
		for (Account a : Login.accountData) {
			if (LoadAccounts.acc.get(Integer.parseInt(choice)-1).getaccID().equals(a.getaccID())) {
				Login.accountData.remove(a);
			}
		}
		
		UpdateAccount.update();
		
	}
}
