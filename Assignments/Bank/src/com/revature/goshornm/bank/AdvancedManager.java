package com.revature.goshornm.bank;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;

import org.javamoney.moneta.Money;

import com.revature.goshornm.bank.transactions.CashWithdrawal;
import com.revature.goshornm.bank.transactions.Transfer;
import com.revature.goshornm.bank.transactions.Withdrawal;

public class AdvancedManager extends UserAccountManager implements Branchable {	
	public AdvancedManager(User user) {
		super(user);
	}
	
	public void entry() {
		boolean exit = false;
		
		while(!exit) {
			int options = displayOptions();
			int selection = getInput(options);
			
			switch(selection) {
				case 0: exit = true; 		break;
				case 1: closeAccount(); 	break;
				case 2: changePassword();	break;
				case 3: /* TODO */ 			break;
			}
		}
	}

	public void changePassword() {
		try {
			user.updatePassword();
		} catch(NoSuchAlgorithmException e) {
			Util.log.error("Accessing SHA-256 algorithm failed - preventing user from updating password.");
			System.out.println("Password could not be updated due to a system error.");
		}
	}
	
	@Override
	public int displayOptions() {
		System.out.println("Advanced options:");
		String[] options = {
				"\t1. Close account.",
				"\t2. Change user login password.",
				"\t3. View transaction history.",
				"\t0. Back"
		};
		
		for(String option: options) {
			System.out.println(option);
		}
		System.out.println();
		return options.length;
	}
	
	public void closeAccount() {
		String noAccounts = "You do not have any accounts to close.";

		//No accounts case
		if(user.getAccounts().size() == 0) {
			System.out.println(noAccounts);
			System.out.println();
			return;
		}
		
		Account accountToClose = getAccountForAction();		
		
		//If the account has a remaining balance, do something with the balance
		if(accountToClose.getBalance().isGreaterThan(Money.of(new BigDecimal(0), accountToClose.getBalance().getCurrency()))) {
			
			System.out.println("In order to close an account, you must either withdraw the "
					+ "remaining balance or transfer it to another existing account.");
			
			out.println("\n\nI would like to: ");
			
			System.out.println("\t1. Withdraw the remaining balance");
			System.out.println("\t2. Transfer the remaining balance");
			
			int selection = getInput(2, "");
			
			if(selection == 0) {
				System.out.println("Action cancelled.\n");
				return;
			}
			
			
			if(selection == 1) {
				//Withdraw remaining balance
				Withdrawal withdrawal = CashWithdrawal.createWithdrawal(user, accountToClose, accountToClose.getBalance());
				if(withdrawal == null) return;
				accountToClose.withdraw(withdrawal);
				accountToClose.printReceipt(withdrawal);
			} else {
				//Transfer remaining balance
				Transfer transfer = makeTransfer(accountToClose, accountToClose.getBalance());
				if(transfer == null) return;
				accountToClose.printReceipt(transfer);
			}

		}
		
		user.removeAccountFromUserAccount(accountToClose);
		System.out.println("Account has been successfully closed.");
		
	}

}
