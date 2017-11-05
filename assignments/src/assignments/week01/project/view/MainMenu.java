package assignments.week01.project.view;

import assignments.week01.project.acl.ACLRequest;
import assignments.week01.project.acl.Authorizer;
import assignments.week01.project.acl.policy.AdminMarker;
import assignments.week01.project.bean.User;
import assignments.week01.project.bean.wrapper.UserWrapper;
import assignments.week01.project.bretty.console.view.MenuView;

/**
 * first view a user gets after a successful login
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class MainMenu extends MenuView implements ViewListenerInterface
{
	private User user;
	
	public MainMenu(User user)
	{
		super( String.format("Welcome To Console Banking %s\n\nSelect An Option Below:", UserWrapper.getPerson(user).firstName ), "Main Menu");
		
		this.user = user;
		this.initializeMenu();
		
		ViewEventsManager.getInstance().attach( this );
	}
	
	/**
	 * listen for relevant events
	 * 
	 * @param String event
	 * @param Object data
	 */
	public void listen(String event, Object data )
	{
		switch( event.toLowerCase() ) {
			case "reset" :
				this.initializeMenu();
				break;
		}
	}
	
	/**
	 * dynamically build menu for this view
	 */
	private void initializeMenu()
	{
		this.getMenuItems().stream().forEach( menuItem -> this.removeMenuItem(menuItem) );
		
		this.addMenuItem( new MyAccounts( UserWrapper.getPerson(this.user) ) );
		
		if ( this.userIsAdministrator() ) {
			this.addMenuItem(new ViewUsers() );
			this.addMenuItem(new FactoryReset() );
		}
		
		this.addMenuItem( new Logout() );
	}
	
	/**
	 * returns true if the User is an administrator user
	 * 
	 * @return boolean
	 */
	private boolean userIsAdministrator()
	{
		ACLRequest request = new ACLRequest();
		request.user = this.user;
		request.resource = new AdminMarker();
		request.verb = "view";
		
		return Authorizer.getInstance().authorize(request);
	}
}
