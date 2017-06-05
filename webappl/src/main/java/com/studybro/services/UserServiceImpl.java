package com.studybro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybro.model.User;
import com.studybro.model.VideoUrlNeo;
import com.studybro.repositories.UserRepository;

@Service("userservice")
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository repo;
	@Override
	public User findUserByName(String name) {
		
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
		User u=findUserByName(friend);
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
		
		return repo.save(user);
	}

}
