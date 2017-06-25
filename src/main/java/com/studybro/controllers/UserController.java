package com.studybro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.model.User;
import com.studybro.services.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:8080" , maxAge = 3600)
@CrossOrigin
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userservice;

	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User u=userservice.registerUser(user);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	@RequestMapping(value="/addFriend",method = RequestMethod.POST)
	public ResponseEntity<User> adduser(@RequestParam String username,
			@RequestParam String friendname)
	{
		User u=userservice.findUserByName(username);
		if(u!=null)
		{
			userservice.addFriend(friendname, u);
		}
		
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ResponseEntity<User> login(@RequestParam String emailid, @RequestParam String password)
	{
		User u=userservice.login(emailid, password);
		if(u==null)
		{
			return new ResponseEntity<User>(u,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
}
