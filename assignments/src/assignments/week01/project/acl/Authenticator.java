package assignments.week01.project.acl;

import assignments.week01.project.Session;
import assignments.week01.project.bean.User;
import assignments.week01.project.bean.wrapper.UserWrapper;
import assignments.week01.project.db.adapter.TableAdapterInterface;
import assignments.week01.project.db.adapter.UsersTableAdapter;
import assignments.week01.project.log.SysLog;

/**
 * << utility >>
 * 
 * represents the logic for authenticating a
 * valid user
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Authenticator {
	private static SysLog log = SysLog.getInstance();							// get handle for SysLog
	private static Session session = Session.getInstance();						// get handle for current Session
	private static TableAdapterInterface<User> users = new UsersTableAdapter();	// User bean table adapter
	
	/**
	 * authenticate a user with the passed identity and password
	 * 
	 * @param String identity
	 * @param String password
	 * 
	 * @return boolean
	 */
	public static boolean authenticate(String identity, String password)
	{
		User user = getUserWithIdentity( identity );
		String logMessage;
		
		/*
		 * if there is no user found with that identity
		 * then the authentication fails
		 */
		if ( user == null ) {
			logMessage = String.format("LOGIN FAILED:: user with identity [%s] was not found", identity);
			log.info( logMessage );
			return false;
		}
		
		/*
		 * if the user's password hash matches the one
		 * in the database then it is valid
		 */

		if ( user.credential.equals( password ) ) {
			logMessage = String.format("LOGIN SUCCESSFULL:: user %s logged in successfully", user.identity );
			log.info( logMessage );
			
			/*
			 * store user in session
			 */
			session.store("user", user);

			return true;
		}
		
		/*
		 * default policy
		 */
		logMessage = String.format("LOGIN FAILED:: login attempt for user %s failed with bad credentials", user.identity );
		log.info( logMessage );
		return false;
	}
	
	/**
	 * retrieves the currently authenticated user
	 * 
	 * @return User|null
	 */
	public static User getAuthenticatedUser()
	{
		log.debug("attempting to retrieve authenticated user from session");
		return (User)session.retrieve("user");
	}
	
	/**
	 * remove authenticated user from session
	 */
	public static void clear()
	{
		User user = (User)session.retrieve("user");
		String message = String.format( "LOGOUT: user %s logged out of authenticated session", user.identity );
		
		log.info( message );
		session.remove("user");
	}
	
	/**
	 * retrieve a user with the identity passed
	 * 
	 * @param String identity
	 * 
	 * @return User|null
	 */
	private static User getUserWithIdentity(String identity)
	{	
		return users.get( identity );
	}

}
