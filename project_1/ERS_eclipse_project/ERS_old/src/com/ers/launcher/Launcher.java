package com.ers.launcher;

import org.apache.log4j.PropertyConfigurator;

import com.ers.dao.ManagersDAO;
import com.ers.dao.ManagersJDBC;

public class Launcher {

	private static ManagersJDBC manager = new ManagersJDBC();

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/log4j.properties");
		//manager.viewPendingRequests();
		manager.viewApprovedRequests();
	}
}
