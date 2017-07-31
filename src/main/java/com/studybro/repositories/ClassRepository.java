package com.studybro.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.ClassOrSemName;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "classes", path = "classes")
public interface ClassRepository extends PagingAndSortingRepository<ClassOrSemName, Long>
{
	 /*if we want to implement hateoas with seacrh parameter 
	 we need to make sure the method name and params are accour ding to the rule 
	 which says 
	 method name for search should be 
	 findBy + "nameofjavavariable" 
	 no cmael case allowed*/
	List<ClassOrSemName> findByclassname(@Param("classname") String classname);
}
