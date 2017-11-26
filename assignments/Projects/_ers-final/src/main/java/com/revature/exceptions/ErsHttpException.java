package com.revature.exceptions;

import javax.xml.ws.http.HTTPException;

public class ErsHttpException extends HTTPException
{
	// [Eclipse] Generated Field
	private static final long serialVersionUID = 6270621243187674547L;

	public ErsHttpException()
	{
		super(500); // Default to internal server error
	}
	
	public ErsHttpException(int code)
	{
		super(code);
	}
}
