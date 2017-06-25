package com.studybro.repositories;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.VideoUrlNeo;

// below line directly maps urls ro restful services
//@RepositoryRestResource(collectionResourceRel = "video", path = "people")
public interface VideoRepository extends PagingAndSortingRepository<VideoUrlNeo, Long>
{
	@Query("MATCH p=(v:VideoUrlNeo)-[r:CLASS_IS]->(c:ClassName)"+
			"where c.classname={0}"+
			"RETURN v LIMIT 25")
	List<VideoUrlNeo>findAllByClassName(String classname);
	
	@Query("MATCH p=(v:VideoUrlNeo)-[r:SUBJECT_IS]->(s:SubjectName)"+
			"where s.subname={0}"+
			"RETURN v LIMIT 25")
	List<VideoUrlNeo>findAllBySubjectName(String subjectname);
	
}
