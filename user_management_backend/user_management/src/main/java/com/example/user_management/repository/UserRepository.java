package com.example.user_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.user_management.dto.User;


public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("select a from User a where email=?1")
	User fetchByEmail(String email);

}

