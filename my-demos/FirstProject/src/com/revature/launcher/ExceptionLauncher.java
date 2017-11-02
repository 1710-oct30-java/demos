package com.revature.launcher;

import com.revature.exceptions.InvalidCredentialException;

public class ExceptionLauncher {
	public static void main(String... args) throws InvalidCredentialException {
		try {
			thrower();
			
		} catch (InvalidCredentialException e) {
			// TODO Auto-generated catch block
			System.out.println("invalid credential");
			System.out.println(e.i);
			e.printStackTrace();
		} finally {
			System.out.println("always executes");
		}
		
		try {
			thrower();
		} finally {
			System.out.println("finally");
		}
		
		System.out.println("we continue on");
		
	}
	
	
	public static void thrower() throws InvalidCredentialException {
		throw new InvalidCredentialException(5);
	}
}
