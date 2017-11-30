package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.revature.beans.ErsReimbursement;
import com.revature.util.ConnectionUtil;

public class AddReimbursementJDBC implements AddReimbursementDAO {
    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public void submitReimbReq(ErsReimbursement reimbursement) {
		try(Connection connection = cu.getConnection()) {
			String insertTableSQL = "INSERT INTO ERS_REIMBURSEMENT"
                    + "(REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_AUTHOR, "
                    + "REIMB_STATUS_ID, REIMB_TYPE_ID) "
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, reimbursement.getReimbId());
            preparedStatement.setFloat(2, reimbursement.getReimbAmount());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(reimbursement.getReimbSubmitted()));
            preparedStatement.setInt(4, reimbursement.getReimbAuthor());
            preparedStatement.setInt(5, reimbursement.getReimbStatusId());
            preparedStatement.setInt(6, reimbursement.getReimbTypeId());
            
            preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
            e.printStackTrace();
        }
		
	}

}
