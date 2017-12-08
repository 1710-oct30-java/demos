package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidCredentialException extends CustomHttpException {
	
	private HttpStatus status = HttpStatus.UNAUTHORIZED;
	
	public InvalidCredentialException() {
		super();
	}
	
	public InvalidCredentialException(String message) {
		super(message);
	}
	
	

	@Override
	public HttpStatus getStatus() {
		return status;
	}

}
