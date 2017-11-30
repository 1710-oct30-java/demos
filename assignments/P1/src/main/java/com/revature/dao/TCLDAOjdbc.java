package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.util.ConnectionUtil;

public class TCLDAOjdbc implements TCLDAO {
	private static TCLDAOjdbc tcldaojdbc = new TCLDAOjdbc();
	private static Logger log = Logger.getRootLogger();
	private static ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	private TCLDAOjdbc() {
	}
	public static TCLDAOjdbc getTCLDAOjdbc()
	{
		return tcldaojdbc;
	}
	@Override
	public boolean commit() {
		try(Connection conn = connUtil.getConnection())
		{
			log.debug("Attempting to commit");
			PreparedStatement ps = conn.prepareStatement("COMMIT");
			ps.execute();
			ps.close();
			log.info("Commit Successfull");
			return true;
		}catch (SQLException e) {
			log.error("Issue when adding reimbursement to Database");
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection");
			return false;
		}
	}

	@Override
	public boolean rollback() {
		try(Connection conn = connUtil.getConnection())
		{
			log.debug("Attempting to rollback");
			PreparedStatement ps = conn.prepareStatement("COMMIT");
			ps.execute();
			ps.close();
			log.info("Rollback Successfull");
			return true;
		}catch (SQLException e) {
			log.error("Issue when adding reimbursement to Database");
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection");
			return false;
		}
	}

	@Override
	public boolean savepoint() {
		try(Connection conn = connUtil.getConnection())
		{
			log.debug("Attempting to make a SavePoint");
			PreparedStatement ps = conn.prepareStatement("COMMIT");
			ps.execute();
			ps.close();
			log.info("SavePoint successfully made");
			return true;
		}catch (SQLException e) {
			log.error("Issue when adding reimbursement to Database");
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection");
			return false;
		}
	}

}
