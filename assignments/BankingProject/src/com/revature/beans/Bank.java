package com.revature.beans;

/*
 * Class: Bank
 * Creator: Kyle Settles
 * Description: This class is used to represent the Bank. It contains a list of 
 * active users that is saved and loaded from a data.txt file to keep it updated. 
 */

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Bank implements Serializable {
	
	private static final long serialVersionUID = -3988753097464377537L;
	private List<User> listUsers;
	private User currUser;
	private static String oper;
	private Scanner sc;
	private boolean isRunning = false;
	
	public Bank(List<User> listOfUsers) {
		
		listUsers = listOfUsers;

		do {
			System.out.println("Welcome to the Kyle's Bank!");
			System.out.println("Are you a new member? (y/n)");

			sc = new Scanner(System.in);
			String member = sc.nextLine();
			if(member.equals("y")) {
				System.out.println("Please enter your name: ");
				String name = sc.nextLine();
				System.out.println("Please enter a four-digit pin: ");
				int newPin = sc.nextInt();
				boolean isNew = false;
				while(!isNew) {
					for(int i = 0; i < listUsers.size(); i++) {
						User tempNew = listUsers.get(i);
						if(tempNew.getPin() == newPin) {
							System.out.println("Please enter a new PIN. That one has been taken.");
							newPin = sc.nextInt();
							isNew = false;
						}
						isNew = true;
					}
				}
				User newUser = new User(name, newPin);
				listUsers.add(newUser);
				System.out.println("successfully added to our system");
				System.out.println("you may be asked to put your pin in again");
			}
			else if(member.equals("exit")) {
				isRunning = false;
				break;
			}

			System.out.println("Please input your PIN number: ");
			int pin = sc.nextInt();

			System.out.println("Banking Application \n");
			for(int i = 0; i< listUsers.size(); i++) {
				User temp = listUsers.get(i);
				if(temp.getPin() == pin) {
					this.currUser = temp;
				}
			}

			System.out.println("Welcome " + currUser.getName());
			do {
				oper = sc.nextLine();
			} while(!executeOperation(oper));

		} while(!isRunning);

	}

	// method used to execute the operations for the user
	public boolean executeOperation(String oper) {
		sc = new Scanner(System.in);
		
		switch (oper) {
		
			case "1":
				System.out.println("What type of account would you like to open?");
				String type = sc.nextLine();
				currUser.createAccount(type);
				break;
				
			case "2":
				System.out.println("Which account would you like to close?");
				List<Account> tempClose = currUser.getListAccounts();
				for(int i = 0; i < tempClose.size(); i++) {
					String name = tempClose.get(i).getType();
					System.out.println(name + "account");
				}
				
				String accClose = sc.nextLine();
				Account tempCloseAcc = new Account(accClose);
				int indexAccClose = 0;
				for(int i =0; i <currUser.getListAccounts().size(); i++) {
					if(currUser.getListAccounts().get(i).equals(tempCloseAcc)) {
						indexAccClose = i;
					}
				}
				
				System.out.println(indexAccClose);
				currUser.getListAccounts().remove(indexAccClose);
				System.out.println("Successfully closed your " + tempCloseAcc.getType() + " account");
				break;
				
			case "3":
				System.out.println("which account would you like to deposit into: ");
				List<Account> tempDeposit = currUser.getListAccounts();
				
				for(int i = 0; i < tempDeposit.size(); i++) {
					String name = tempDeposit.get(i).getType();
					System.out.println(name);
				}
				
				String accDeposit = sc.nextLine();
				Account tempAccDeposit = new Account(accDeposit);
				int indexAccDeposit = 0;
				for(int i =0; i <currUser.getListAccounts().size(); i++) {
					if(currUser.getListAccounts().get(i).equals(tempAccDeposit)) {
						indexAccDeposit = i;
					}
				}
				
				System.out.println("deposit amount: ");
				int amtDeposit = sc.nextInt();
				currUser.depositFunds(currUser.getListAccounts().get(indexAccDeposit), amtDeposit);
				System.out.println("New balance is: " + currUser.getListAccounts().get(indexAccDeposit).getBalance());
				break;
				
			case "4":
				System.out.println("which account would you like to withdraw from?");
				List<Account> tempWithdrawl = currUser.getListAccounts();
				
				for(int i = 0; i < tempWithdrawl.size(); i++) {
					String name = tempWithdrawl.get(i).getType();
					System.out.println(name);
				}
				
				String accWithdraw = sc.nextLine();
				Account tempWithdrawAcc = new Account(accWithdraw);
				int indexAccWithdrawl = 0;
				for(int i =0; i <currUser.getListAccounts().size(); i++) {
					if(currUser.getListAccounts().get(i).equals(tempWithdrawAcc)) {
						indexAccWithdrawl = i;
					}
				}
				System.out.println("Withdrawl amount: ");
				int amtWithdraw = sc.nextInt();
				currUser.withdrawFunds(currUser.getListAccounts().get(indexAccWithdrawl), amtWithdraw);
				System.out.println("New balance is: " + currUser.getListAccounts().get(indexAccWithdrawl).getBalance());
				break;
				
			case "5":
				System.out.println("For which account would you like to view the balance?");
				List<Account> tempViewBal = currUser.getListAccounts();
				
				for(int i = 0; i < tempViewBal.size(); i++) {
					String name = tempViewBal.get(i).getType();
					System.out.println(name);
				}
				
				String accViewBal = sc.nextLine();
				Account tempViewAcc = new Account(accViewBal);
				
				int indexViewAcc = 0;
				for(int i =0; i <currUser.getListAccounts().size(); i++) {
					if(currUser.getListAccounts().get(i).equals(tempViewAcc)) {
						indexViewAcc = i;
					}
				}
				System.out.println("Your balance is: " + currUser.getListAccounts().get(indexViewAcc).getBalance());
				break;
				
			case "q":
				System.out.println("Thanks for using the system. Come back and see us!");
				return true;
				
			default:
				System.out.println("What would you like to do?");
				System.out.println("Operation 1: Open account");
				System.out.println("Operation 2: Delete account");
				System.out.println("Operation 3: Deposit funds");
				System.out.println("Operation 4: Withdraw funds");
				System.out.println("Operation 5: View Account Balances");
				System.out.println("Type 'q' to end the session");
				System.out.println();
				return false;
		}
		System.out.println("Please enter another operation");
		return false;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public User getCurrUser() {
		return currUser;
	}

	public void setCurrUser(User currUser) {
		this.currUser = currUser;
	}

	public static String getOper() {
		return oper;
	}

	public static void setOper(String oper) {
		Bank.oper = oper;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}