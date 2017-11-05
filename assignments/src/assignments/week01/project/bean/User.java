package assignments.week01.project.bean;


/**
 * represents a system user
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class User {
	
	public final static int TYPE_NORMAL = 0;
	public final static int TYPE_ADMIN = 10;
	
	public final static int STATUS_INACTIVE = 0;
	public final static int STATUS_ACTIVE = 1;	
	
	public int id;
	public String identity;			// username
	public String credential;		// PIN/password
	public String ssn;				// ssn of person that the user account belongs to
	public int type;			
	public int status;
	public String secret;			// encryption key used for this user
	
	public User()
	{
		super();
		
		this.type = TYPE_NORMAL;
		this.status = STATUS_ACTIVE;
	}
}
