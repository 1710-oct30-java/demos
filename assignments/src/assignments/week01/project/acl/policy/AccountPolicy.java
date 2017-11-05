package assignments.week01.project.acl.policy;

import assignments.week01.project.acl.ACLRequest;
import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.wrapper.AccountWrapper;

/**
 * policy for User access to Account objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class AccountPolicy extends AbstractPolicy 
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
		
		if ( Account.class.isInstance( request.resource ) ) {
			
			Account account = (Account)request.resource;
			Person owner = AccountWrapper.getOwner(account);
			
			/* 
			 * allow a user to have access to their own
			 * accounts
			 */
			if ( owner.ssn.equals( request.user.ssn ) ) {
				logMessage = String.format("USER: %s is ALLOWED full access to owned ACCOUNT: %s", 
					request.user.identity,
					account.name
				);
				
				log.debug( logMessage );
				
				return true;
			}
			
		} 
		
		return false;
	}


	
	
}
