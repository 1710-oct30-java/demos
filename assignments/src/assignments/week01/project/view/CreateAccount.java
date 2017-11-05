package assignments.week01.project.view;

import java.util.HashMap;
import java.util.Map;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.factory.AccountFactory;
import assignments.week01.project.bretty.console.view.ActionView;
import assignments.week01.project.db.adapter.AccountsTableAdapter;


/**
 * view for creating a new account
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class CreateAccount extends ActionView
{
	private Person person;
	
	public CreateAccount(Person person )
	{
		super( "Open A New Account", "Open New Account") ;
		
		this.person = person;
	}

	@Override
	public void executeCustomAction() {

		Map<String, String> data = new HashMap<>();
		
		String name = "";
		Integer type = 0;
		
		
		this.println();
		this.println("Thank You for choosing to open a new account with Console Banking!");
		this.println();
		type = this.getAccountType();
		
		name = this.prompt("Please enter the name of this new account: ", String.class );
		
		data.put("ssn",  this.person.ssn );
		data.put("type", String.valueOf( type ));
		data.put("name", name);
		
		Account account = AccountFactory.getInstance().create(data);
		
		AccountsTableAdapter.getInstance().put(account);
		this.actionSuccessful();
	
		/*
		 * trigger event to notify other vies that this person's accounts have
		 * been modified
		 */
		ViewEventsManager.getInstance().trigger("person.accounts:updated", this.person );
	}
	
	/**
	 * perform conditional questionnaire to determine
	 * the type of account the user wants to open
	 * 
	 * @return Integer
	 */
	private Integer getAccountType()
	{
		String response = "";
				
		response = this.prompt("Will this be a new checking account? (y/N): ", String.class );
		
		if ( response.equalsIgnoreCase("y") ) {
			return Account.TYPE_CHECKING;
		} else {
			response = this.prompt("Will this be a new savings account? (y/N): ", String.class );
		}
		
		if ( response.equalsIgnoreCase("y") ) {
			return Account.TYPE_SAVINGS;
		} else {
			response = this.prompt("Will this be a new loan account? (y/N): ", String.class );
		}
		
		if ( response.equalsIgnoreCase("y") ) {
			return Account.TYPE_LOAN;
		} else {
			this.println("You MUST select at least one (1) account type to continue");
			response = this.prompt("Would you like to continue opening a new account? (y/N)", String.class);
			
			if ( response.equalsIgnoreCase("y") ) {
				return this.getAccountType();
			} else {
				this.actionCanceled();
			}
		} 	
		
		return Account.TYPE_CHECKING; // so Eclipse will shut up
	}
	
}
