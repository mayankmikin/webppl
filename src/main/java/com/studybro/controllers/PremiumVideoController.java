package com.studybro.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.model.MenuItem;
import com.studybro.model.VideoUrlNeo;

@CrossOrigin
@RestController
@RequestMapping("/premium")
public class PremiumVideoController 
{
	public static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public VideoUrlNeo  createNewMenuItem( )
	{
		logger.info("getting all premium values ");
		
		return new VideoUrlNeo();
	}
	

}
