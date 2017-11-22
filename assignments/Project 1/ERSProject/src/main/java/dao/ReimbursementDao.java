package dao;

import java.sql.SQLException;
import java.util.List;

import beans.Reimbursement;

public interface ReimbursementDao {
	void saveReimbursement(Reimbursement r) throws SQLException;
	
	void approveReimbursement(Reimbursement r);
	
	void declineReimbursement(Reimbursement r);
	
	List<Reimbursement> findAll();
	
	List<Reimbursement> findUserReimbursements(int uid) throws SQLException;
	
	Reimbursement viewPending(int status);
	
}
