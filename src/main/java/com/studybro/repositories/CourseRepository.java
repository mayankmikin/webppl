package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studybro.model.Course;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "courses", path = "courses")
public interface CourseRepository extends PagingAndSortingRepository<Course, Long>
{

}
