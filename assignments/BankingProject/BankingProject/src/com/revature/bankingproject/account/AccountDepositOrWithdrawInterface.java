package com.revature.bankingproject.account;

import java.util.List;
import java.util.Scanner;

public interface AccountDepositOrWithdrawInterface {
	void depositOrWithdraw(List<Account> accounts, Scanner scan);
}
