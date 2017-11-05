package assignments.week01.project.view;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.wrapper.AccountWrapper;
import assignments.week01.project.bretty.console.view.MenuView;

/**
 * represents the menu for a single account view
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class AccountActions extends MenuView implements ViewListenerInterface
{
	private Account account;
	
	public AccountActions(Account account)
	{
		super( String.format("%s's %s Account", AccountWrapper.getOwner(account).firstName, account.name), String.format("Manage %s", account.name ) );
		
		this.account = account;
		this.initializeMenu();
		
		/*
		 * attach this class to the events manager
		 */
		ViewEventsManager.getInstance().attach( this );
	}
	
	/**
	 * dynamically build the menu for this view
	 * 
	 */
	private void initializeMenu()
	{
		this.getMenuItems().stream().forEach( item -> this.removeMenuItem( item ) );
		
		this.addMenuItem( new ViewBalance( this.account ) );
		
		/*
		 * if account has an available balance, give the user
		 * the option to withdraw funds
		 */
		if ( AccountWrapper.getAvailableBalance( this.account) > 0.00 ) {
			this.addMenuItem( new WithdrawFunds( this.account ) );
		}
		
		this.addMenuItem( new DepositFunds( this.account) );
		
		this.addMenuItem( new CloseAccount(this.account) );
	}
	
	/**
	 * listen for relevant events
	 */
	public void listen(String event, Object data)
	{
		switch( event.toLowerCase() ) {
			case "account.transactions:updated" :
				Account affectedAccount = (Account)data;
				
				if ( affectedAccount.id == this.account.id ) {
					this.initializeMenu();
				}
				
				break;
		}
	}
}
