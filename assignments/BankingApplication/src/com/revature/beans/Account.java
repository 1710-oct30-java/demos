package com.revature.beans;

public class Account {
private String Username;
private String Password;
private double balance;
public Account() {
	super();
}
public Account(String username, String password, double balance) {
	super();
	Username = username;
	Password = password;
	this.balance = balance;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Password == null) ? 0 : Password.hashCode());
	result = prime * result + ((Username == null) ? 0 : Username.hashCode());
	long temp;
	temp = Double.doubleToLongBits(balance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Account other = (Account) obj;
	if (Password == null) {
		if (other.Password != null)
			return false;
	} else if (!Password.equals(other.Password))
		return false;
	if (Username == null) {
		if (other.Username != null)
			return false;
	} else if (!Username.equals(other.Username))
		return false;
	if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
		return false;
	return true;
}
@Override
public String toString() {
	return "Account [Username=" + Username + ", Password=" + Password + ", balance=" + balance + "]";
}



}
