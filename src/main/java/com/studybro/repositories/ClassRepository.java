package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "classes", path = "classes")
public interface ClassRepository extends PagingAndSortingRepository<com.studybro.model.Class, Long>
{

}
