package assignments.week01.project.view;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.wrapper.AccountWrapper;
import assignments.week01.project.bretty.console.view.ActionView;

/**
 * view for viewing the balance of an account
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class ViewBalance extends ActionView
{
	private Account account;
	
	public ViewBalance(Account account )
	{
		super( String.format("Balance of %s", account.name), "View Balance");
		
		this.account = account;
	}

	@Override
	public void executeCustomAction() {

		Double totalBalance = AccountWrapper.getTotalBalance( this.account );
		Double availableBalance = AccountWrapper.getAvailableBalance( this.account );
		Double pendingBalance = AccountWrapper.getPendingBalance( this.account );
		
		this.println();
		this.println( String.format("Total Balance: $ %.2f", totalBalance) );		
		this.println( String.format("Available Balance: $ %.2f", availableBalance  ) );
		this.println( String.format("\nTotal Pending Transactions: $ %.2f", pendingBalance ) );
		this.println();
		
		this.pause();
	}
	
}
