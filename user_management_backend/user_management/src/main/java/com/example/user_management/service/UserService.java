package com.example.user_management.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.user_management.dao.UserDao;
import com.example.user_management.dto.User;
import com.example.user_management.util.ResponseStructure;
import com.example.user_management.util.ResponseStructure.ResponseStructureBuilder;




@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public ResponseEntity<ResponseStructure> saveUser(User user)
	{
		ResponseStructure structure= ResponseStructure
				.builder()
				.msg("User data saved successfull")
				.status(HttpStatus.CREATED.value())
				.data(userDao.SaveUser(user))
				.dateTime(LocalDateTime.now())
				.build();
		System.out.println("service");
	
		return new ResponseEntity<ResponseStructure>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure> loginUser(String email,String password)
	{
		ResponseStructure structure= ResponseStructure
				.builder()
				.msg("User data found successfull")
				.status(HttpStatus.FOUND.value())
				.data(userDao.fetchByEmail(email, password))
				.dateTime(LocalDateTime.now())
				.build();
		
		return new ResponseEntity<ResponseStructure>(structure,HttpStatus.FOUND);
	}

}
