package com.studybro.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.studybro.model.Roles;
import com.studybro.model.User;
import com.studybro.model.VideoUrlNeo;
import com.studybro.repositories.UserRepository;

@Service("userservice")
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository repo;
	@Autowired
	PasswordEncoder bcryptencoder;
	@Override
	public User findUserByUserName(String name) {
		
		List<User>allusers=(List<User>) repo.findAll();
		for(User u:allusers)
		{
			if(u.getUsername().equals(name))
			{
				return u;
			}
		}
		return null;
	}

	@Override
	public String deactivteUser(User username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deactivteUserbyName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addFriend(String friend,User user) 
	{
		User u=findUserByUserName(friend);
		//u.getFriends().add(user);
		user.getFriends().add(u);
		
		return repo.save(user);
	}

	@Override
	public User addWatchedVideo(VideoUrlNeo url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addFavouriteVideo(VideoUrlNeo url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerUser(User user) {
		Roles r = new Roles();
		user.getRoles().add(r);
		return repo.save(user);
	}

	@Override
	public User getUserByEmailID(String email) 
	{
		List<User>allusers=(List<User>) repo.findAll();
		for(User u:allusers)
		{
			if(u.getEmail().equals(email))
			{
				return u;
			}
		}
	
		return null;
	}

	@Override
	public User login(String email, String password) {
System.out.println("email is "+email);
		User u=getUserByEmailID(email);
		System.out.println("password from api is ");
		System.out.println(password);
		System.out.println("password in db is ");
		System.out.println(u.getPassword());
		if(bcryptencoder.matches(password, u.getPassword()))
		{
			return u;
		}
		return null;
	}

}
