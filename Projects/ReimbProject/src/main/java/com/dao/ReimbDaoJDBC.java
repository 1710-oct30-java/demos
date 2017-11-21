package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.beans.Reimb;
import com.util.ConnectionUtil;

public class ReimbDaoJDBC implements ReimbDao
{
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	public Reimb extractReimb(ResultSet rs) throws SQLException
	{
		Reimb reimb = new Reimb();
		reimb.setReimbId(rs.getInt("id"));
		reimb.setAmount(rs.getDouble("amount"));
		reimb.setSubmitTime(rs.getString("submitted"));
		reimb.setResolveTime(rs.getString("resolved"));
		reimb.setDescription(rs.getString("description"));
		reimb.setReceipt(rs.getString("receipt"));
		reimb.setAuthor(rs.getInt("author"));
		reimb.setResolver(rs.getInt("resolver"));
		reimb.setStatusId(rs.getInt("status_id"));
		reimb.setType(rs.getInt("type_id"));

		return reimb;
	}

	@Override
	public List<Reimb> findAll()
	{
		List<Reimb> allReimb = new ArrayList<>();

		try (Connection conn = connUtil.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimb");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				allReimb.add(extractReimb(rs));
			}
			return allReimb;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
