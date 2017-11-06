/*
 * Default account
 * username: admin
 * password: 1234
 */

package com.bank.launcher;

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

		boolean flag = true;
		boolean valUser = false;
		int choice;

		// Populate important variables
		data.getData();

		// =======================FIRST
		// PAGE========================================

		valUser = manage.firstPage(data);

		// ==========================SECOND
		// PAGE===========================================
		// user is validated , so allowed to see this page
		if (valUser)
		{
			String username = manage.getuInput().get(0);
			User user = data.getUser(username);
			do
			{

				choice = manage.controlPage(user);

				// handle the choices that are entered
				switch (choice)
				{
					case 1 :
						System.out
								.println("\nList of your existing accounts: ");
						System.out.println(
								"------------------------------------------------------------");
						manage.viewAccounts(user);
						data.logOut();
						break;
					case 2 :
						manage.deposit(user);
						data.logOut();
						break;
					case 3 :
						manage.withdraw(user);
						data.logOut();
						break;
					case 4 :
						// Generate a random number from 1 - 9999
						int randomNum = ThreadLocalRandom.current().nextInt(1,
								9999 + 1);

						// Check if the number is already used, it it is,
						// generate another
						while (data.getIdUsed().contains(randomNum))
						{
							randomNum = ThreadLocalRandom.current().nextInt(1,
									9999 + 1);
						}
						// add the new account number and create new account for
						// user
						data.addIdUsed(randomNum);
						manage.createAcc(user, randomNum);
						data.logOut();
						break;
					case 5 :
						manage.deleteAcc(user, data);
						data.logOut();
						break;
					case 0 :
						flag = false;
						break;
				}
			} while (flag);

		}

		// saved all data and serialize them to a file
		System.out.println("Bye!");
		data.logOut();

	}
}
