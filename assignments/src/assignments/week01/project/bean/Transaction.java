package assignments.week01.project.bean;

import java.time.LocalDateTime;

/**
 * represents a transaction
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Transaction {
	public final static int STATUS_PENDING = 0;
	public final static int STATUS_APPLIED = 1;
	
	public int id;
	public Double amount;
	public int accountId;
	public int status;
	public LocalDateTime created;
	public String description;
	
	public Transaction()
	{
		super();
		
		this.created = LocalDateTime.now();    // datetime of transaction is automatically generated
	}
	
	
}
