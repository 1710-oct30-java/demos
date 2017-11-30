package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.ErsReimbursement;
import com.revature.beans.ErsUser;

public interface ErsReimbursementDao {

	abstract List<ErsReimbursement> findAll();
	abstract List<ErsReimbursement> findByUserId(int i);
	abstract List<ErsReimbursement> filter(String type);
	abstract void newReimbursement(ErsReimbursement reim) throws SQLException;
	abstract void approve(ErsReimbursement reim) throws SQLException;
	abstract void deny(ErsReimbursement reim) throws SQLException;
	abstract int getTypeId(String type);
	abstract int getStatusId(String status);
	abstract List<ErsReimbursement> findByNotUserId(int parseInt);
}
