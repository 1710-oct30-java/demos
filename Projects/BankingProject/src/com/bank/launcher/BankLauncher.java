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
		
//=======================FIRST PAGE========================================
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
						tempList = manage.firstPage(1);
						if (data.getUserMap().containsKey(tempList.get(0)))
						{
							System.err.println("Username taken");
							break;
						}
						else
						{
							User newU = new User();
							valUser = true;
							newU.setName(tempList.get(2));
							newU.setPassword(tempList.get(1));
							data.addUserU(tempList.get(0), newU);
							flag = false;
							break;
						}
						
					case 2:
						tempList = manage.firstPage(2);
						if (manage.valUser(data.getUserMap()))
						{
							valUser = true;
						}
						flag = false;
						break;
						
					case 0:
						flag = false;
						break;
						
					default:
						System.err.println("Invalid Input, please try again");
						break;
				}
			}
			catch (InputMismatchException ime)
			{
				System.err.println("Invalid Input, please try again");
				input.next();
			}
		}while(flag);
		
		
		
		
//==========================SECOND PAGE===========================================		
		if (valUser)
		{
			User curUser = data.getUser(tempList.get(0));
			System.out.println("WELCOME, " + curUser.getName());
			
			
		}
		
		
		
		
		
		
		//saved all data and serialize them to a file
		System.out.println("Bye!");
		data.logOut();
		
	}
}