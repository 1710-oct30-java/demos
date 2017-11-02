package assignments.week01.question11.p2;

/**
 * represents a banking account
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Account {
	private String id;
	private float balance;
	private float available;

	public Account(String id, float balance, float available) {
		super();
		
		this.id = id;
		this.balance = balance;
		this.available = available;
	}
	
	/**
	 * @return float
	 */
	public float getBalance() {
		return balance;
	}
	
	/**
	 * returns the available balance
	 * 
	 * @return float
	 */
	public float getAvailable() {
		return available;
	}
	
	/**
	 * @return float
	 */
	public String getId() {
		return id;
	}

	/**
	 * return String
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", available=" + available + "]";
	}
	
	
	
}
