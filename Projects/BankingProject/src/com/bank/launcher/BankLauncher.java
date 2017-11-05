/*
 * Default account
 * username: admin
 * password: 1234
 */

package com.bank.launcher;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.bank.accounts.User;
import com.bank.auth.Management;
import com.bank.auth.PopData;

public class BankLauncher
{
	public static void main(String[] args) throws InterruptedException
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

		valUser = manage.firstPage(data);
		
//==========================SECOND PAGE===========================================		
		if (valUser)
		{
			String username = manage.getuInput().get(0);
			User user = data.getUser(username);
			do
			{
				
				//User curUser = data.getUser(tempList.get(0));
				choice = manage.controlPage(user);
				switch(choice)
				{
					case 1:
						System.out.println("\nList of your existing accounts: ");
						System.out.println("------------------------------------------------------------");
						manage.viewAccounts(user);
						data.logOut();
						break;
					case 2:
						manage.deposit(user);
						data.logOut();
						break;
					case 3:
						manage.withdraw(user);
						data.logOut();
						break;
					case 4:
						int randomNum = ThreadLocalRandom.current().nextInt(1, 9999 + 1);
						while(data.getIdUsed().contains(randomNum))
						{
							randomNum = ThreadLocalRandom.current().nextInt(1, 9999 + 1);
						}
						data.addIdUsed(randomNum);
						manage.createAcc(user, randomNum);
						data.logOut();
						break;
					case 5:
						manage.deleteAcc(user, data);
						data.logOut();
						break;
					case 0:
						flag = false;
						break;
				}
			}
			while(flag);
			
		}
		
		
		
		
		
		
		//saved all data and serialize them to a file
		System.out.println("Bye!");
		data.logOut();
		
	}
}
