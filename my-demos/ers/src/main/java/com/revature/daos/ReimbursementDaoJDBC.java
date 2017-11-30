package com.revature.daos;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoJDBC implements ReimbursementDao {
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private Logger log = Logger.getRootLogger();
	
	public List<Reimbursement> getPastReimbursements(int id) {
		List<Reimbursement> output = new ArrayList<Reimbursement>();
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from reimbursement where reimb_author = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(rs.getInt("reimb_id"));
				r.setAmount(rs.getInt("reimb_amount"));
				r.setSubmitted(rs.getTimestamp("reimb_submitted"));
				r.setResolved(rs.getTimestamp("reimb_resolved"));
				r.setDescription(rs.getString("reimb_description"));
				r.setReceipt(rs.getBlob("reimb_receipt"));
				r.setAuthor(rs.getInt("reimb_author"));
				r.setResolver(rs.getInt("reimb_resolver"));
				r.setStatusID(rs.getInt("reimb_status_id"));
				r.setTypeID(rs.getInt("reimb_type_id"));
				output.add(r);
			}
			return output;
		}
		catch(SQLException e) {
			
		}
		
		return null;
	}

	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> output = new ArrayList<Reimbursement>();
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from reimbursement");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(rs.getInt("reimb_id"));
				r.setAmount(rs.getInt("reimb_amount"));
				r.setSubmitted(rs.getTimestamp("reimb_submitted"));
				r.setResolved(rs.getTimestamp("reimb_resolved"));
				r.setDescription(rs.getString("reimb_description"));
				r.setReceipt(rs.getBlob("reimb_receipt"));
				r.setAuthor(rs.getInt("reimb_author"));
				r.setResolver(rs.getInt("reimb_resolver"));
				r.setStatusID(rs.getInt("reimb_status_id"));
				r.setTypeID(rs.getInt("reimb_type_id"));
				output.add(r);
			}
			return output;
		}
		catch(SQLException e) {
			
		}
		return null;
	}

	public boolean approveReimbursement(int id, int resolverID) {
		boolean result = false;
		try(Connection conn = cu.getConnection()){
			PreparedStatement verify = conn.prepareStatement("select * from reimbursement where reimb_id = ?");
			log.trace(id);
			verify.setInt(1, id);
			log.trace(resolverID);
			ResultSet vrs = verify.executeQuery();
			vrs.next();
			int test = vrs.getInt("reimb_author");
			log.trace(test);
			log.trace("test: " + test + " does not equal " + " resolverID: " + resolverID);
			if(test == resolverID) {
				result = false;
			}
			else {
				PreparedStatement ps = conn.prepareStatement("update reimbursement set reimb_status_id = 2, reimb_resolved = (select current_timestamp from dual), reimb_resolver = ? where reimb_id = ?");
				ps.setInt(1, resolverID);
				ps.setInt(2, id);
				log.trace(ps);
				boolean rs = ps.execute();
				log.trace("record was updated");
				result = true;
			}
			
			//ps = conn.prepareStatement("commit");
			//ps.executeQuery();
		}
		
		catch(SQLException e) {
			
		}
		return result;
		
	}
	
	public void denyReimbursement(int id, int resolverID) {
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement("update reimbursement set reimb_status_id = 3, reimb_resolved = (select current_timestamp from dual), reimb_resolver = ? where reimb_id = ?");
			ps.setInt(1, resolverID);
			ps.setInt(2, id);
			log.trace(ps);
			boolean rs = ps.execute();
			log.trace("record was updated");
		}
		
		catch(SQLException e) {
			
		}
		
	}

	public void addNewReimbursement(int amount, String descript, Blob receipt, int auth, int status, int type) {
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values (?, (select current_timestamp from dual), ?, ?, ?, 0, ?, ?)");
			ps.setInt(1, amount);
			ps.setString(2, descript);
			ps.setBlob(3, receipt);
			ps.setInt(4, auth);
			ps.setInt(5, status);
			ps.setInt(6, type);
			
			boolean rs = ps.execute();
			log.trace("record was added");
		}
		
		catch(SQLException e) {
			
		}
		
	}

	
}
