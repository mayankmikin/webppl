package com.studybro.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
	
}
