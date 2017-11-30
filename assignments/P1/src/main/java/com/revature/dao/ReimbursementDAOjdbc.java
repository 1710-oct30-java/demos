package com.revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.util.DAOcheck;

public class ReimbursementDAOjdbc implements ReimbursementDAO {
	private static ReimbursementDAOjdbc rdaojdbc = new ReimbursementDAOjdbc();
	private String insert = "INSERT INTO reimbursement (id, amount, submitted,resolved,description,receipt,author,resolver,status_id,type_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private String update = "UPDATE reimbursement SET ";
	private String delete = "DELETE FROM reimbursement WHERE ";
	private String end = " WHERE id = ?";
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	private DAOcheck daoc = DAOcheck.getDAOcheck();
	private Logger log = Logger.getRootLogger();

	private ReimbursementDAOjdbc() {
		super();
	}

	public static ReimbursementDAOjdbc getReimburesmentDAOjdbc() {
		return rdaojdbc;
	}

	@Override
	public int addReimbursement(Reimbursement reimbursement) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("adding a new reimbursement");
			PreparedStatement ps = conn.prepareStatement(insert, new String[] {"id"});
			ps.setInt(1, reimbursement.getId());
			ps.setDouble(2, reimbursement.getAmount());
			ps.setDate(3, reimbursement.getSubmitted());
			ps.setDate(4, reimbursement.getResolved());
			ps.setString(5, reimbursement.getDescription());
			ps.setBlob(6, reimbursement.getReceipt());
			ps.setInt(7, reimbursement.getAuthor());
			ps.setInt(8, reimbursement.getResolver());
			ps.setInt(9, reimbursement.getStatusId());
			ps.setInt(10, reimbursement.getTypeId());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			ps.close();
		} catch (SQLException e) {
			log.error("Issue when adding reimbursement to Database" + e);
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
		}
		return 0;
	}

	public boolean alterReimbursement(int oldId, Reimbursement reimbursement) {
		try(Connection conn = connUtil.getConnection())
		{
			log.debug("updating a complete reimbursement");
			PreparedStatement ps = conn.prepareStatement("UPDATE reimbursement SET id = ?, amount = ?, submitted = ?, resolved = ?, description = ?, author = ?, resolver = ?, status_id = ?, type_id = ? WHERE id = ?");
			ps.setInt(1, reimbursement.getId());
			ps.setDouble(2, reimbursement.getAmount());
			ps.setDate(3, reimbursement.getSubmitted());
			ps.setDate(4, reimbursement.getResolved());
			ps.setString(5, reimbursement.getDescription());
			//ps.setBlob(6, reimbursement.getReceipt());
			ps.setInt(6, reimbursement.getAuthor());
			ps.setInt(7, reimbursement.getResolver());
			ps.setInt(8, reimbursement.getStatusId());
			ps.setInt(9, reimbursement.getTypeId());
			ps.setInt(10, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered Reimbursement");
		} catch (SQLException e) {
			log.error("Issue when adding reimbursement to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}
	
	@Override
	public boolean alterReimbursementAmountById(int oldId, double newAmount) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter reimbursement amount via id");
			PreparedStatement ps = conn.prepareStatement(update + "amount = ?" + end);
			ps.setDouble(1,newAmount);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Updated New Reimbursement Amount");
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterReimbursementRecieptById(int oldId, InputStream receipt) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attemping to update reimbursement reciept");
			PreparedStatement ps = conn.prepareStatement(update + "receipt = ?" + end);
			ps.setBlob(1, receipt);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Updated Reimbursement Reciept");
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement reciept" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterReimbursementAmountReceiptById(int oldId, double newAmount, Blob receipt) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to update Reimbursement amount and receipt");
			PreparedStatement ps = conn.prepareStatement(update + "amount = ?,receipt = ?" + end);
			ps.setDouble(1, newAmount);
			ps.setBlob(2, receipt);
			ps.setInt(3, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Updated Reimbursement amount and receipt");
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount and receipt" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterReimbursementSubmittedById(int oldId, Date submitted) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to update reimbursement date submitted");
			PreparedStatement ps = conn.prepareStatement(update + "submitted = ?" + end);
			ps.setDate(1, submitted);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Updated reimbursement date submitted");
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterReimbursementStatusById(int oldId, int status) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting alter reimbursement status");
			PreparedStatement ps = conn.prepareStatement(update + "status_id = ?" + end);
			ps.setInt(1, status);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Updated Reimbursement Status");
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean alterReimbursementStatusResolvedById(int oldId, int status, Date resolved) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter reimbursement status and resolved");
			PreparedStatement ps = conn.prepareStatement(update + "status_id = ? , resolved = ?" + end);
			ps.setInt(1, status);
			ps.setDate(2, resolved);
			ps.setInt(3, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Updated Reimbursement Status And Resolved");
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection"+ e1);
			return false;
		}
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new LinkedList<>();
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to get all reimbursements");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				try {
					reimbursements.add(extractReimbursement(rs));
				}catch(SQLException e)
				{
					log.error("Error extracting reimbursements");
				}
				
			}
			ps.close();
			rs.close();
			log.info("Successfully got all reimbursements");
			return reimbursements;
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
			return reimbursements;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return reimbursements;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementsById(int id) {
		List<Reimbursement> r = new LinkedList<>();
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to find reimbursement with id: " + id);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement WHERE author = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			try
			{
				while(rs.next())
				{
					r.add(extractReimbursement(rs));
					log.info("Successfully returning reimbursement with id");
				}
				return r;
			}catch(SQLException e)
			{
				log.error("Error extracting reimbursements");
			}
			return r;
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
		}
		return r;
	}

	@Override
	public boolean removeReimbursementById(int id) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to delete reimbursement by Id");
			PreparedStatement ps = conn.prepareStatement(delete + "id = ?");
			ps.setInt(1, id);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Deleted Reimbursement By ID");
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}

	@Override
	public boolean clearReimbursements() {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to wipe the Reimbursements table");
			PreparedStatement ps = conn.prepareStatement("DELETE FROM reimbursement WHERE 1 = 1");
			ps.execute();
			ps.close();
			log.info("Reimbursements table wiped");
			ps = conn.prepareStatement("DROP SEQUENCE reimbursement_sequence");
			ps.execute();
			ps.close();
			ps = conn.prepareStatement("CREATE SEQUENCE reimbursement_sequence");
			ps.execute();
			ps.close();
			log.info("Sucessfully reset sequence reimbursement_sequence");
			return true;
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);
			return false;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return false;
		}
	}
	private Reimbursement extractReimbursement(ResultSet rs) throws SQLException 
	{
		int id = rs.getInt("id");
		double amount = rs.getDouble("amount");
		Date submitted = rs.getDate("submitted");
		Date resolved = rs.getDate("resolved");
		String description = rs.getString("description");
		Blob receipt = rs.getBlob("receipt");
		int author = rs.getInt("author");
		int resolver = rs.getInt("resolver");
		int statusId = rs.getInt("status_id");
		int typeId = rs.getInt("type_id");
		return new Reimbursement(id, amount, submitted, resolved, description, receipt, author, resolver, statusId, typeId, receipt != null);
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(int id) {
		List<Reimbursement> reimbursements = new LinkedList<>();
		try(Connection conn = connUtil.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement WHERE status_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				reimbursements.add(extractReimbursement(rs));
			}
			log.info("Successfully got all reimbursements");
			ps.close();
			rs.close();
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);

		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);

		}
		return reimbursements;
	}
	
	@Override
	public byte[] getReimbursementById(int id) {
		Reimbursement r = null;
		try(Connection conn = connUtil.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement WHERE id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				r = extractReimbursement(rs);
			}
			log.trace(r.getReceipt());
			InputStream file = r.getReceipt().getBinaryStream();
			byte[] bytes = IOUtils.toByteArray(file);
			return bytes;
		} catch (SQLException e) {
			log.error("Issue when updating reimbursement amount" + e);

		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);

		}
		return null;
	}

}
