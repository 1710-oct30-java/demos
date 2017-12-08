package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.beans.Reimb;
import com.beans.User;
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
		List<Reimb> collected = new ArrayList<>();
		int i = 0;
		try (Connection conn = connUtil.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimb ORDER BY id");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Reimb temp = extractReimb(rs);

				ps = conn.prepareStatement(
						"SELECT TO_CHAR(submitted,'MON-DD-YYYY HH24:MI') \"Date\" FROM Reimb WHERE id=?");
				ps.setInt(1, temp.getReimbId());
				ResultSet rs1 = ps.executeQuery();

				rs1.next();
				temp.setSubmitTimePretty(rs1.getString("Date"));

				ps = conn.prepareStatement(
						"SELECT TO_CHAR(resolved,'MON-DD-YYYY HH24:MI') \"Date\" FROM Reimb WHERE id=?");
				ps.setInt(1, temp.getReimbId());
				rs1 = ps.executeQuery();

				rs1.next();
				temp.setResolvedTimePretty(rs1.getString("Date"));

				collected.add(temp);
			}
			return collected;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<Reimb> getReimb(User cred)
	{
		List<Reimb> collected = new ArrayList<>();
		int i = 0;
		try (Connection conn = connUtil.getConnection())
		{

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimb WHERE author=? ORDER BY id");
			ps.setInt(1, cred.getUserId());
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Reimb temp = extractReimb(rs);

				ps = conn.prepareStatement(
						"SELECT TO_CHAR(submitted,'MON-DD-YYYY HH24:MI') \"Date\" FROM Reimb WHERE id=?");
				ps.setInt(1, temp.getReimbId());
				ResultSet rs1 = ps.executeQuery();

				rs1.next();
				temp.setSubmitTimePretty(rs1.getString("Date"));

				ps = conn.prepareStatement(
						"SELECT TO_CHAR(resolved,'MON-DD-YYYY HH24:MI') \"Date\" FROM Reimb WHERE id=?");
				ps.setInt(1, temp.getReimbId());
				rs1 = ps.executeQuery();

				rs1.next();
				temp.setResolvedTimePretty(rs1.getString("Date"));

				collected.add(temp);
			}
			return collected;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return collected;
		}
		catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
			log.debug("No Reimb found");
			return collected;
		}

	}

	@Override
	public void insertNewReimb(Reimb reimb)
	{
		try (Connection conn = connUtil.getConnection())
		{
			String statement = "INSERT INTO reimb(amount,submitted,description,receipt,author,status_id,type_id) "
					+ "values (?, CURRENT_TIMESTAMP,?,?,?,1,?)";
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setDouble(1, reimb.getAmount());
			ps.setString(2, reimb.getDescription());
			ps.setString(3, reimb.getReceipt());
			ps.setInt(4, reimb.getAuthor());
			ps.setInt(5, reimb.getType());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public List<Reimb> findOnStatus(int num)
	{
		List<Reimb> collected = new ArrayList<>();
		int i = 0;
		try (Connection conn = connUtil.getConnection())
		{

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimb WHERE status_id=? ORDER BY id");
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				Reimb temp = extractReimb(rs);

				ps = conn.prepareStatement(
						"SELECT TO_CHAR(submitted,'MON-DD-YYYY HH24:MI') \"Date\" FROM Reimb WHERE id=?");
				ps.setInt(1, temp.getReimbId());

				ResultSet rs1 = ps.executeQuery();

				rs1.next();
				temp.setSubmitTimePretty(rs1.getString("Date"));

				ps = conn.prepareStatement(
						"SELECT TO_CHAR(resolved,'MON-DD-YYYY HH24:MI') \"Date\" FROM Reimb WHERE id=?");
				ps.setInt(1, temp.getReimbId());
				rs1 = ps.executeQuery();

				rs1.next();
				temp.setResolvedTimePretty(rs1.getString("Date"));

				collected.add(temp);
			}

			return collected;

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return collected;
		}
		catch (IndexOutOfBoundsException e)
		{
			log.debug("No Reimb found");
			return collected;
		}
	}

	@Override
	public boolean reimbExistsChanged(Reimb reimb)
	{
		List<Reimb> collected = new ArrayList<>();

		int counter = 0;
		try (Connection conn = connUtil.getConnection())
		{

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimb WHERE id=?");
			ps.setInt(1, reimb.getReimbId());
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Reimb temp = extractReimb(rs);
				collected.add(temp);
				counter++;
			}
			if ((counter > 0) && (reimb.getStatusId() != collected.get(0).getStatusId()))
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateReimb(Reimb reimb, int resolver)
	{
		try (Connection conn = connUtil.getConnection())
		{
			String statement = "UPDATE reimb " + "SET resolved=?, resolver=?,status_id=? " + "WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setTimestamp(1, getCurrentTimeStamp());
			ps.setInt(2, resolver);
			ps.setInt(3, reimb.getStatusId());
			ps.setInt(4, reimb.getReimbId());

			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	private static java.sql.Timestamp getCurrentTimeStamp()
	{

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
}
