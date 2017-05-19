package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.AcademicLevel;
import com.studybro.model.SubjectName;
import com.studybro.model.VideoUrlNeo;

// below line directly maps urls ro restful services
//@RepositoryRestResource(collectionResourceRel = "video", path = "people")
public interface AlevelRepository extends PagingAndSortingRepository<AcademicLevel, Long>
{

}
