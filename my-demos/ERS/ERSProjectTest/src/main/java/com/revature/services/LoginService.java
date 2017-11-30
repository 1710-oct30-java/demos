package com.revature.services;

import com.revature.beans.ErsUser;
import com.revature.dao.ErsUserLoginJDBC;;

public class LoginService {
	private ErsUserLoginJDBC ud = new ErsUserLoginJDBC();

	public ErsUser login(ErsUser u) {
		return ud.findByUsernameAndPassword(u.getErsUsername(), u.getErsPassword());
	}

}
