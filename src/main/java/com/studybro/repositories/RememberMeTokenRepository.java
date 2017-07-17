package com.studybro.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.studybro.model.RememberMeToken;

public interface RememberMeTokenRepository extends PagingAndSortingRepository<RememberMeToken, Long>{

	RememberMeToken findBySeries(String series);

	List<RememberMeToken> findByUsername(String username);

}
