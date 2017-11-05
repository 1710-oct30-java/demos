package assignments.week01.project.view;

import java.util.ArrayList;
import java.util.List;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.wrapper.AccountWrapper;
import assignments.week01.project.bretty.console.view.AbstractView;
import assignments.week01.project.bretty.console.view.ActionView;
import assignments.week01.project.bretty.console.view.MenuView;
import assignments.week01.project.db.adapter.AccountsTableAdapter;

/**
 * logout view
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class CloseAccount extends ActionView
{
	private Account account;
	
	public CloseAccount(Account account)
	{
		super( String.format("Close %s Account", account.name), "Close Account" );
		
		this.account = account;
	}

	@Override
	public void executeCustomAction() {
	
		boolean confirmation = this.confirmDialog("Are you sure you would like to close this account? ");
		
		if ( confirmation ) {
			this.account.status = Account.STATUS_INACTIVE;
			AccountsTableAdapter.getInstance().update(account);
//			
			/*
			 * set the parent view to the view before
			 * the AccountActions view since this account is
			 * no longer active
			 */
			this.setParentView( this.getParentView().getParentView() );
			
			/*
			 * trigger the event to let other views
			 * know that this person's accounts have been
			 * modified
			 */
			ViewEventsManager.getInstance().trigger("person.accounts:updated", AccountWrapper.getOwner( this.account ));
			
			this.actionSuccessful();			
		} else {
			this.actionCanceled();
		}
	}
		
}
