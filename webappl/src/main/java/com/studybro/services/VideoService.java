package com.studybro.services;



import java.util.List;

import com.studybro.model.VideoUrlNeo;


public interface VideoService 
{
	VideoUrlNeo create(VideoUrlNeo videourl);
	   void delete(VideoUrlNeo videourl);		
	   VideoUrlNeo findById(long id);		
	   List<VideoUrlNeo> findAll();
	   List<VideoUrlNeo> findAllBySubjectName(String subname);
	   VideoUrlNeo findByname(String videoname);
}
