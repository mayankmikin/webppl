package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.ChapterOrUniversity;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "chap_university", path = "chap_university")
public interface ChapterOrUniversityRepository extends PagingAndSortingRepository<ChapterOrUniversity, Long>
{
	 /*if we want to implement hateoas with seacrh parameter 
	 we need to make sure the method name and params are accour ding to the rule 
	 which says 
	 method name for search should be 
	 findBy + "nameofjavavariable" 
	 no cmael case allowed*/
}
