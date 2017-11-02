package com.revature.exceptions;

public class InvalidCredentialException extends Exception{
	public int i;
	
	public InvalidCredentialException(int i) {
		this.i = i;
	}
}
