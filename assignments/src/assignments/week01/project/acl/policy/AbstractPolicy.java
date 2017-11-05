package assignments.week01.project.acl.policy;

import assignments.week01.project.acl.ACLRequest;
import assignments.week01.project.log.SysLog;

/**
 * template for all ACL policy objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
abstract public class AbstractPolicy implements PolicyInterface 
{
	protected static SysLog log = SysLog.getInstance();		// get handle on system log instance
	
	/**
	 * default allow policy of extending classes
	 * 
	 * @param ACLRequest request
	 * 
	 * @return boolean
	 */
	public boolean allow(ACLRequest request)
	{
		log.debug("default ACL allow policy used");
		return false;
	}
	
	/**
	 * default deny policy of extending classes
	 * 
	 * @param ACLRequest request
	 * 
	 * @return boolean
	 */
	public boolean deny(ACLRequest request)
	{
		log.debug("default ACL deny policy used");
		return false;
	}
}
