package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DelegateController
{
	/**
	 * @param request
	 * @param response
	 */
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException;
	
	/**
	 * @param request
	 * @param response
	 */
	public void delegateGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;
}
