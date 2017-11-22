package dao;

import java.sql.SQLException;
import java.util.List;

import beans.User;

public interface UserDao {
	
	void saveUser(User u) throws SQLException;

	void updateUser(User u) throws SQLException;

	void deactivateUser(User u) throws SQLException;

	void activateUser(User u) throws SQLException;

	List<User> findAll() throws SQLException;

	User findById(String username, String Password) throws SQLException;

}
