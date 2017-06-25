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
	
	private String firstName;
	private String lastName;
	
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
	
	private Set<VideoUrlNeo> watched= new HashSet<>();
	
	private Set<VideoUrlNeo> favourite= new HashSet<>();

	private Set<VideoUrlNeo> playlist= new HashSet<>();
	
	private Set<User> friends= new HashSet<>();
	
	private String accountStatus="D";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((favourite == null) ? 0 : favourite.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result
				+ ((playlist == null) ? 0 : playlist.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((watched == null) ? 0 : watched.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favourite == null) {
			if (other.favourite != null)
				return false;
		} else if (!favourite.equals(other.favourite))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (playlist == null) {
			if (other.playlist != null)
				return false;
		} else if (!playlist.equals(other.playlist))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (watched == null) {
			if (other.watched != null)
				return false;
		} else if (!watched.equals(other.watched))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", phonenumber=" + phonenumber
				+ ", roles=" + roles + ", watched=" + watched + ", favourite="
				+ favourite + ", playlist=" + playlist + ", friends=" + friends
				+ ", accountStatus=" + accountStatus + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String firstName, String lastName, String username,
			String email, String password, String phonenumber,
			Set<Roles> roles, Set<VideoUrlNeo> watched,
			Set<VideoUrlNeo> favourite, Set<VideoUrlNeo> playlist,
			Set<User> friends, String accountStatus) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.roles = roles;
		this.watched = watched;
		this.favourite = favourite;
		this.playlist = playlist;
		this.friends = friends;
		this.accountStatus = accountStatus;
	}

	


	
	
}
