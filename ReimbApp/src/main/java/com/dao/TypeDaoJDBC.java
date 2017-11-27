package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.util.ConnectionUtil;

public class TypeDaoJDBC implements TypeDao
{
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public String getType(int num)
	{
		try (Connection conn = connUtil.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("SELECT type FROM Reimb_Type WHERE type_id=?");
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				return rs.getString("type");
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
