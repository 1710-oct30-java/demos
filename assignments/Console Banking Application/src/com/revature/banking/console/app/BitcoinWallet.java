package com.revature.banking.console.app;

import java.io.Serializable;

public class BitcoinWallet implements Serializable{
	private static final long serialVersionUID = -2168768277259833016L;
	private String walletType;
	private double walletBalance;
	
	public BitcoinWallet(String name, double balance) {
		this.walletType = name;
		this.walletBalance = balance;
	}
	
	public void depositToWallet (double bitcoins){
		walletBalance = walletBalance + bitcoins;
	}
	
	public void	 withdrawFromWallet (double bitcoins) {
		if (walletBalance - bitcoins >= 0) {
			walletBalance = walletBalance - bitcoins;
		}
		else 
			System.out.println("ERROR! Not enough Bitcoin!");
	}
	
	public String getWalletType() {
		return walletType;
	}
	
	public void setWalletType(String walletName) {
		this.walletType = walletName;
	}
	
	public double getWalletBalance() {
		return walletBalance;
	}
	
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
}