package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDAOJdbc implements FlashcardDAO {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	private Flashcard getFlashcardFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("flashcardid");
		String question = rs.getString("question");
		String answer = rs.getString("answer");
		return new Flashcard(id, question, answer);
	}

	@Override
	public void badSave(Flashcard fc) {
		log.debug("attempting to save new flashcard");
		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.cixj48tduq7e.us-west-2.rds.amazonaws.com:1521:ORCL", "flashcard", "p4ssw0rd")) {
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO flashcard (question, answer) VALUES ('" + fc.getQuestion() + "', '"
					+ fc.getAnswer() + "')");
			log.info("user saved flashcard");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("failed to save flashcard");
		}
	}

	@Override
	public int betterSave(Flashcard fc) {
		log.debug("attempting to save a new flashcard with a prepared statement");
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO flashcard (question, answer) VALUES (?, ?)",
					new String[] { "flashcardid", "question" });
			ps.setString(1, fc.getQuestion());
			ps.setString(2, fc.getAnswer());
			ps.executeQuery();
			// log.trace(colsAffected + " columns were inserted");

			// get columns actualy saved in the database
			ResultSet keys = ps.getGeneratedKeys();
			if (keys.next()) {
				log.trace("row inserted has id: " + keys.getInt(1) + "\nand question: " + keys.getString(2));
				log.info("successfully added flashcard");
				return keys.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("failed to add flashcard");

		}
		return 0;
	}

	@Override
	public int storedProcedureSave(Flashcard fc) {
		log.debug("attempting to save a new flashcard with a stored procedure");
		try (Connection conn = conUtil.getConnection()) {
			CallableStatement cs = conn.prepareCall("call betterinsertcard(?,?,?)");
			cs.setString(1, fc.getQuestion());
			cs.setString(2, fc.getAnswer());
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.execute();
			log.info("successfully added flashcard with id: " + cs.getInt(3));
			return cs.getInt(3);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("failed to add flashcard");
			return 0;
		}
	}

	@Override
	public List<Flashcard> findAll() {
		List<Flashcard> flashcards = new ArrayList<>();
		log.debug("attempting to retreive all flashcards");
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM flashcard");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("flashcardid");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				flashcards.add(new Flashcard(id,question,answer));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all flashcards");
		}

		return flashcards;
	}

	@Override
	public Flashcard findById(int id) {
		log.debug("attempting to retreive flashcard with id: " + id);
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM flashcard WHERE flashcardid = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return getFlashcardFromResultSet(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive flashcard");
			
		}
		return null;
	}

}
