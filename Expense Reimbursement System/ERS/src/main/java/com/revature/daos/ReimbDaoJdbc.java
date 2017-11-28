package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbDaoJdbc implements ReimbDao
{
	private Logger			log		= Logger.getRootLogger();
	private ConnectionUtil	conUtil	= ConnectionUtil.getConnectionUtil();
	
	public Reimbursement getReimbFromResultSet(ResultSet rs) throws SQLException
	{
		int id = rs.getInt("reimb_id");
		float amount = rs.getFloat("reimb_amount");
		Date submitted = rs.getDate("reimb_submitted");
		Date resolved = rs.getDate("reimb_resolved");
		String description = rs.getString("reimb_description");
		Object recipt = null;
		int author = rs.getInt("reimb_author");
		int resolver = rs.getInt("reimb_resolver");
		int statusId = rs.getInt("reimb_status_id");
		int typeId = rs.getInt("reimb_type_id");
		
		return new Reimbursement(id, amount, submitted, resolved, description, recipt, author, resolver, statusId,
				typeId);
	}
	
	@Override
	public int save(Reimbursement r)
	{
		log.debug("Trying to save a reimbursement");
		
		try (Connection con = conUtil.getConnection())
		{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, ?)");
			ps.setFloat(1, r.getAmount());
			ps.setDate(2, (java.sql.Date) r.getSubmitted());
			ps.setString(3, r.getDescription());
			ps.setInt(4, r.getStatusId());
			ps.setInt(5, r.getTypeId());
			ps.executeQuery();
			
			// get columns actually saved in the database
			ResultSet keys = ps.getGeneratedKeys();
			
			if (keys.next())
			{
				log.trace("Row inserted has id: " + keys.getInt(1) + "\nand description: " + keys.getString(3));
				log.info("Successfully added reimbursement");
				return keys.getInt(1);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.debug("Failed to save reimbursement");
		}
		
		return 0;
	}
	
	@Override
	public List<Reimbursement> findAll()
	{
		List<Reimbursement> reimbs = new ArrayList<>();
		log.debug("Trying to retreive all reimbursements");
		
		try (Connection con = conUtil.getConnection())
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_reimbursement");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Reimbursement r = extractReimb(rs);
				reimbs.add(r);
			}
		}
		catch (SQLException e)
		{
			log.warn("Failed to retreive all reimbursements");
			e.printStackTrace();
		}
		
		return reimbs;
	}
	
	private Reimbursement extractReimb(ResultSet rs) throws SQLException
	{
		Reimbursement r = new Reimbursement();
		r.setId(rs.getInt("reimb_id"));
		r.setAmount(rs.getFloat("reimb_amount"));
		r.setSubmitted(rs.getDate("reimb_submitted"));
		r.setResolved(rs.getDate("reimb_resolved"));
		r.setDescription(rs.getString("reimb_description"));
		r.setReceipt(null);
		r.setAuthor(rs.getInt("reimb_author"));
		r.setResolver(rs.getInt("reimb_resolver"));
		r.setStatusId(rs.getInt("reimb_status_id"));
		r.setTypeId(rs.getInt("reimb_type_id"));
		return r;
	}
	
	@Override
	public Reimbursement findById(int id)
	{
		log.debug("Trying to retreive reimbursement with id: " + id);
		try (Connection con = conUtil.getConnection())
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				return getReimbFromResultSet(rs);
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.warn("Failed to retreive reimbursement");
		}
		return null;
	}
}