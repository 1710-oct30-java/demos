package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public abstract class CustomHttpException extends Exception {
	
	public CustomHttpException() {
		super();
	}
	
	public CustomHttpException(String message) {
		super(message);
	}
	
	public abstract HttpStatus getStatus();

}
