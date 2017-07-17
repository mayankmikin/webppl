package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.TabManager;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "tabs", path = "tabs")
public interface TabManagerRepository extends PagingAndSortingRepository<TabManager, Long> 
{
	
}
