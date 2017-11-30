package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.Users;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOJdbc implements ReimbursementDAO{

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	private Reimbursement extractReimbursement(ResultSet rs) throws SQLException {
		Reimbursement reimb = new Reimbursement();
		reimb.setReimb_id((rs.getInt("reimb_id")));
		reimb.setReimb_amount(rs.getInt("reimb_amount"));
		reimb.setReimb_submitted(rs.getTime("reimb_submitted"));
		reimb.setReimb_resolved(rs.getTime("reimb_resolved"));
		reimb.setReimb_description(rs.getString("reimb_description"));
		reimb.setReimb_author(rs.getInt("reimb_author"));
		reimb.setReimb_resolver(rs.getInt("reimb_resolver"));
		reimb.setReimb_status_id(rs.getInt("reimb_status_id"));
		reimb.setReimb_type_id(rs.getInt("reimb_type_id"));
		
		return reimb;
	}
	
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		log.debug("attempting to retreive all reimbursements");
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				Time submitted = rs.getTime("reimb_submitted");
				Time resolved = rs.getTime("reimb_resolved");
				String description = rs.getString("reimb_description");
				int author = rs.getInt("reimb_author");
				int resolver = rs.getInt("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");
				reimbursements.add(new Reimbursement(id, amount, submitted, resolved, description, author, resolver, statusId, typeId));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all reimbursements");
		}

		return reimbursements;
	}

	public List<Reimbursement> findById(int id) { 
	List<Reimbursement> reimbursements = new ArrayList<>();
	try (Connection conn = cu.getConnection()) {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement WHERE reimb_id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Reimbursement reimb = extractReimbursement(rs);
			reimbursements.add(reimb);
		}

		return reimbursements;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
	
	//find pending requests
	public List<Reimbursement> findPending() { 
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement WHERE reimb_status_id=3");
			//ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimb = extractReimbursement(rs);
				reimbursements.add(reimb);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  }
	
	public List<Reimbursement> findUserReimbursements(Users u) { 
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement INNER JOIN users ON (users_id = ? AND reimb_author = ?)");
			ps.setInt(1, u.getUsers_id());
			ps.setInt(2, u.getUsers_id());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimb = extractReimbursement(rs);
				reimbursements.add(reimb);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  
	}
	public List<Reimbursement> findUserPending(Users u) { 
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement INNER JOIN users ON ((users_id = ? AND reimb_author = ?) AND (reimb_status_id = 3))");
			ps.setInt(1, u.getUsers_id());
			ps.setInt(2, u.getUsers_id());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimb = extractReimbursement(rs);
				reimbursements.add(reimb);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  }
	
	public List<Reimbursement> findAllPastTickets() { 
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement WHERE reimb_status_id=1 OR reimb_status_id=2");
			//ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			
			if (rs == null)
			{
				log.info("No reimburements have been resolved.");
			}
			
			while (rs.next()) {
				Reimbursement reimb = extractReimbursement(rs);
				reimbursements.add(reimb);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  }
	
	public List<Reimbursement> findUserPastTickets(Users u) { 
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement INNER JOIN users ON ((users_id = ? AND reimb_author = ?) AND (reimb_status_id = 1 OR reimb_status_id = 2)) ");
			ps.setInt(1, u.getUsers_id());
			ps.setInt(2, u.getUsers_id());
			ResultSet rs = ps.executeQuery();
			
			if (rs == null)
			{
				log.info("No reimburements have been resolved.");
			}
			
			while (rs.next()) {
				Reimbursement reimb = extractReimbursement(rs);
				reimbursements.add(reimb);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  }
	
	public void addReimbursement(Users u, int amount, String description, int typeId)
	{
		if (amount < 1) {
			return;
		}
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author,reimb_status_id, reimb_type_id)\r\n" + 
					"VALUES (?, (SELECT CURRENT_TIMESTAMP FROM dual), ?, ?, 3, ?) ");
			ps.setInt(1, amount);
			ps.setString(2, description);
			ps.setInt(3, u.getUsers_id());
			ps.setInt(4, typeId);
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void approveOrDeny (Users u, int statusId, int id)
	{
		try (Connection conn = cu.getConnection()) {
			if (u.getUser_role_id() == 1 || u.getUser_role_id() == 2) {
				PreparedStatement ps = conn.prepareStatement("UPDATE reimbursement SET reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = (SELECT CURRENT_TIMESTAMP FROM dual) WHERE (reimb_id = ? AND reimb_author != "+u.getUsers_id()+")");
				ps.setInt(1, statusId);
				ps.setInt(2, u.getUsers_id());
				ps.setInt(3, id);
				ps.executeQuery();
			}
			else {
				log.info("You do not have permission to approve or deny requests.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

