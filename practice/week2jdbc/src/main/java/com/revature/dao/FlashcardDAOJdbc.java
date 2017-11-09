package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDAOJdbc implements FlashcardDAO
{
	private ConnectionUtil conUtil =  ConnectionUtil.getConnectionUtil();

	public void save(Flashcard fc)
	{
		// Standard statement
		try (Connection conn = conUtil.getConnection())
		{
			Statement stmt = conn.createStatement();
			stmt.executeQuery("INSERT INTO flashcard (question, answer) VALUES ('" + fc.getQuestion() + "', '" + fc.getAnswer() + "')");
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Flashcard> findAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Flashcard findById()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void betterSave(Flashcard fc)
	{
		try (Connection conn = conUtil.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO flashcard (question, answer) VALUES (?, ?)", new String[] {"flashcardid", "question"});
			ps.setString(1, fc.getQuestion());
			ps.setString(2, fc.getAnswer());
			ps.executeQuery();
			
			ResultSet keys = ps.getGeneratedKeys();
			while(keys.next())
			{
				System.out.println(keys.getString(1) + " - " + keys.getInt(2));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
