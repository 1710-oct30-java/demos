package assignments.week01.project.acl.policy;

import assignments.week01.project.acl.ACLRequest;

/**
 * contract for all ACL policies
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public interface PolicyInterface {
	
	/**
	 * returns true if the policy allows access for
	 * the request passed
	 * 
	 * @param ACLRequest request
	 * 
	 * @return boolean
	 */
	public boolean allow(ACLRequest request);
	
	/**
	 * returns true if the policy denies access for
	 * the request passed
	 * 
	 * @param ACLRequest request
	 * 
	 * @return boolean
	 */
	public boolean deny(ACLRequest request);
}
