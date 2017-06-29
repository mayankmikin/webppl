package com.studybro.services;

import javax.mail.MessagingException;

import com.studybro.model.User;

public interface EmailService 
{
	public void sendmail(String subject,String mailtype ,User user)throws MessagingException;
}
