package com.revature.dao;

import com.revature.beans.ErsUser;

public interface ErsUserLoginDAO {
	ErsUser findByUsernameAndPassword(String username, String password);
}
