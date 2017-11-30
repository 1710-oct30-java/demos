package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Simple;
import com.revature.util.ConnectionUtil;
import com.revature.util.DAOcheck;

public class SimpleDAOsjdbc implements SimpleDAOs {
	private static DAOcheck daoc = DAOcheck.getDAOcheck();
	private String insert;
	private String update;
	private String idEnd;
	private String nameEnd;
	private String tableName;
	private String idName;
	private String nameName;
	private String delete;
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	public SimpleDAOsjdbc() {
		super();
	}

	public SimpleDAOsjdbc(String tableName, String idName, String nameName) {
		this.tableName = tableName;
		this.idName = idName;
		this.nameName = nameName;
		this.insert = " INSERT INTO " + this.tableName + " (" + this.idName + ", " + this.nameName + ") VALUES (?,?)";
		this.update = " UPDATE " + this.tableName + " SET ";
		this.idEnd = " WHERE " + this.idName + " = ?";
		this.nameEnd = " WHERE " + this.nameName + " = ?";
		this.delete = " DELETE FROM " + this.tableName + " ";
	}

	@Override
	public boolean add(int id, String name) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to add a new unit");
			log.trace(insert);
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, id);
			ps.setString(2, name);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Added new to " + tableName);
		} catch (SQLException e) {
			log.error("Issue when adding a new unit to Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alter(int oldId, String oldName, int newId, String newName) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter a unit");
			PreparedStatement ps = conn.prepareStatement(
					update + idName + " = ?, " + nameName + " = ? " + idEnd + " AND " + nameName + " = ?");
			ps.setInt(1, newId);
			ps.setString(2, newName);
			ps.setInt(3, oldId);
			ps.setString(4, oldName);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when adding a new unit to Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterById(int oldId, int newId, String newName) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter unit by ID");
			PreparedStatement ps = conn.prepareStatement(update + idName + " = ?, " + nameName + " = ? " + idEnd);
			ps.setInt(1, newId);
			ps.setString(2, newName);
			ps.setInt(3, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "AlteredbyId in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when adding a new unit to Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterByName(String oldName, int newId, String newName) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter a unit by Name");
			PreparedStatement ps = conn.prepareStatement(update + idName + " = ?, " + nameName + " = ? " + nameEnd);
			ps.setInt(1, newId);
			ps.setString(2, newName);
			ps.setString(3, oldName);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered by Name in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when adding a new unit to Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterNameById(int oldid, String newName) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to update a unit name by id");
			PreparedStatement ps = conn.prepareStatement(update + nameName + " = ? " + idEnd);
			ps.setString(1, newName);
			ps.setInt(2, oldid);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered Name by ID in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when adding a new unit to Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterNamebyName(String oldName, String newName) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(update + nameName + " = ? " + nameEnd);
			log.debug("Attempting to update unit name by name");
			ps.setString(1, newName);
			ps.setString(2, oldName);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered Name by Name in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when adding a new unit to Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean remove(int id, String name) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(delete + idEnd + " AND " + nameName + " = ?");
			ps.setInt(1, id);
			ps.setString(2, name);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "removed row in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when removing a unit in Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean removeById(int id) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(delete + idEnd);
			ps.setInt(1, id);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Removed by ID in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when removing a unit from Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean removeByName(String name) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(delete + nameEnd);
			ps.setString(1, name);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Removed by Name in " + tableName);
		} catch (SQLException e) {
			log.error("Issue when removing a unit from Database" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public String getNameById(int id) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT " + nameName + " FROM " + tableName + idEnd);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				try {
					return rs.getString(nameName);
				} catch (SQLException e) {
					log.error("Unable to get " + nameName + e);
					return "";
				}
			}
			ps.close();
			return "";
		} catch (SQLException e) {
			log.error("Issue when getting unit to Database " + e);
			return "";
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection " + e1);
			return "";
		}
	}

	@Override
	public int getIdByName(String name) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT " + idName + " FROM " + tableName + nameEnd);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				try {
					log.trace("got id by name");
					return rs.getInt(idName);
				} catch (SQLException e) {
					log.error("Unable to get " + idName + e);
				}
				finally
				{
					ps.close();
				}
			}
		} catch (SQLException e) {
			log.error("Issue when getting unit from Database");
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection");
		}
		return -1;
	}

	@Override
	public List<Simple> getAll() {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tableName);
			ResultSet rs = ps.executeQuery();
			List<Simple> items = new ArrayList<>();
			while(rs.next()) {
				items.add(new Simple(rs.getInt(idName),rs.getString(nameName)));
			}
			return items;
		} catch (SQLException e) {
			log.error("Issue when getting unit to Database");
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection");
		}
		return null;
	}
}
