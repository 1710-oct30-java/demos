package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByCredUsernameAndCredPassword(String username, String password);

	List<User> findByCredUsernameStartingWith(String letter);

	List<User> findByIdBetweenOrderByCredUsername(int one, int two);
}
