package com.studybro.security;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountCredentials implements Serializable
{
	private String emailid;
    private String password;

    @JsonCreator
    public AccountCredentials(@JsonProperty("emailid") String emailid, @JsonProperty("password") String password) {
        this.emailid = emailid;
        this.password = password;
    }

    public String getEmailid() {
		return emailid;
	}



	public String getPassword() {
        return password;
    }

    
	  
	  
}
