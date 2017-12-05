package com.revature.repos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Scope(scopeName="prototype") // if you don't want it to be singleton, singleton will be default, not needed for singleton
public class UserDaoHibernate implements UserDao {

	@Override
	public boolean findByUsernameAndPassword(String username, String password) {
		System.out.println("hibernate find by username and password");
		return false;
	}

}
