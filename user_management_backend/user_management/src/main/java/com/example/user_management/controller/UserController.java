package com.example.user_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_management.dao.UserDao;
import com.example.user_management.dto.User;
import com.example.user_management.service.UserService;
import com.example.user_management.util.ResponseStructure;
import com.example.user_management.util.UserConfig;
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
@RestController
public class UserController {

	
	@Autowired
	UserService userService;
	@Autowired
	UserConfig userConfig;
	@Autowired
	UserDao userDao;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure> save(@RequestBody User user)
	{
		sendHtmlMsg(user.getEmail());
		System.out.println("controller");
		return userService.saveUser(user);
		
	}
	@GetMapping("/login")							
	public ResponseEntity<ResponseStructure> login(@RequestParam String email,@RequestParam String password)
	{
		return userService.loginUser(email,password);
		
	}
	
	
	public String sendHtmlMsg(String  email)
	{
		try
		{
			userConfig.sendSimpleEmail(email);
			return "Sent successfulli";
		}
		catch (Exception e) {
			return "internal issue";
		}
	}

}
