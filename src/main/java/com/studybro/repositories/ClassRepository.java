package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.ClassName;

public interface ClassRepository extends PagingAndSortingRepository<ClassName, Long>
{

}
