package com.revature.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOjdbc;
import com.revature.util.EncryptionHandler;

public class UserService {
	private static UserService us = new UserService();
	private UserService() {}
	private UsersDAO udao = UsersDAOjdbc.getUserDAOjdbc();
	Logger log = Logger.getRootLogger();
	public static UserService getUserService()
	{
		return us;
	}
	public User getUser(String uri)
	{
		int id = 0;
		return udao.getUserById(id);
	}
	public List<User> getUsers()
	{
		return udao.getUsers();
	}
	public boolean putUser(String json)
	{
		log.debug("Attempting to put user");
		User u = extractUser(json);
		return udao.alterUserById(u.getId(), u);
		
	}
	public boolean deleteUser(String json)
	{
		log.debug("Attempting to delete user");
		User u = extractUser(json);
		return udao.removeUserById(u.getId());
	}
	public boolean postUser(String json)
	{
		log.debug("Attempting to post user");
		User u = extractUser(json);
		u.setId(1);
		u.setRoleId(1);
		u.setFlag("Y");
		u.setPassword(EncryptionHandler.Encrypt(u.getPassword()));
		return udao.addUser(u);
	}
	private User extractUser(String json)
	{
		log.debug("Attempting extract user from json: " + json);
		ObjectMapper om = new ObjectMapper();
		User u = null;
		try {
			u = om.readValue(json, User.class);
		} catch (IOException e) {
			log.debug("Extraction of user failed " + e);
		}
		return u;
	}
	public boolean postUserViaUser(User u) {
		u.setPassword(EncryptionHandler.Encrypt(u.getPassword()));
		return udao.addUser(u);
		
	}
}
