package com.studybro.services;

import java.util.List;

import com.studybro.model.ClassName;

public interface ClassService 
{
	ClassName create(String classname);
	   void delete(ClassName classname);		
	   ClassName findById(Long id);
	   ClassName findByClassName(String classname);	
	   List<ClassName> findAll();
	   ClassName createwithrelationship(ClassName classname);

}
