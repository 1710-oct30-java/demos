package com.revature.banking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankTest {
	public static void main(String[] args) {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		int id = 0;
		//List<User> users = new ArrayList<User>();
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		
		System.out.println("Please log in");
		String login = sc.nextLine();
		User user = new User(login);
		
		do {
			/*System.out.println("Please log in");
			String login = sc.nextLine();
			boolean exists = false;
			
			if(users.size() == 0) {
				users.add(new User(login));
			}
			else {
				for(int i = 0; i < users.size(); i++) {
					if(users.get(i).getName().equals(login)) {
						exists = true;
					}
				}
				
				if(!exists) {
					users.add(new User(login));
				}
			}*/
			
			int input = 0;
			
			System.out.println("Press 1 for Account Creation");
			System.out.println("Press 2 for Account Deletion");
			System.out.println("Press 3 for Withdrawal");
			System.out.println("Press 4 for Deposit");
			System.out.println("Press 5 to end the session");
			input = sc.nextInt();
			sc.nextLine();
			switch(input) {
			case 1:
				System.out.println("Select one: Checking or Savings");
				String accountType = sc.nextLine();
				accounts.add(new BankAccount(id, user, 0.0, accountType));
				id++;
				break;
				
			case 2:
				System.out.println("Please input account ID number");
				int deletion = sc.nextInt();
				for (int i = 0; i<accounts.size(); i++) {
					if(accounts.get(i).getID() == deletion) {
						accounts.remove(i);
					}
				}
				break;
				
			case 3:
				System.out.println("Please specify which account");
				int withdrawal = sc.nextInt();
				System.out.println("Please specify an Ammount");
				double amount = sc.nextDouble();
				
				for (int i = 0; i<accounts.size(); i++) {
					if(accounts.get(i).getID() == withdrawal) {
						accounts.get(i).withdraw(amount);;
					}
				}
				
				break;
				
			case 4:
				System.out.println("Please specify which account");
				int deposit = sc.nextInt();
				System.out.println("Please specify an Ammount");
				double amountTwo = sc.nextDouble();
				
				for (int i = 0; i<accounts.size(); i++) {
					if(accounts.get(i).getID() == deposit) {
						accounts.get(i).deposit(amountTwo);;
					}
				}
				
				break;
			
			case 5:
				
				try {
			         FileOutputStream output = new FileOutputStream("output.txt");
			         ObjectOutputStream out = new ObjectOutputStream(output);
			         out.writeObject(user);
			         for(int i = 0; i < accounts.size(); i++) {
			        	 out.writeObject(accounts.get(i));
			         }
			         out.close();
			         output.close();
			      } catch (IOException i) {
			         i.printStackTrace();
			      }

				running = false;
				break;
			}
			
			
		}while(running);
	}
}
