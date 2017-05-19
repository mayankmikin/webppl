package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.SubjectName;

// below line directly maps urls ro restful services
//@RepositoryRestResource(collectionResourceRel = "video", path = "people")
public interface SubjectRepository extends PagingAndSortingRepository<SubjectName, Long>
{

}
