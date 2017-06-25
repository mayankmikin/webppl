package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.MenuItem;
import com.studybro.model.Test2;

public interface MenuRepository extends PagingAndSortingRepository<MenuItem, Long>
{

}
