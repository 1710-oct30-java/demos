package com.bankingapp.models;

import java.util.Random;

public class Account {
	private float mBalance;
	private Random mRandom = new Random();
	private String mAccountId;
	
	public Account(float balance) {
		mBalance = balance;
		mAccountId = String.format("%04d", mRandom.nextInt(10000));
	}
	
	public float getBalance() {
		return mBalance;
	}
	
	public String getAccountId() {
		return mAccountId;
	}
	
	public float deposit(float amount) {
		mBalance = mBalance + amount;
		return mBalance;
	}
	
	public double withdraw(float amount) {
		mBalance = mBalance - amount;
		return mBalance;
	}
	
	public String getAccountById() {
		return mAccountId;
	}
	
}
