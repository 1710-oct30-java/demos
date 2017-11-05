package assignments.week01.project.acl.policy;

import assignments.week01.project.acl.ACLRequest;
import assignments.week01.project.bean.User;

/**
 * policy for User access to Account objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class AdminPolicy extends AbstractPolicy 
{
	@Override
	/**
	 * policy for allowing access
	 * 
	 * @param ACLRequest request
	 * 
	 * @return boolean
	 */
	public boolean allow(ACLRequest request)
	{
		String logMessage;
		
		if ( AdminMarker.class.isInstance( request.resource ) ) {
			
				
			/* 
			 * users who are of the TYPE_ADMIN have administrative
			 * privileges
			 */
			if ( request.user.type == User.TYPE_ADMIN ) {
				logMessage = String.format("USER: %s is ALLOWED administrator privileges", 
					request.user.identity
				);
				
				log.debug( logMessage );
				
				return true;
			}
			
		} 
		
		return false;
	}


	
	
}
