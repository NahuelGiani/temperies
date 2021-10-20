package com.temperies.movie.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.temperies.movie.jpa.Company;
import com.temperies.movie.jpa.Movie;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer>{
	
    public List<Movie> findAll();

	public List<Movie> findAllByCompany(Company company);
}
