package com.studybro.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class RememberMeToken 
{
	@GraphId
	private Long id;
	private String username;
	@Index
    private String series;
	private String tokenValue;
	private Date date;

	
	public RememberMeToken(PersistentRememberMeToken token){
		
		        this.series = token.getSeries();
		
		        this.username = token.getUsername();
		
		        this.tokenValue = token.getTokenValue();
		
		        this.date = token.getDate();
		
		    }


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


	public String getSeries() {
		return series;
	}


	public void setSeries(String series) {
		this.series = series;
	}


	public String getTokenValue() {
		return tokenValue;
	}


	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public RememberMeToken() {
		super();
		// TODO Auto-generated constructor stub
	}

}
