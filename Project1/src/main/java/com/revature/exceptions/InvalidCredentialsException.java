package com.revature.exceptions;

public class InvalidCredentialsException extends Exception {

	private int statusCode;
	
	public InvalidCredentialsException(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
}