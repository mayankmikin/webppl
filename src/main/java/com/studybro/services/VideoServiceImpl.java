package com.studybro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybro.model.VideoUrlNeo;
import com.studybro.repositories.VideoRepository;

@Service("videoservice")
public class VideoServiceImpl implements VideoService 
{

	@Autowired
	VideoRepository repo;
	
	
	
	@Override
	public VideoUrlNeo create(VideoUrlNeo video) {
		// TODO Auto-generated method stub
		return repo.save(video);
	}

	@Override
	public void delete(VideoUrlNeo video) {
		// TODO Auto-generated method stub
		repo.delete(video);
	}

	@Override
	public VideoUrlNeo findById(long id) {
		// TODO Auto-generated method stub
		return repo.findOne(id);
	}

	@Override
	public List<VideoUrlNeo> findAll() {
		// TODO Auto-generated method stub
		List<VideoUrlNeo> allList=(List<VideoUrlNeo>) repo.findAll(); 
		return allList;
	}

}
