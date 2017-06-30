package com.studybro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;

import com.studybro.model.User;

@SpringBootApplication
public class WebapplApplication 
{
	
	
	public static void main(String[] args) 
	{
		SpringApplication.run(WebapplApplication.class, args);
	}
	
}
