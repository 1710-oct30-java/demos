
public class Accounts {

	private double balance;
	private int accountID;
	private static int numberOfAccount = 1000000;
	
	Accounts(){
		accountID = numberOfAccount++;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountID() {
		return accountID;
	}
	
	private void makeDeposit(double amount) {
		if(amount<0) {
			System.out.println("Deposit must be greater than zero");
			return;
		}
		balance = balance + amount;
		System.out.println("You have deposited $"+amount);
		System.out.println("You now have $"+ amount);
		
	}

	private void makeWithdraw(double amount) {
		
		if(amount>balance) {
			System.out.println("Insufficient Balance");
			return;
		}
		balance = balance - amount;
		System.out.println("You have withdrawn $"+ amount);
		System.out.println("You now have a balance of $"+ balance);
	}
	
	@Override
		public String toString() {
		return "Account Number:" + this.getAccountID() + "\n"+
				"Account Balance: " + this.getBalance() + "\n";
	}
}
