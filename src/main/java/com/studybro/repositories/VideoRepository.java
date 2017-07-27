package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.VideoUrlNeo;

// below line directly maps urls ro restful services

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "videos", path = "videos")
public interface VideoRepository extends PagingAndSortingRepository<VideoUrlNeo, Long>
{
	/*@Query("MATCH p=(v:VideoUrlNeo)-[r:CLASS_IS]->(c:ClassName)"+
			"where c.classname={0}"+
			"RETURN v LIMIT 25")
	List<VideoUrlNeo>findAllByClassName(String classname);
	
	@Query("MATCH p=(v:VideoUrlNeo)-[r:SUBJECT_IS]->(s:SubjectName)"+
			"where s.subname={0}"+
			"RETURN v LIMIT 25")
	List<VideoUrlNeo>findAllBySubjectName(String subjectname);*/
	
}
