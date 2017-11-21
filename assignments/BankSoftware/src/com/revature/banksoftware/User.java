package com.revature.banksoftware;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = -3680807132653967102L;
	
	private String userName;
	private String password;
	private String emailAddress;
	private List<Account> accounts;
	
	
	public User(String emailAddress, String userName, String password) {
		
		super();
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.accounts = new ArrayList<Account>();
	}
	
	public String getAccountDetails() {
		
		StringBuffer sbr = new StringBuffer("");
		
		for(int i = 0; i < accounts.size(); i++) {
			
			Account acc = accounts.get(i);
			sbr.append("\t\t[" + (i+1));
			
			if(!acc.getApproved())
			{
				sbr.append(" [AWAITING APPROVAL]");
			}
			
			sbr.append("] " + acc.getType() + " | $ " + acc.getBalance() + "\n");
		}
		
		return sbr.toString();
	}
	
	public int countAccounts() {
		
		return accounts.size();
	}

	public List<Account> getAccounts() {
		
		return accounts;
	}
	
	
	public String getUserName() {
		
		return userName;
	}
	
	public void setUserName(String userName) {
		
		this.userName = userName;
	}
	
	
	public boolean checkPassword(String input) {
		
		return password.equals(input);
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	
	public String getEmailAddress() {
		
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		
		return "User [userName=" + userName + ", password=" + password + ", emailAddress=" + emailAddress
				+ ", accounts=" + accounts + "]";
	}
	
}
