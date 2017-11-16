package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.services.UserService;

public class UserController
{
	private UserService us = new UserService();
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
}
