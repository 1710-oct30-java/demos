package com.revature.dao;

import java.util.List;

import com.revature.beans.FlashCard;

public interface FlashCardDao {
	List<FlashCard> findByUserId(int userId);
}
