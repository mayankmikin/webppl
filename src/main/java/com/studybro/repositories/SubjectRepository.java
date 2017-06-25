package com.studybro.repositories;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.SubjectName;

// below line directly maps urls ro restful services
//@RepositoryRestResource(collectionResourceRel = "video", path = "people")
public interface SubjectRepository extends PagingAndSortingRepository<SubjectName, Long>
{

	/*@Query("MATCH (n:SubjectName) RETURN n LIMIT 25")
	List<SubjectName>findAllSubjectNames();*/
}
