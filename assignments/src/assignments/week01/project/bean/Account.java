package assignments.week01.project.bean;

/**
 * represents a bank account
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Account {
	public final static int STATUS_INACTIVE = 0;
	public final static int STATUS_ACTIVE = 1;
	
	public final static int TYPE_CHECKING = 0;
	public final static int TYPE_SAVINGS = 1;
	public final static int TYPE_LOAN = 2;
	
	public int id;
	public String name;
	public int type;
	public int status;
	public String ssn;
	

	public Account()
	{
		super();
		
		this.type = TYPE_CHECKING;
		this.status = STATUS_ACTIVE;
	}	

}
