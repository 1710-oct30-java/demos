package com.revature.daos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.ReimbRequest;
import com.revature.daos.RequestDAO;
import com.revature.util.ConnectionUtil;

public class RequestJDBC implements RequestDAO
{
	private static Logger log = Logger.getRootLogger();
	private static ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	private static ReimbRequest getRequestFromResultSet(ResultSet result) throws SQLException
	{
		log.debug("Getting reimbursement request from result set.");
		ReimbRequest request = new ReimbRequest();
		
		request.setId(result.getInt("reimb_id"));
		request.setAmount(result.getDouble("reimb_amount"));
		request.setSubmissionDate(result.getString("reimb_submitted"));
		request.setResolutionDate(result.getString("reimb_resolved"));
		request.setDescription(result.getString("reimb_description"));
		request.setAuthor(result.getInt("reimb_author"));
		request.setResolver(result.getInt("reimb_resolver"));
		request.setStatusId(result.getInt("reimb_status_id"));
		request.setTypeId(result.getInt("reimb_type_id"));
		
		return request;
	}
	
	@Override
	public List<ReimbRequest> getRequestsByUserId(int id)
	{
		log.debug("Attempting to retrieve all requests from user with ID of: " + id + ".");
		
		List<ReimbRequest> requests = new ArrayList<ReimbRequest>();
		try (Connection conn = connUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_author = ?");
			stmt.setInt(1, id);
			ResultSet results = stmt.executeQuery();
			
			while(results.next())
			{
				ReimbRequest request = getRequestFromResultSet(results);
				requests.add(request);
			}
			
			return requests;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.warn("Reimbursement retrieval failed.");
			return requests;
		}
	}
	
	@Override
	public List<ReimbRequest> getRequestsByStatus(int statusCode)
	{
		log.debug("Attempting to retrieve all requests with status of: " + statusCode + ".");
		
		List<ReimbRequest> requests = new ArrayList<ReimbRequest>();
		try (Connection conn = connUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?");
			stmt.setInt(1, statusCode);
			ResultSet results = stmt.executeQuery();
			
			while(results.next())
			{
				ReimbRequest request = getRequestFromResultSet(results);
				requests.add(request);
			}
			
			return requests;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.warn("Reimbursement retrieval failed.");
			return requests;
		}
	}

	@Override
	public int createRequest(ReimbRequest req)
	{
		log.debug("Attempting to write new request " + req + " to database.");
		int success = 0;
		
		try (Connection conn = connUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO ers_reimbursement " +
					"(reimb_amount, reimb_description, reimb_author, reimb_type_id) " + 
					"VALUES (?, ?, ?, ?)");
			
			stmt.setDouble(1, req.getAmount());
			stmt.setString(2, req.getDescription());
			stmt.setInt(3, req.getAuthor());
			stmt.setInt(4, req.getTypeId());
			
			success = stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.warn("Reimbursement creation failed.");
		}
		
		return success;
	}
}
