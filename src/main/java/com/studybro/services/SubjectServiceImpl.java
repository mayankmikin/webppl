package com.studybro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybro.model.SubjectName;
import com.studybro.repositories.SubjectRepository;
@Service("subservice")
public class SubjectServiceImpl implements SubjectService 
{

	@Autowired
	SubjectRepository repo;

	@Override
	public SubjectName create(String subname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SubjectName subname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubjectName findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectName findBySubName(String subname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectName> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectName createwithrelationship(SubjectName subObj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
