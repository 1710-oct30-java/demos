package assignments.week01.project;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assignments.week01.project.bretty.console.view.AbstractView;
import assignments.week01.project.db.PersistentConnection;
import assignments.week01.project.migration.*;
import assignments.week01.project.view.IntroductionView;



public class BankAppLauncher {
	

	public static void main(String[] args) 
	{
	
		/*
		 * if the data file is not set up,
		 * run initialization data migrations to
		 * restore default initial data
		 */
		if ( dataIsPresent() == false ) {
			initializeAppData();
		}
		
		AbstractView intro = new IntroductionView();
		intro.display();
	}
	
	/**
	 * returns true if the user table exists in the
	 * database, false if not
	 * 
	 * @return boolean
	 */
	private static boolean dataIsPresent() 
	{
		try {
			String sql = "SELECT * FROM users";
			PreparedStatement stmt = PersistentConnection.getInstance().getConnection().prepareStatement(sql);
			ResultSet results = stmt.executeQuery();
			results.close();
			stmt.close();
		} catch(SQLException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * initialize app data to factory settings
	 * 
	 */
	private static void initializeAppData()
	{	
		MigrationInterface migration = new BootstrapAppData();
		migration.run();	
	}

}