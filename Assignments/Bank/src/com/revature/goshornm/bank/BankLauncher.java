package com.revature.goshornm.bank;

import java.io.IOException;

import org.javamoney.moneta.spi.MonetaryConfig;

public class BankLauncher implements Branchable {
	
	public static void main(String[] args) {
		
		try {
			MonetaryConfig.class.getClassLoader().getResources(
				"javamoney.properties");
		} catch(IOException e) {
			e.printStackTrace();
		}
		BankLauncher launcher = new BankLauncher();
		launcher.entry();
	}

	private void entry() {
		String welcome = "Welcome to the online console banking app!";
		boolean isQuitting = false;
		
		while(!isQuitting) {
			System.out.println(welcome);
			int options = displayOptions();
			int selection = getInput(options);
			
			switch(selection) {
				case 0: isQuitting = true; break;
				case 1: login(); break;
				case 2: User.create(); break;
			}
		}
	}
	
	private void login() {
		LoginManager loginManager = new LoginManager();
		loginManager.entry();
		
	}

	@Override
	public int displayOptions() {
		String[] options = {
				"\t1. Login",
				"\t2. Create New User Account",
				"\t0. Quit"
		};
		
		for(String option: options) {
			System.out.println(option);
		}
		
		System.out.println();
		return options.length-1;
	}

}
