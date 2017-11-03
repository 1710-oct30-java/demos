package com.revature.goshornm.bank;

public enum Accounts implements Branchable{
	CHECKING,
	SAVINGS,
	JOINT_CHECKING,
	JOINT_SAVINGS;
	
	public Accounts promptForAccountType() {
		int options = displayOptions();
		int selection = getInput(options);
		
		//User canceled
		if(selection == 0) return null;
		
		//Selected option
		Accounts[] accountTypes = Accounts.values();
		return accountTypes[selection-1];
	}

	@Override
	public int displayOptions() {
		String prompt = "Please select an account type for your new acccount."
				+ "\n If this is your first account, we recommend starting with a basic checking account.";
		String listFormat = "\t%2d %s%n";
		
		System.out.println(prompt);
		
		Accounts[] accountTypes = Accounts.values();
		
		for(int i = 0; i < accountTypes.length; i++) {
			System.out.printf(listFormat, i+1, accountTypes[i]);
		}
		System.out.printf(listFormat, 0, "Cancel");
		return accountTypes.length;
	}



}
