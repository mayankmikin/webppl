package com.studybro.services;

import com.studybro.model.User;
import com.studybro.model.VideoUrlNeo;

public interface UserService 
{
	User findUserByUserName(String name);
	
	String deactivteUser(User username);
	
	String deactivteUserbyName(String username);
	
	User addFriend(String friend,User user);
	User addWatchedVideo(VideoUrlNeo url);
	User addFavouriteVideo(VideoUrlNeo url);
	User getUserByEmailID(String email);
	User login(String email, String password);
	User registerUser(User user);
	
}
