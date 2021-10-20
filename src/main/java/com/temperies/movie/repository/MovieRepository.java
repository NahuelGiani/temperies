package com.temperies.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temperies.movie.jpa.Company;
import com.temperies.movie.jpa.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	public List<Movie> findAllByCompany(Company company);
}
