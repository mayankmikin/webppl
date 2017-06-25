package com.studybro.services;



import java.util.List;

import org.springframework.data.neo4j.annotation.Query;

import com.studybro.model.VideoUrlNeo;


public interface VideoService 
{
	VideoUrlNeo create(VideoUrlNeo videourl);
	   void delete(VideoUrlNeo videourl);		
	   VideoUrlNeo findById(long id);		
	   List<VideoUrlNeo> findAll();
	   List<VideoUrlNeo> findAllBySubjectName(String subname);
	   VideoUrlNeo findByname(String videoname);
	  /* @Query("MATCH p=(v:VideoUrlNeo)-[r:CLASS_IS]->(c:ClassName)"+
				"where c.classname={0}"+
				"RETURN v LIMIT 25")*/
	   List<VideoUrlNeo>findAllByClassName(String classname);
}
