package assignments.week01.project.view;

import assignments.week01.project.acl.Authenticator;
import assignments.week01.project.bretty.console.view.ActionView;

/**
 * logout view
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Logout extends ActionView 
{
	public Logout()
	{
		super("You Have Signed Out\n\nThank You For Choosing Console Banking!!", "Sign Out");
	}

	@Override
	public void executeCustomAction() {
	
		Authenticator.clear();
		this.setParentView( new IntroductionView() );
	}
	
}
