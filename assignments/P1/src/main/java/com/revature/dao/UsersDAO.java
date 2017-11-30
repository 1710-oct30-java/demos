package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UsersDAO {

	boolean addUser(User user);

	boolean alterUserById(int oldId, User user);

	boolean alterUserEmailById(int oldId, String newEmail);

	boolean alterUserIdById(int oldId, int newId);

	boolean alterUserUserNameById(int oldId, String newUserName);

	boolean alterUserPasswordById(int oldId, String password);

	boolean alterUserFirstNameById(int oldId, String newFirstName);

	boolean alterUserLastNameById(int oldId, String newLastName);

	boolean alterUserRoleIdById(int oldId, int newRoleId);

	boolean removeUserById(int oldId);

	boolean clearUserTable();

	User exists(String username, String password);
	User getUserById(int id);

	List<User> getUsers();
}
