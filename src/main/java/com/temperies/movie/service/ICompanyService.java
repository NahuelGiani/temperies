package com.temperies.movie.service;

import java.util.List;

import com.temperies.movie.dto.CompanyDTO;
import com.temperies.movie.dto.MovieDTO;

public interface ICompanyService {

	public List<CompanyDTO> findAll();
	
	public CompanyDTO findById(Integer id);
	
	public List<MovieDTO> findMoviesByCompanyId(Integer id);
	
}
