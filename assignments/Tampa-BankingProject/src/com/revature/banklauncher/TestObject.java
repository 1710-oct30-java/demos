package com.revature.banklauncher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.account.Account;
import com.revature.account.User;

/*
 * This class constructs our test object hardcoded into the accountinfo file
 *  Can be deleted if a user creation tool is implemented
 */
public class TestObject {

	public static void main(String[] args) {
		
		TestObject obj = new TestObject();
		

		try {
			FileInputStream fileInput = new FileInputStream(
					"C:\\Users\\iaust\\eclipse-workspace\\Tampa-BankingProject\\resources\\user.properties");

			FileOutputStream fout = new FileOutputStream(
					"C:\\Users\\iaust\\eclipse-workspace\\Tampa-BankingProject\\src\\com\\revature\\banklauncher\\accountinfo.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			Account newAcc = new Account("austin", "savings", 1733.68, 1);
			Account newAcc2 = new Account("austin", "checking", 12.79, 1);
			List<Account> alist = new ArrayList<Account>();
			alist.add(newAcc);
			alist.add(newAcc2);
			User austin = new User("austin", alist);
			
			oos.writeObject(austin);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
