package assignments.week01.project.view;

import java.util.HashMap;
import java.util.Map;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Transaction;
import assignments.week01.project.bean.factory.TransactionFactory;
import assignments.week01.project.bean.wrapper.AccountWrapper;
import assignments.week01.project.bretty.console.view.ActionView;
import assignments.week01.project.db.adapter.TransactionsTableAdapter;

/**
 * view for withdrawing funds from an account
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class WithdrawFunds extends ActionView
{
	private Account account;
	
	public WithdrawFunds(Account account )
	{
		super( String.format("Withdraw Funds from %s", account.name), "Withdraw Funds");
		
		this.account = account;
	}

	@Override
	public void executeCustomAction() {

		Double withdrawal = 0.00;
		boolean confirm = false;
		Double totalBalance = AccountWrapper.getTotalBalance( this.account );
		Double availableBalance = AccountWrapper.getAvailableBalance( this.account );
		Double pendingBalance = AccountWrapper.getPendingBalance( this.account );
		
		this.println();
		this.println( String.format("Total Balance: $ %.2f", totalBalance) );		
		this.println( String.format("Available Balance: $ %.2f", availableBalance  ) );
		this.println( String.format("\nTotal Pending Transactions: $ %.2f", pendingBalance ) );
		this.println();
		
		/*
		 * do not allow the user to withdraw more than is available
		 */
		do {
			withdrawal = this.prompt("Amount To Withdraw: $", Double.class );
			
			if ( withdrawal > availableBalance ) {
				this.println( String.format("The amount to withdraw cannot exceed the Total Available Balance: $ %.2f", availableBalance ) );
			}
		} while( withdrawal > availableBalance );
		
		
		confirm = this.confirmDialog( String.format("Please confirm that you would like to withdraw $ %.2f", withdrawal ) );
		
		if ( confirm ) {
			Map<String, String> data = new HashMap<>();
			
			data.put("account_id", String.valueOf( this.account.id ));
			data.put("amount", String.valueOf( withdrawal * -1 ));
			data.put("description", "withdrawal through console app");
			data.put("status", String.valueOf( Transaction.STATUS_APPLIED) );
			
			Transaction transaction = TransactionFactory.getInstance().create(data);
			
			TransactionsTableAdapter.getInstance().put( transaction );
			
			/*
			 * trigger the event to let other views know that this
			 * accounts' balance has been updated
			 */
			ViewEventsManager.getInstance().trigger("account.transactions:updated",  this.account );
			
			this.actionSuccessful();
		} else {
			this.actionCanceled();
		}
	}
	
}
