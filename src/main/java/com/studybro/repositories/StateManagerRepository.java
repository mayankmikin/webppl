package com.studybro.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.StateManager;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "state", path = "state")
public interface StateManagerRepository extends PagingAndSortingRepository<StateManager, Long>
{
	
	List<StateManager> findBystatename(@Param("statename") String statename);
	
}
