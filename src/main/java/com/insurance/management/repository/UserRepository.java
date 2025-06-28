package com.insurance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.management.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// @Query(value = "select * from users u where username=?1", nativeQuery = true)
	User findByUsername(String username);

	// @Query(value = "select * from users u where username=?1", nativeQuery = true)
	boolean existsByUsername(String username);

}
