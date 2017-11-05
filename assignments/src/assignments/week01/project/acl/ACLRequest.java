package assignments.week01.project.acl;

import assignments.week01.project.bean.User;

/**
 * class for holding the data
 * of an access control request
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class ACLRequest {

	public Object resource;		// resource access is being requested to
	public User user;			// user requesting access
	public String verb;			// type/category of access
	
}
