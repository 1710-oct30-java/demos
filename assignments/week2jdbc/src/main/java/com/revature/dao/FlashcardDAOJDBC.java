package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDAOJDBC implements FlashcardDAO {
	private static ConnectionUtil conUtil = ConnectionUtil.getConUtil();

	@Override
	public void procedureSave(Flashcard fc) {

		try (Connection conn = conUtil.getConnection()) {
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO FLASHCARD (question,answer) VALUES ('" + fc.getQuestion() + "','" + fc.getAnswer()
					+ "')");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void preparedProcedureSave(Flashcard fc) {

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO FLASHCARD (question,answer) VALUES (?,?)");
			stmt.setString(1, fc.getQuestion());
			stmt.setString(2, fc.getAnswer());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int storedProcedureSave(Flashcard fc) {
		try (Connection conn = conUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("call betterinsetcard(?,?,?)");
			stmt.setString(1, fc.getQuestion());
			stmt.setString(2, fc.getAnswer());
			stmt.registerOutParameter(3, java.sql.Types.INTEGER);
			stmt.execute();
			return (stmt.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Flashcard> findall() {
		List<Flashcard> fcList = new ArrayList<>();
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM flashcard");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("flashcardid");
				String question =  rs.getString("question");
				String answer = rs.getString("answer");
				fcList.add(new Flashcard(id,question,answer));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fcList;
	}

	@Override
	public Flashcard findById(int id) {
		Flashcard fc = new Flashcard();
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM flashcard WHERE flashcardid = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int newid = rs.getInt("flashcardid");
				String question =  rs.getString("question");
				String answer = rs.getString("answer");
				fc = new Flashcard(id,question,answer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fc;
	}

}
