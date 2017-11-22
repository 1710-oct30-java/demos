package services;

import java.sql.SQLException;

import beans.Reimbursement;
import dao.ReimbursementDao;
import dao.ReimbursementDaoJdbc;

public class ReimbursementService {
	private ReimbursementDao ud = new ReimbursementDaoJdbc();
	
	public void save(Reimbursement r) throws SQLException {
		ud.saveReimbursement(r);
	}
}
