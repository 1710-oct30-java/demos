package com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;

public class Banking {
	
	// Method to get all accounts from text file
	// Also used to update accounts list with the text file
	public List<Account> getAllUsers() throws FileNotFoundException, IOException {
		List<Account> accounts = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("BankData.txt"))) {
			String line = null;
			// reads by line ands splits into a String array on colons
			while ((line = br.readLine()) != null) {
				String[] strArr = line.split(":");
				Account acc = new Account(strArr[0], strArr[1], Double.parseDouble((strArr[2])));
				accounts.add(acc);
			}
		}
		return accounts;
	}
	
	// Checks the index of a user within the accounts list
	public Integer getCurrentAccountIndex(List<Account> accounts, Account acc) {
		for (int i=0; i<accounts.size(); i++) {
			if (accounts.get(i).getUsername().equals(acc.getUsername())) {
				return i;
			}
		}
		return null;
	}
	
	// Prints all of the users
	public void printAllUsers(List<Account> accounts) {
		for (Account acc: accounts) {
			System.out.println("Username: " + acc.getUsername());
			System.out.println("Password: " + acc.getPassword());
			System.out.println("Balance: " + acc.getBalance());
			System.out.println();
		}
	}
	// Returns the account with the associated username
	public static Account getAccountByUsername (List<Account> accounts, String uname) {
		for (Account a: accounts) {
			if (a.getUsername().equals(uname)) {
				return a;
			}
		}
		return null;
	}
	
	
	// Login method checks the if the combination of username and password exist in accounts list
	public Account login(List<Account> accounts) throws FileNotFoundException, IOException {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Login");
		System.out.println("Enter your Username: ");
		String usr = scn.nextLine();
		System.out.println("Enter your Password: ");
		String pass = scn.nextLine();
		
		
		for (Account a: accounts) {
			if (usr.equals(a.getUsername())) {
				if (pass.equals(a.getPassword())) {
					System.out.println("Welcome " + usr + "!");
					return a;
				}
			}
		}
		System.out.println("Invalid Username or Password. Try Again.");
		return null;
		
	}
	
	public double getBalance(Account acc) {
		return acc.getBalance();
	}
	
	// Method creates a new text file and replaces old one to update balance
	public void deposit(Account acc, double d) {
		
		// creates a temp file to store writes
		File inputFile = new File("BankData.txt");
		File tempFile = new File("TempBankData.txt");
		
		try {
			// lines to check in text file
			String oldData = acc.getUsername()+":"+acc.getPassword()+":"+acc.getBalance();
			String newData = acc.getUsername()+":"+acc.getPassword()+":"+(acc.getBalance()+d);

			BufferedReader br = new BufferedReader(new FileReader("BankData.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("TempBankData.txt"));
			
			String currentLine;
			// Once the reader gets to the line that needs to be changed it
			// writes the new account information, else it just copies the old file
			while ((currentLine = br.readLine()) != null) {
				String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(oldData)) {
			    	bw.write(newData + System.getProperty("line.separator"));
			    	continue;
			    }
			    bw.write(currentLine + System.getProperty("line.separator"));
			}
			bw.close(); 
			br.close(); 
			// replaces original text file
			tempFile.renameTo(inputFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// works exactly the same as deposit
	public void withdraw(Account acc, double w) {
		
		
		File inputFile = new File("BankData.txt");
		File tempFile = new File("TempBankData.txt");
		
		try {

			String oldData = acc.getUsername()+":"+acc.getPassword()+":"+acc.getBalance();
			String newData = acc.getUsername()+":"+acc.getPassword()+":"+(acc.getBalance()-w);

			BufferedReader br = new BufferedReader(new FileReader("BankData.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("TempBankData.txt"));
			
			String currentLine;
			
			while ((currentLine = br.readLine()) != null) {
				String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(oldData)) {
			    	bw.write(newData + System.getProperty("line.separator"));
			    	continue;
			    }
			    bw.write(currentLine + System.getProperty("line.separator"));
			}
			bw.close(); 
			br.close(); 
			tempFile.renameTo(inputFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// Method to create an account
	public boolean createAccount() {
		// Gets user input for the account to be created
		Scanner scn = new Scanner(System.in);
		System.out.println("What would you like the username to be? ");
		String uname = scn.nextLine();
		System.out.println("What would you like the password to be? ");
		String pass = scn.nextLine();
		System.out.println("What is the account balance? ");
		double d = scn.nextDouble();
		
		String newAccount = uname+":"+pass+":"+d;


		File inputFile = new File("BankData.txt");
		File tempFile = new File("TempBankData.txt");
		
		try {

			// Similarly to deposit and withdraw it creates a new file with the added
			// account. The only difference is that no data needs to be removed.
			BufferedReader br = new BufferedReader(new FileReader("BankData.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("TempBankData.txt"));
			
			String currentLine;
			
			bw.write(newAccount + System.getProperty("line.separator"));
			while ((currentLine = br.readLine()) != null) {
			    bw.write(currentLine + System.getProperty("line.separator"));
			}
			bw.close(); 
			br.close(); 
			tempFile.renameTo(inputFile);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Method to delete an account
	// Similarly rewrites a new copy of the file without the name
	public boolean deleteAccount(Account accToBeDeleted) {
		

		File inputFile = new File("BankData.txt");
		File tempFile = new File("TempBankData.txt");
		
		try {
			
			// Similarly to the deposit and with draw method it simply jumps over
			// the account the line matches the user input for deletion
			String data = accToBeDeleted.getUsername()+":"+accToBeDeleted.getPassword()+":"+accToBeDeleted.getBalance();

			BufferedReader br = new BufferedReader(new FileReader("BankData.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("TempBankData.txt"));
			
			String currentLine;
			
			while ((currentLine = br.readLine()) != null) {
				String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(data)) {
			    	bw.write(System.getProperty("line.separator"));
			    	continue;
			    }
			    bw.write(currentLine + System.getProperty("line.separator"));
			}
			bw.close(); 
			br.close(); 
			tempFile.renameTo(inputFile);
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	
}
