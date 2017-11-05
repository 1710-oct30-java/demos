package assignments.week01.project.view;

import assignments.week01.project.Session;
import assignments.week01.project.acl.ACLRequest;
import assignments.week01.project.acl.Authorizer;
import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.User;
import assignments.week01.project.bean.wrapper.PersonWrapper;
import assignments.week01.project.bretty.console.view.MenuView;

/**
 * view of user's account list
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class MyAccounts extends MenuView implements ViewListenerInterface 
{
	private Person person;
	
	public MyAccounts(Person person)
	{
		super( String.format("%s's Accounts", person.firstName), "Manage My Accounts");
		
		this.person = person;
		
		this.initializeMenu();
		
		/*
		 * attach this class to the list of event listeners
		 */
		ViewEventsManager.getInstance().attach( this );
	}
	
	/**
	 * dynamically configure the menu items in
	 * this view
	 */
	private void initializeMenu()
	{
		this.getMenuItems().stream().forEach( menuItem -> this.removeMenuItem(menuItem) );
		
		PersonWrapper.getAccounts( this.person )
		.stream()
		.filter( (account) -> {
			ACLRequest request = new ACLRequest();
			request.resource = account;
			request.user = (User)Session.getInstance().retrieve("user");
			request.verb = "write";
			
			return Authorizer.getInstance().authorize(request);
		})
		.filter( account -> account.status == Account.STATUS_ACTIVE )
		.forEach( account -> {
			this.addMenuItem( new AccountActions( account ) );
		});
	
		this.addMenuItem( new CreateAccount( this.person ));
	}
	
	/**
	 * listen for relevant events
	 * 
	 * @param String event
	 * @param ViewListenerInterface caller
	 */
	public void listen(String event, Object data )
	{
		switch( event.toLowerCase() ) {
			case "person.accounts:updated" :
				Person affectedPerson = (Person)data;
				
				if ( affectedPerson.ssn.equals( this.person.ssn ) ) {
					this.initializeMenu();
				}

				break;
		}
	}
}
