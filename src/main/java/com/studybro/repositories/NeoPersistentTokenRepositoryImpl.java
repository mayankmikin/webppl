package com.studybro.repositories;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.studybro.controllers.VideoOperationsController;
import com.studybro.model.RememberMeToken;

public class NeoPersistentTokenRepositoryImpl implements
		PersistentTokenRepository {

	public static final Logger logger = LoggerFactory.getLogger(NeoPersistentTokenRepositoryImpl.class);
	private final RememberMeTokenRepository rememberMeTokenRepository;
	
	public NeoPersistentTokenRepositoryImpl(
			RememberMeTokenRepository rememberMeTokenRepository) {
		super();
		this.rememberMeTokenRepository = rememberMeTokenRepository;
	}

	
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		RememberMeToken newToken = new RememberMeToken(token);
		logger.info("new Remember me token created");
		        this.rememberMeTokenRepository.save(newToken);


	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		RememberMeToken token = this.rememberMeTokenRepository.findBySeries(seriesId);

	return new PersistentRememberMeToken(token.getUsername(), token.getSeries(), token.getTokenValue(), token.getDate());
	}

	@Override
	public void removeUserTokens(String username) {
		 List<RememberMeToken> tokens = this.rememberMeTokenRepository.findByUsername(username);
		  this.rememberMeTokenRepository.delete(tokens);


	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) 
	{
		RememberMeToken token = this.rememberMeTokenRepository.findBySeries(series);
		
		if (token != null)
		{
	
		   token.setTokenValue(tokenValue);
	
		   token.setDate(lastUsed);
		
		   this.rememberMeTokenRepository.save(token);

		 }


	}

}
