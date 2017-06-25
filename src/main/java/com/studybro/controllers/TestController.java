package com.studybro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.repositories.SubjectRepository;
import com.studybro.repositories.Test1Repository;
import com.studybro.repositories.Test2Repository;

@RestController
@RequestMapping("/test")
public class TestController 
{
	@Autowired
	Test1Repository test1repo;
	
	@Autowired
	Test2Repository test2repo;
	
	
	@RequestMapping(value = "/video/create", method = RequestMethod.POST)
	public String createVideoUrl(@RequestParam(value="videourl", required=true) String videourl,
			@RequestParam(value="videoname", required=true) String videoname,
			@RequestParam(value="subjectname", required=true) String subname,
			@RequestParam(value="classname", required=true) String classname,
			@RequestParam(value="semester", required=true) String semester) 
	{
		
		
		
		return "created";
	}
	

}
