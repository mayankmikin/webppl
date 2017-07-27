package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.Subject;

// below line directly maps urls ro restful services - skipping the controllers

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "subjects", path = "subjects")
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long>
{

	/*@Query("MATCH (n:SubjectName) RETURN n LIMIT 25")
	List<SubjectName>findAllSubjectNames();*/
}
