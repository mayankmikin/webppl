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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studybro.model.MenuItem;

@CrossOrigin
@RestController
@RequestMapping("/adminmenu")
public class AdminController 
{
	
	public static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<MenuItem> createNewMenuItem(@RequestBody MenuItem menuitem )
	{
		logger.info("creating menu item list as ");
		
		return new ResponseEntity(menuitem, HttpStatus.OK);
	}
}
