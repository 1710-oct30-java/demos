package services;

import java.sql.SQLException;
import java.util.List;

import beans.User;
import dao.UserDao;
import dao.UserDaoJdbc;

public class UserService {
	private UserDao ud = new UserDaoJdbc();
	
	
	public List<User> findAll() throws SQLException {
		return ud.findAll();
	}
	
	public User getUser(User u) {
		return u;
	}
	
	public User login(User u) throws SQLException {
		return ud.findById(u.getUsername(), u.getPassword());
	}

}
