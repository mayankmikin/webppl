package com.studybro.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class User 
{
	@GraphId
	private Long id;
	@NotNull
	private String username;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String phonenumber;
	
	private Set<Roles>roles= new HashSet<Roles>();
	
	private Set<VideoUrlNeo> watched;
	
	private Set<VideoUrlNeo> favourite;

	private Set<VideoUrlNeo> playlist;
	
	private Set<User> friends;
	
	private String accountStatus="D";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Set<VideoUrlNeo> getWatched() {
		return watched;
	}

	public void setWatched(Set<VideoUrlNeo> watched) {
		this.watched = watched;
	}

	public Set<VideoUrlNeo> getFavourite() {
		return favourite;
	}

	public void setFavourite(Set<VideoUrlNeo> favourite) {
		this.favourite = favourite;
	}

	public Set<VideoUrlNeo> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Set<VideoUrlNeo> playlist) {
		this.playlist = playlist;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
}
