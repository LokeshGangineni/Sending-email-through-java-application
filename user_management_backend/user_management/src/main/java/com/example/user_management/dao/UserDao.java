package com.example.user_management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user_management.dto.User;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.util.UserConfig;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserConfig userConfig;
	
	
	public User SaveUser(User user)
	{
		
		System.out.println("dao");
		return userRepository.save(user);
	}
	public String fetchByEmail(String email,String password)
	{
		User user=userRepository.fetchByEmail(email);
		if(user!=null) {
			if(user.getPassword().equals(password)){
				loginsuccess(email);
				return "login success";
			}
			else
			{
				passwordInvalid(email);
				return "password mismatch";
			}
		}
		else
		{
			EmailInvalid(email);
			return "user email is not registered";
		}
	}
	
	
	
	public String loginsuccess(String  email)
	{
		try
		{
			userConfig.loginSuccess(email);
			return "Sent successfulli";
		}
		catch (Exception e) {
			return "internal issue";
		}
	}
	public String passwordInvalid(String  email)
	{
		try
		{
			userConfig.passwordWrong(email);
			return "Sent successfulli";
		}
		catch (Exception e) {
			return "internal issue";
		}
	}
	public String EmailInvalid(String  email)
	{
		try
		{
			userConfig.emailWrong(email);
			return "Sent successfulli";
		}
		catch (Exception e) {
			return "internal issue";
		}
	}

}
