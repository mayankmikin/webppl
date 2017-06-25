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
		return  repo.save(new SubjectName(subname));
	}

	@Override
	public void delete(SubjectName subname) {
		// TODO Auto-generated method stub
		repo.delete(subname);
	}

	@Override
	public SubjectName findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SubjectName findBySubName(String subname) {
		// TODO Auto-generated method stub
		List<SubjectName> allsubjects=(List<SubjectName>) repo.findAll();
		SubjectName sub=null;
		for(SubjectName s:allsubjects)
		{
			if(s.getSubname().equalsIgnoreCase(subname))
			{
				sub=s;
				break;
			}
		}
		// can give null pointer Exception
		return sub;
	}

	@Override
	public List<SubjectName> findAll() {
		// TODO Auto-generated method stub
		//System.out.println(repo.findAll());
		return (List<SubjectName>) repo.findAll();
	}

	@Override
	public SubjectName createwithrelationship(SubjectName subObj) {
		
		return repo.save(subObj);
	}


/*	public List<String> findAllSubjectNames() 
	{
		// TODO Auto-generated method stub
		List<SubjectName> sublist=repo.findAllSubjectNames();
		List<String> subnames=new ArrayList<String>();
		for(SubjectName sub:sublist)
		{
			subnames.add(sub.getSubname());
		}
		return  subnames;
	}*/
	
	
}
