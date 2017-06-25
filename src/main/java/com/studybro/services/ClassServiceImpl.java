package com.studybro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybro.model.ClassName;
import com.studybro.repositories.ClassRepository;

@Service("classservice")
public class ClassServiceImpl  implements ClassService
{
	@Autowired
	ClassRepository repo;
	
	@Override
	public ClassName create(String classname) {
		// TODO Auto-generated method stub
		return repo.save(new ClassName(classname));
	}

	@Override
	public void delete(ClassName classname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClassName findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassName findByClassName(String classname) {
		// TODO Auto-generated method stub
		ClassName cls=null;
		for(ClassName c:repo.findAll())
		{
			if(classname.equals(c.getClassname()))
			{
				cls=c;
			}
		}
		return cls;
	}

	@Override
	public List<ClassName> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassName createwithrelationship(ClassName classname) {
		// TODO Auto-generated method stub
		return repo.save(classname);
	}

}
