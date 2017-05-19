package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.VideoUrlNeo;

// below line directly maps urls ro restful services
//@RepositoryRestResource(collectionResourceRel = "video", path = "people")
public interface VideoRepository extends PagingAndSortingRepository<VideoUrlNeo, Long>
{

}
