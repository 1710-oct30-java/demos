package com.revature.banking.launcher;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.banking.accounts.User;
import com.revature.banking.controller.BankingController;

public class BankingLauncher {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//Init variables
		User user = new User();
		BankingController controller = new BankingController();
		
		//Read file and object
		File f = new File("accountDetails.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois= new ObjectInputStream(fis);
		user = (User)ois.readObject();
		ois.close();
		//Start login
		controller.display(user);
	}

}
