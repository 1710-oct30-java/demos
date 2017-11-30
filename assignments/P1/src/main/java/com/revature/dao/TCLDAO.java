package com.revature.dao;

public interface TCLDAO {
	boolean commit();
	boolean rollback();
	boolean savepoint();
}
