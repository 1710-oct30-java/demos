package assignments.week01.project.view;

import assignments.week01.project.Session;
import assignments.week01.project.bean.User;
import assignments.week01.project.bretty.console.view.ActionView;
import assignments.week01.project.db.adapter.UsersTableAdapter;
import assignments.week01.project.migration.BootstrapAppData;
import assignments.week01.project.migration.MigrationInterface;

/**
 * logout view
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class FactoryReset extends ActionView implements ViewListenerInterface
{
	public FactoryReset()
	{
		super( "Reset To Factory Settings", "Factory Reset");
		
		ViewEventsManager.getInstance().attach( this );
	}

	@Override
	public void executeCustomAction() {
	
		this.println("Performing a factory reset will delete all data stored in the database for this app.");
		this.println("After performing the factory reset, the state of the app will be restored to factory settings");
		boolean confirmation = this.confirmDialog("Are you sure that you would like to reset the app's data to factory settings?");
		
		
		if ( confirmation ) {
			confirmation = this.confirmDialog("Are you ABSOLUTELY CERTAIN that you would like to reset the app's data to factory settings?");
			if ( confirmation ) {
				MigrationInterface reset = new BootstrapAppData();		
				reset.run();
				this.actionSuccessful();
				ViewEventsManager.getInstance().trigger("reset", null);
			} 
			
		} 
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
				/*
				 * if the user no longer exists after reset
				 * throw user back to login screen
				 */
				
				
				if ( this.userIsActive() == false ) {
					this.setParentView( new IntroductionView() );
				}
				
				break;
		}
	}
	
	/**
	 * detects if the authenticated user is still active 
	 * in the database or not
	 * 
	 * @return boolean
	 */
	private boolean userIsActive()
	{
		User currentUser = (User)Session.getInstance().retrieve("user");
		User fetchedUser = UsersTableAdapter.getInstance().get( String.valueOf(currentUser.id) );
		
		/*
		 * if user no longer exists, return false
		 */
		if ( fetchedUser == null ) {
			return false;
		}
		
		/*
		 * return true if the user is active, false otherwise
		 */
		return ( fetchedUser.status == User.STATUS_ACTIVE );
	}
	
}
