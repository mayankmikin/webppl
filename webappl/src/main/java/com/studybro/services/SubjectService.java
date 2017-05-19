package com.studybro.services;

import java.util.List;

import com.studybro.model.SubjectName;

public interface SubjectService 
{
	   SubjectName create(String subname);
	   void delete(SubjectName subname);		
	   SubjectName findById(Long id);
	   SubjectName findBySubName(String subname);	
	   List<SubjectName> findAll();

}
