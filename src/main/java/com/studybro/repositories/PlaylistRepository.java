package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.ClassName;
import com.studybro.model.Playlists;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "playlists", path = "playlists")
public interface PlaylistRepository extends PagingAndSortingRepository<Playlists, Long>
{

}
