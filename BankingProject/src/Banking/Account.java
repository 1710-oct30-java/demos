package Banking;
/*
 * Class Account is created each time a user creates and new 
 * banking account.
 */
public class Account 
{
	private String accountType;
	private double balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructor
	public Account(String accountType, double balance) {
		super();
		this.accountType = accountType;
		this.balance = balance;
	}
	//gets account type
	public String getAccountType() {
		return accountType;
	}
	//sets account type
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	//gets balance
	public double getBalance() {
		return balance;
	}
	//sets balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", balance=" + balance
				+ "]";
	}
	//adds money to the user's current account balance
	public void deposit(double amount)
	{
		if (amount > 0)
		{
			balance += amount;
		}
		else
		{
			System.out.println("Invalid deposit");
		}
	}
	//deducts money from the user's current account balance
	public void withdrawal(double amount)
	{
		if (balance < amount || amount < 0)
		{
			System.out.println("Either insufficient funds, or invalid input.");
		}
		else
		{
			balance -= amount;
		}
	}
	
	
}
