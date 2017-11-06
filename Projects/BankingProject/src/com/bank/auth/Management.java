package com.bank.auth;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bank.accounts.Account;
import com.bank.accounts.User;

public class Management
{
	private String username;
	private String password;
	private String name;
	private Scanner input;
	private List<String> uInput;
	private List<String> menuDisp;

	// First login/registration page,
	// if registration: get user name password and create new user
	// if login: get uername password and validate

	public boolean firstPage(PopData data)
	{
		boolean flag = true;
		boolean valUser = false;
		int choice;
		List<String> tempList;
		do
		{
			input = new Scanner(System.in);
			try
			{
				System.out.println("1. Register an account");
				System.out.println("2. Login");
				System.out.println("0. Quit");
				choice = input.nextInt();

				switch (choice)
				{
					case 1 :
						tempList = firstPageInput(1);
						if (data.getUserMap().containsKey(tempList.get(0)))
						{
							System.err.println("   • Username taken");
							Thread.sleep(250);
							break;
						} else
						{
							User newU = new User();
							valUser = true;
							newU.setName(tempList.get(2));
							newU.setPassword(tempList.get(1));
							data.addUserU(tempList.get(0), newU);
							flag = false;
							break;
						}

					case 2 :
						tempList = firstPageInput(2);
						if (valUser(data.getUserMap()))
						{
							valUser = true;
							flag = false;
						} else
						{
							System.err
									.println("   • Invalid Username/Password");
							Thread.sleep(250);
						}
						break;

					case 0 :
						flag = false;
						break;

					default :
						System.err.println(
								"   • Invalid Input, please try again");
						Thread.sleep(250);
						break;
				}
			} catch (InputMismatchException ime)
			{
				System.err.println("   • Invalid Input, please try again");
				input.next();
				// Thread.sleep(250);
			} catch (InterruptedException ie)
			{
				ie.printStackTrace();
			}

		} while (flag);

		return valUser;
	}

	// Page to enter username password and return
	// for registration
	public List<String> firstPageInput(int choice)
	{
		input = new Scanner(System.in);
		uInput = new ArrayList<>();

		System.out.println("   • Username is case insensitive");
		System.out.print("USERNAME:\t");
		username = input.nextLine().toLowerCase();
		System.out.print("PASSWORD:\t");
		password = input.nextLine();
		uInput.add(username);
		uInput.add(password);
		if (choice == 1)
		{
			System.out.print("FULL NAME:\t");
			name = input.nextLine();
			uInput.add(name);
		}
		return uInput;
	}

	// Second page after logged in/ regisered
	// Display all menu options and wait for input
	public int controlPage(User user)
	{
		boolean flag = true;
		menuDisp = new ArrayList<>();
		int choice = 0;

		System.out.println("\nWELCOME, " + user.getName());
		System.out.println(
				"------------------------------------------------------------");
		input = new Scanner(System.in);

		menuDisp.add("1. View Your Accounts\t\t4. Create Another Account");
		menuDisp.add("2. Deposit\t\t\t5. Delete An Existing Account");
		menuDisp.add("3. Withdraw\t\t\t0. Log Out");

		choice = getChoice(menuDisp, 5);

		return choice;
	}

	// validate username agains stored data

	public boolean valUser(Map<String, User> userPass)
	{
		if (userPass.containsKey(this.username))
		{
			if (userPass.get(username).getPassword().equals(this.password))
				return true;
			else
				return false;
		} else
			return false;
	}

	// list all accounts avaialbe in the user object
	// also list account ID and balance of specific account

	public void viewAccounts(User user)
	{
		int i = 1;
		List<Integer> temp = new ArrayList<>();
		menuDisp = new ArrayList<>();
		input = new Scanner(System.in);
		for (int key : user.getAccList().keySet())
		{
			temp.add(key);
			menuDisp.add(i + ". " + key);
			i++;
		}
		menuDisp.add("0. Back");
		menuDisp.add("Choose an account to view");

		int choice = getChoice(menuDisp, user.getAccList().size());

		if (choice == 0)
			return;
		System.out.println("   • Account ID:\t"
				+ user.getAccList().get(temp.get(choice - 1)).getAccID());
		System.out.println("   • Balance:\t\t"
				+ user.getAccList().get(temp.get(choice - 1)).getBalance());
	}

	// choose a specific account to deposit money into
	// only double is allowed
	public void deposit(User user)
	{
		input = new Scanner(System.in);
		menuDisp = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		int choice = 0;
		double amount;

		menuDisp.add("Which account would you like to DEPOSIT into: ");
		int i = 1;
		for (int key : user.getAccList().keySet())
		{
			temp.add(key);
			menuDisp.add(i + ". " + key);
			i++;
		}

		choice = getChoice(menuDisp, user.getAccList().size());
		System.out.print("Amount to DEPOSIT: ");
		amount = input.nextDouble();
		user.getAccList().get(choice - 1);
		if (amount >= 0)
		{
			double balance = user.getAccList().get(temp.get(choice - 1))
					.getBalance();
			balance = balance + amount;
			user.getAccList().get(temp.get(choice - 1)).setBalance(balance);
		} else
		{
			System.err.println("Invalid amount");
		}

	}

	// withdraw from the specified account
	// if amount is more than balance, throw error
	public void withdraw(User user)
	{
		input = new Scanner(System.in);
		menuDisp = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		int choice = 0;
		double amount;

		menuDisp.add("Which account would you like to WITHDRAW from: ");
		int i = 1;
		for (int key : user.getAccList().keySet())
		{
			temp.add(key);
			menuDisp.add(i + ". " + key);
			i++;
		}

		choice = getChoice(menuDisp, user.getAccList().size());
		System.out.print("Amount to WITHDRAW: ");
		amount = input.nextDouble();
		// user.getAccList().get(choice -1);
		double balance = user.getAccList().get(temp.get(choice - 1))
				.getBalance();
		if (amount >= 0 && amount <= balance)
		{

			balance = balance - amount;
			user.getAccList().get(temp.get(choice - 1)).setBalance(balance);
		} else
		{
			System.err.println("Invalid amount");
		}

	}

	// create new bank account for a user with random account id

	public void createAcc(User user, int accID)
	{
		Account newAcc = new Account(accID, user.getName());
		user.addAccList(accID, newAcc);
	}

	// delete specified user account

	public void deleteAcc(User user, PopData data)
	{
		input = new Scanner(System.in);
		menuDisp = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		int choice = 0;
		double amount;

		menuDisp.add("Which account would you like to DELETE: ");
		int i = 1;
		for (int key : user.getAccList().keySet())
		{
			temp.add(key);
			menuDisp.add(i + ". " + key);
			i++;
		}

		choice = getChoice(menuDisp, user.getAccList().size());
		user.getAccList().remove(temp.get(choice - 1));
	}

	// this ensures that only numbers allowed are entered, else
	// will prompt for another input
	public int getChoice(List<String> disp, int opt)
	{
		int choice = 0;
		boolean flag = true;
		do
		{
			for (String str : disp)
				System.out.println(str);
			try
			{
				choice = input.nextInt();

				if (choice >= 0 && choice <= opt)
				{
					flag = false;
				} else
				{
					System.err.println("   • Invalid Input, please try again");
					Thread.sleep(250);
				}
			} catch (InputMismatchException ime)
			{
				System.err.println("   • Invalid Input, please try again");
				input.next();
				try
				{
					Thread.sleep(250);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException ie)
			{
				ie.printStackTrace();
			}

		} while (flag);

		return choice;
	}

	public List<String> getuInput()
	{
		return uInput;
	}

}
