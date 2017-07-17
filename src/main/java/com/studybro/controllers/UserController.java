package com.studybro.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.model.User;
import com.studybro.security.AccountCredentials;
import com.studybro.services.EmailService;
import com.studybro.services.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:8080" , maxAge = 3600)
@CrossOrigin
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userservice;
	@Autowired
	EmailService emailservice;
	@Autowired
	PasswordEncoder bcryptencoder;
	 static final long EXPIRATIONTIME = 864_000_000; // 10 days
	  static final String SECRET = "ThisIsASecret";
	  static final String TOKEN_PREFIX = "Bearer";
	  static final String HEADER_STRING = "Authorization";
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		user.setPassword(bcryptencoder.encode(user.getPassword()));
		User u=userservice.registerUser(user);
		try {
			emailservice.sendmail(SbConstant.EmailType.CONFIRMATION_SUBJECT,SbConstant.EmailType.CONFIRMATION_ACCOUNT,u);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	@RequestMapping(value="/addFriend",method = RequestMethod.POST)
	public User adduser(@RequestParam String username,
			@RequestParam String friendname)
	{
		User u=userservice.findUserByUserName(username);
		if(u!=null)
		{
			userservice.addFriend(friendname, u);
		}

		return u;
	}
	@RequestMapping(value = "role/{role}", method = RequestMethod.GET)
	public Boolean login(@PathVariable final String role,
			final HttpServletRequest request) throws ServletException {
		final Claims claims = (Claims) request.getAttribute("claims");

		return ((List<String>) claims.get("roles")).contains(role);
	}
    
	
/*	@RequestMapping(value="/login",method = RequestMethod.POST)
	public LoginResponse login(@RequestBody AccountCredentials user, HttpServletResponse res)
	{
		User u=userservice.login(user.getEmailid(), user.getPassword());
		System.out.println("login called "+user.getEmailid());
		if(u==null)
		{
			System.out.println("user not found");
			return null;
		}
		return new LoginResponse(Jwts.builder().setSubject(u.getEmail())
				 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
	            .claim("roles",u.getEmail()).setIssuedAt(new Date())
	             .signWith(SignatureAlgorithm.HS512, SECRET)
	            .compact());

	}*/
	@RequestMapping("/users")
	  public @ResponseBody String getUsers() {
	    return "{\"users\":[{\"firstname\":\"Mayank\", \"lastname\":\"Verma\"}," +
	           "{\"firstname\":\"Mikkin\",\"lastname\":\"Singh\"}]}";
	  }
	 @SuppressWarnings("unused")
	    private static class LoginResponse {
	        public String token;

	        public LoginResponse(final String token) {
	            this.token = token;
	        }
	    }
}
