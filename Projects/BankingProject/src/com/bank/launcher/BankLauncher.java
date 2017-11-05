package com.bank.launcher;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.bank.accounts.User;
import com.bank.auth.Management;
import com.bank.auth.PopData;

public class BankLauncher
{
	public static void main(String[] args)
	{
		PopData data = new PopData();
		Management manage = new Management();
		List<String> tempList = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		boolean valUser = false;
		int choice;
		//Populate important variables
		data.getData();
		
		do
		{
			try
			{
				
				System.out.println("1. Register an account");
				System.out.println("2. Login");
				System.out.println("0. Quit");
				choice = input.nextInt();
				
				switch(choice)
				{
					case 1:
					{
						tempList = manage.firstPage();
						User newU = new User();
						valUser = true;
						System.out.print("NAME:\t");
						String temp = input.nextLine();
						newU.setName(temp);
						newU.setPassword(tempList.get(1));
						data.addUserU(tempList.get(0), newU);
						flag = false;
					}break;
						
					case 2:
						tempList = manage.firstPage();
						if (manage.valUser(data.getUserU()))
						{
							valUser = true;
						}
						flag = false;
						break;
						
					case 0:
						flag = false;
						break;
				}
			}
			catch (InputMismatchException ime)
			{
				System.out.println("Invalid Input, please try again");
				input.next();
			}
			
		}while(flag);
		
		
		
		//temp = manage.firstPage();
		
//		if (manage.valUser(data.getUserU()))
//			System.out.println("welcome");
		
		
		
		
		
		
		//saved all data and serialize them to a file
		System.out.println("Bye!");
		data.logOut();
		
	}
}
