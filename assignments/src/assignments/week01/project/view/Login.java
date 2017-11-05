package assignments.week01.project.view;

import assignments.week01.project.acl.Authenticator;
import assignments.week01.project.bretty.console.view.ActionView;
import assignments.week01.project.bretty.console.view.ViewConfig;

/**
 * login view
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Login extends ActionView 
{
	
	public Login()
	{
		super("Login to Your Account", "Login");
	}

	@Override
	public void executeCustomAction() {
		String identity = this.prompt("Enter User ID: ", String.class );
		String password = this.prompt("Enter password/PIN: ", String.class );
		ViewConfig vc = new ViewConfig.Builder()
				.setActionSuccessfulMessage( "Login Successful!!")
				.setActionFailedMessage("Invalid Login Credentials!!")
				.build();
		
		this.viewConfig = vc;
		
		boolean success = Authenticator.authenticate(identity, password);
		
		if ( success ) {
			this.setParentView( new MainMenu( Authenticator.getAuthenticatedUser() ) );
		} else {
			this.setParentView( new IntroductionView() );
			this.actionFailed();
			this.pause();
		}
	}
	
}
