package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.util.ConnectionUtil;

public class StatusDaoJDBC implements StatusDao
{
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public String getStatus(int num)
	{
		try (Connection conn = connUtil.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("SELECT Status FROM Reimb_Status WHERE status_id=?");
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				return rs.getString("status");
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}