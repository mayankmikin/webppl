package com.studybro.services;



import java.util.List;

import com.studybro.model.VideoUrlNeo;


public interface VideoService 
{
	VideoUrlNeo create(VideoUrlNeo profile);
	   void delete(VideoUrlNeo profile);		
	   VideoUrlNeo findById(long id);		
	   List<VideoUrlNeo> findAll();

}
