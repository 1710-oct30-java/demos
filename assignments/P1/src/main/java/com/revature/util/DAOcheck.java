package com.revature.util;

import org.apache.log4j.Logger;

public class DAOcheck {
	private static DAOcheck daoc = new DAOcheck();
	private static Logger log = Logger.getRootLogger();
	private DAOcheck() {
	}
	
	public static DAOcheck getDAOcheck()
	{
		return daoc;
	}
	
	public boolean checkResult(int num, String attempt)
	{
		if(num > 0)
		{
			log.debug("Successfully " + attempt);
			return true;
		}
		else
		{
			log.debug("Unsuccessfully " + attempt);
			return false;
		}
	}

}
