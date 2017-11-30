package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

	int addReimbursement(Reimbursement reimbursement);

	boolean alterReimbursement(int oldId, Reimbursement reimbursement);

	boolean alterReimbursementAmountById(int oldId, double newAmount);

	boolean alterReimbursementRecieptById(int oldId, InputStream fileContent);

	boolean alterReimbursementAmountReceiptById(int oldId, double newAmount, Blob receipt);

	boolean alterReimbursementSubmittedById(int oldId, Date sumbitted);

	boolean alterReimbursementStatusById(int oldId, int status);

	boolean alterReimbursementStatusResolvedById(int oldId, int status, Date resolved);

	List<Reimbursement> getReimbursements();

	List<Reimbursement> getReimbursementsById(int id);

	List<Reimbursement> getReimbursementsByStatus(int id);

	byte[] getReimbursementById(int id);
	
	boolean removeReimbursementById(int id);

	boolean clearReimbursements();
}
