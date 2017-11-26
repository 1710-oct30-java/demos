package com.revature.exceptions;

public class ErsForbiddenException extends ErsHttpException
{
	// [Eclipse] Generated Field
	private static final long serialVersionUID = 1864015486971739959L;

	public ErsForbiddenException()
	{
		super(403); // 403 Forbidden
	}
}
