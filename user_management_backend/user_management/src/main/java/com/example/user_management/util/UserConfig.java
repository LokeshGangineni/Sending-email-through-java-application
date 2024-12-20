package com.example.user_management.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class UserConfig {
	@Autowired
	JavaMailSender jms;
	public void sendSimpleEmail(String email)
	{
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom("lokeshgangineni1329@gmail.com");
		smm.setTo(email);
		smm.setSubject("Regestering in website ");
		smm.setText("Thank u for regestring in our website \n regards");
		
		jms.send(smm);
	}
	public void loginSuccess(String email)
	{
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom("lokeshgangineni1329@gmail.com");
		smm.setTo(email);
		smm.setSubject("login successful ");
		smm.setText("Thank u for login in our website \n regards");
		
		jms.send(smm);
	}
	public void passwordWrong(String email)
	{
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom("lokeshgangineni1329@gmail.com");
		smm.setTo(email);
		smm.setSubject("password is wrong ");
		smm.setText("Please check ur password");
		
		jms.send(smm);
	}
	public void emailWrong(String email)
	{
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom("lokeshgangineni1329@gmail.com");
		smm.setTo(email);
		smm.setSubject("Email is wrong ");
		smm.setText("Please check ur em ail");
		
		jms.send(smm);
	}

}
