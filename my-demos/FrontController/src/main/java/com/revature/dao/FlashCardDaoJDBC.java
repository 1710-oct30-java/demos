package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.FlashCard;
import com.revature.util.ConnectionUtil;

public class FlashCardDaoJDBC implements FlashCardDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	private FlashCard extractFlashCard(ResultSet rs) throws SQLException {
		FlashCard fc = new FlashCard();
		fc.setFlashCardId(rs.getInt("flashcard_id"));
		fc.setQuestion(rs.getString("question"));
		fc.setAnswer(rs.getString("answer"));
		fc.setUserId(rs.getInt("user_id"));
		return fc;
	}

	@Override
	public List<FlashCard> findByUserId(int userId) {
		List<FlashCard> cards = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM flashcard WHERE user_id=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				FlashCard fc = extractFlashCard(rs);
				cards.add(fc);
			}

			return cards;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
